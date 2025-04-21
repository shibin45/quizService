package com.shibin.quizSerivice.service;

import com.shibin.quizSerivice.Feign.QuizInterface;
import com.shibin.quizSerivice.dao.QuizDao;
import com.shibin.quizSerivice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int questionNumber, String title) {
        //call the generate url
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,questionNumber).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIDs(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIDs();

        ResponseEntity<List<QuestionWrapper>> questionForUsers = quizInterface.getQuestionFromId(questionIds);
        return questionForUsers;

    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> response) {
        ResponseEntity<Integer> score =  quizInterface.getScore(response);
        return score;
    }
}
