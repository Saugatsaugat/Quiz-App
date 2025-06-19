package com.saugat.quizapp.controller;

import com.saugat.quizapp.model.Quiz;
import com.saugat.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    private QuizService service;

    @Autowired
    public void setService(QuizService service) {
        this.service = service;
    }

    @GetMapping("ping")
    public String ping(){
        return "Quiz Controller";
    }

    @PostMapping("randomQuizList")
    public ResponseEntity<Quiz> getRandomQuizListByCategory(@RequestParam("title") String title, @RequestParam("category") String category, @RequestParam("noOfQuestion") int noOfQuestion ){
        return service.getRandomQuizListByCategory(title, category, noOfQuestion);
    }
}
