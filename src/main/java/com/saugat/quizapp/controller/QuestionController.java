package com.saugat.quizapp.controller;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("question/{questionId}")
    public ResponseEntity<Question> get(@PathVariable("questionId") int questionId){
        return service.getQuestionById(questionId);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> findQuestionsByCategory(@PathVariable("category") String category){
        return service.findQuestionsByCategory(category);
    }

    @PostMapping("question")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return service.addorUpdateQuestion(question);
    }

    @PutMapping("question")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return service.addorUpdateQuestion(question);
    }

    @DeleteMapping("question/{questionId}")
    public ResponseEntity<String> delete(@PathVariable("questionId") int questionId){
        return service.deleteQuestion(questionId);
    }



}
