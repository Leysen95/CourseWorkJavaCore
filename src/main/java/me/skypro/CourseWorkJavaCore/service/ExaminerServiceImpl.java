package me.skypro.CourseWorkJavaCore.service;

import me.skypro.CourseWorkJavaCore.exception.QuestionAmountMismatchException;
import me.skypro.CourseWorkJavaCore.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Collection<Question> allQuestions = questionService.getAll();
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new QuestionAmountMismatchException(amount);
        }
        if (amount == allQuestions.size()) {
            return allQuestions;
        }

        Set<Question> resultSet = new HashSet<>();
        while (resultSet.size() < amount) {
            resultSet.add(questionService.getRandomQuestion());
        }
        return resultSet;
    }
}
