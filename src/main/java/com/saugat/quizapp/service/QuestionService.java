package com.saugat.quizapp.service;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepo repo;

    public QuestionRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(QuestionRepo repo) {
        this.repo = repo;
    }

    public List<Question> getAllQuestions(){
        return repo.findAll();
    }


}
