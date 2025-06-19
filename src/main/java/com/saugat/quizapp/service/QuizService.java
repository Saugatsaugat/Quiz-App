package com.saugat.quizapp.service;

import com.saugat.quizapp.model.Question;
import com.saugat.quizapp.model.Quiz;
import com.saugat.quizapp.repo.QuestionRepo;
import com.saugat.quizapp.repo.QuizRepo;
import com.saugat.quizapp.wrapper.QuestionWrapper;
import com.saugat.quizapp.wrapper.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int quizId) {
        try {
            Optional<Quiz> quiz = repo.findById(quizId);
            List<QuestionWrapper> questionForUser = new ArrayList<>();
            for (Question q : quiz.get().getQuestionList()) {
                QuestionWrapper qw = new QuestionWrapper();
                qw.setId(q.getId());
                qw.setCategory(q.getCategory());
                qw.setDifficultLevel(q.getDifficultLevel());
                qw.setOption1(q.getOption1());
                qw.setOption2(q.getOption2());
                qw.setOption3(q.getOption3());
                qw.setOption4(q.getOption4());
                qw.setQuestion(q.getQuestion());

                questionForUser.add(qw);
            }
            return new ResponseEntity<>(questionForUser, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Integer> getQuizScore(int quizId, List<QuizResponse> responses) {
        try{
            List<Question> questions = repo.findById(quizId).get().getQuestionList();
            int correct = 0;

            for(QuizResponse qr : responses){
                for(Question q: questions){
                    if(qr.getQuestionId()==q.getId() && qr.getResponse().equals(q.getAnswer())){
                        correct++;
                    }
                }
            }
            return new ResponseEntity<>(correct, HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
