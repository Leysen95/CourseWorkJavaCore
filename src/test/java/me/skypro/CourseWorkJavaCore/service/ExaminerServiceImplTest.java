package me.skypro.CourseWorkJavaCore.service;

import me.skypro.CourseWorkJavaCore.exception.QuestionAmountMismatchException;
import me.skypro.CourseWorkJavaCore.model.Question;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static me.skypro.CourseWorkJavaCore.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        when(javaQuestionService.getAll()).thenReturn(getAll());
    }


    @Test
    @DisplayName("Возвращает коллекцию рандомных вопросов")
    void getQuestion() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                RANDOM_QUESTION_1,
                RANDOM_QUESTION_2,
                RANDOM_QUESTION_3
        );

        int amount = 2;

        Collection<Question> actual = examinerService.getQuestion(amount);

        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, times(2)).getAll();
        verify(javaQuestionService, times(amount)).getRandomQuestion();
    }

    @Test
    @DisplayName("Возвращает все вопросы, не вызывает сервис повторно")
    void getQuestions_1() {

        int amount = 3;

        Collection<Question> actual = examinerService.getQuestion(amount);

        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, times(2)).getAll();
        verify(javaQuestionService, never()).getRandomQuestion();
    }

    @Test
    @DisplayName("Возвращает все вопросы, не вызывает сервис повторно")
    void getQuestions_2() {
        assertThatExceptionOfType(QuestionAmountMismatchException.class)
                .isThrownBy(() -> examinerService.getQuestion(4));
    }

}