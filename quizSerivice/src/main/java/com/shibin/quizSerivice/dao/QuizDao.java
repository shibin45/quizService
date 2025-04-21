package com.shibin.quizSerivice.dao;

import com.shibin.quizSerivice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer>{
}
