package me.skypro.CourseWorkJavaCore.model;

import java.util.Objects;

public class Question {
    private final String answer;

    private final String question;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question1)) return false;
        return Objects.equals(answer, question1.answer) && Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, question);
    }

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
