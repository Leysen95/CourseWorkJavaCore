package me.skypro.CourseWorkJavaCore;

import me.skypro.CourseWorkJavaCore.model.Question;

import java.util.Collection;
import java.util.List;

public class TestData {
    public final static Question RANDOM_QUESTION_1 = new Question("Yes", "Spring has DI");

    public final static Question RANDOM_QUESTION_2 = new Question("Yes", "Spring has Ioc");

    public final static Question RANDOM_QUESTION_3 = new Question("No", "Spring has ACID");

    public static Collection<Question> getAll() {
        return List.of(RANDOM_QUESTION_1, RANDOM_QUESTION_2, RANDOM_QUESTION_3);
    }
}
