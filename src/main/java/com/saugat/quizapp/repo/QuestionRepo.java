package com.saugat.quizapp.repo;

import com.saugat.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * from question q where q.category=:category ORDER BY RAND() LIMIT :noOfQuestion", nativeQuery = true)
    List<Question> createRandomQuizLisByCategory(String category, int noOfQuestion);

}
