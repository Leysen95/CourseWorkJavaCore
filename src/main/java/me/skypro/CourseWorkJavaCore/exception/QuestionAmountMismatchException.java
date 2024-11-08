package me.skypro.CourseWorkJavaCore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAmountMismatchException extends RuntimeException{
    public QuestionAmountMismatchException(int amount) {
        super("Incorrect amount of questions: %s".formatted(amount));
    }
}
