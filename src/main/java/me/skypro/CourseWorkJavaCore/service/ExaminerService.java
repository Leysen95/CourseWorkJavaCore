package me.skypro.CourseWorkJavaCore.service;

import me.skypro.CourseWorkJavaCore.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
