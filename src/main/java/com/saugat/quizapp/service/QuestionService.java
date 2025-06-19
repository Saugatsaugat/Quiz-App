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

    public List<Question> findQuestionsByCategory(String category){
        return repo.findByCategory(category);
    }


    public Question addorUpdateQuestion(Question question) {
        return repo.save(question);
    }

    public String deleteQuestion(int questionId) {
        repo.deleteById(questionId);
        return "Deleted";
    }

    public Question getQuestionById(int questionId) {
        return repo.findById(questionId).get();
    }
}
