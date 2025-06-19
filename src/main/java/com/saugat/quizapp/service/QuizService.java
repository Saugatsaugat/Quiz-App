package com.saugat.quizapp.service;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.model.Quiz;
import com.saugat.quizapp.repo.QuestionRepo;
import com.saugat.quizapp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private QuizRepo repo;
    @Autowired
    public void setRepo(QuizRepo repo) {
        this.repo = repo;
    }

    private QuestionRepo questionRepo;
    @Autowired
    public void setQuestionRepo(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public ResponseEntity<Quiz> getRandomQuizListByCategory(String title, String category, int noOfQuestion) {
        try{
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            List<Question> questions = questionRepo.createRandomQuizLisByCategory(category, noOfQuestion);
            quiz.setQuestionList(questions);
            return new ResponseEntity<>(repo.save(quiz), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Quiz(), HttpStatus.NOT_FOUND);
    }
}
