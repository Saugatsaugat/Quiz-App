package com.saugat.quizapp.controller;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private QuestionService service;

    public QuestionService getService() {
        return service;
    }

    @Autowired
    public void setService(QuestionService service) {
        this.service = service;
    }

    @GetMapping("ping")
    public String ping(){
        return "Question Controller";
    }

    @GetMapping("getAll")
    public List<Question> getAllQuestions(){
        return service.getAllQuestions();
    }



}
