package me.skypro.CourseWorkJavaCore.service;

import me.skypro.CourseWorkJavaCore.exception.QuestionNotFoundException;
import me.skypro.CourseWorkJavaCore.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static me.skypro.CourseWorkJavaCore.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void shouldQuestion_WhenCorrectQuestion_ThenAdd() {

        Question actual = javaQuestionService.add(RANDOM_QUESTION_1);

        Collection<Question> result = javaQuestionService.getAll();
        assertThat(result).hasSize(1);
        assertThat(result.iterator().next()).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    void shouldAddQuestion_WhenQuestionAlreadyAdded_ThenThrowException() {
        javaQuestionService.add(RANDOM_QUESTION_1);

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.add(RANDOM_QUESTION_1));

    }

    @Test
    void shouldAddQuestion_WhenAnotherQuestionAlreadyAdded_ThenAddQuestion() {
        javaQuestionService.add(RANDOM_QUESTION_2);

        assertDoesNotThrow(() -> javaQuestionService.add(RANDOM_QUESTION_1));

    }

    @Test
    void shouldQuestion_WhenCorrectQuestionAndAnswer_ThenAdd() {
        String question = "Spring has DI";
        String answer = "Yes";
        Question addedQuestion = javaQuestionService.add(question, answer);

        assertThat(addedQuestion.getQuestion()).isEqualTo(question);
        assertThat(addedQuestion.getAnswer()).isEqualTo(answer);

        assertThat(javaQuestionService.getAll()).hasSize(1);

    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestion_ThenRemove() {
        javaQuestionService.add(RANDOM_QUESTION_1);

        Question actual = javaQuestionService.remove(RANDOM_QUESTION_1);

        Collection<Question> result = javaQuestionService.getAll();
        assertThat(result).isEmpty();
        assertThat(actual).isEqualTo(RANDOM_QUESTION_1);

    }

    @Test
    void shouldRemoveQuestion_WhenQuestionNotExist_ThenThrowException() {

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(RANDOM_QUESTION_1));

    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestionAndAnswer_ThenRemove() {
    }

    @Test
    void shouldReturnAllQuestions() {
        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        Collection<Question> actual = javaQuestionService.getAll();

        assertThat(actual).hasSize(3);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(getAll());
    }

    @Test
    void shouldReturnRandomQuestion() {
        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        Question actual = javaQuestionService.getRandomQuestion();

        assertThat(getAll()).contains(actual);
    }
}