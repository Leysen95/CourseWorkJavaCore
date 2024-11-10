package me.skypro.CourseWorkJavaCore;

import me.skypro.CourseWorkJavaCore.model.Question;

import java.util.Collection;
import java.util.List;

public class TestData {
    public final static Question RANDOM_QUESTION_1 = new Question("Spring has DI", "Yes");

    public final static Question RANDOM_QUESTION_2 = new Question("Spring has Ioc", "Yes");

    public final static Question RANDOM_QUESTION_3 = new Question("Spring has ACID", "No");

    public static Collection<Question> getAll() {
        return List.of(RANDOM_QUESTION_1, RANDOM_QUESTION_2, RANDOM_QUESTION_3);
    }
}
