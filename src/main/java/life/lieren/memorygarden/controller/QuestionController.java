package life.lieren.memorygarden.controller;

import life.lieren.memorygarden.dto.CommentDTO;
import life.lieren.memorygarden.dto.QuestionDTO;
import life.lieren.memorygarden.enums.CommentTypeEnum;
import life.lieren.memorygarden.service.CommentService;
import life.lieren.memorygarden.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id, Model model){
        //拿到问题信息
        QuestionDTO questionDTO = questionService.getById(id);
        //拿到评论信息
        List<CommentDTO> comments = commentService.listByParentId(id, CommentTypeEnum.QUESTION);
        //更新浏览数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
