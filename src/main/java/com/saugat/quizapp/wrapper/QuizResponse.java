package com.saugat.quizapp.wrapper;

public class QuizResponse {

    private int questionId;
    private String response;

    public QuizResponse() {
    }

    public QuizResponse(int questionId, String response) {
        this.questionId = questionId;
        this.response = response;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
