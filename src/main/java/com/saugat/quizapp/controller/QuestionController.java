package com.saugat.quizapp.controller;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Question> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("question/{questionId}")
    public Question get(@PathVariable("questionId") int questionId){
        return service.getQuestionById(questionId);
    }

    @GetMapping("category/{category}")
    public List<Question> findQuestionsByCategory(@PathVariable("category") String category){
        return service.findQuestionsByCategory(category);
    }

    @PostMapping("question")
    public Question add(@RequestBody Question question){
        return service.addorUpdateQuestion(question);
    }

    @PutMapping("question")
    public Question update(@RequestBody Question question){
        return service.addorUpdateQuestion(question);
    }

    @DeleteMapping("question/{questionId}")
    public String delete(@PathVariable("questionId") int questionId){
        return service.deleteQuestion(questionId);
    }



}
