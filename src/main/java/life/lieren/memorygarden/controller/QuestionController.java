package life.lieren.memorygarden.controller;

import life.lieren.memorygarden.dto.QuestionDTO;
import life.lieren.memorygarden.mapper.QuestionMapper;
import life.lieren.memorygarden.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //累计评论数(应对高并发)
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
