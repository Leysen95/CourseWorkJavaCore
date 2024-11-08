package me.skypro.CourseWorkJavaCore.controller;

import me.skypro.CourseWorkJavaCore.model.Question;
import me.skypro.CourseWorkJavaCore.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") int amount){
        return examinerService.getQuestion(amount);
    };

}
