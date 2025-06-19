package com.saugat.quizapp.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String category;
    @ManyToMany
    private List<Question> questionList;

    public Quiz(){}

    public Quiz(String title, List<Question> questionList) {
        this.title = title;
        this.questionList = questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id && Objects.equals(title, quiz.title) && Objects.equals(questionList, quiz.questionList) && Objects.equals(category, quiz.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, questionList);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questionList=" + questionList +
                ", category=" + category +
                '}';
    }
}
