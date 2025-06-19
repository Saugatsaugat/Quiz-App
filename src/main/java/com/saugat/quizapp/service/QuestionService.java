package com.saugat.quizapp.service;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> findQuestionsByCategory(String category){
        try {
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Question> addorUpdateQuestion(Question question) {

        try {
            return new ResponseEntity<>(repo.save(question), HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int questionId) {
        try {
            repo.deleteById(questionId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> getQuestionById(int questionId) {
        try {
            return new ResponseEntity<>(repo.findById(questionId).get(), HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
