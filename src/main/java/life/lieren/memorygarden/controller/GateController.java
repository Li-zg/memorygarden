package life.lieren.memorygarden.controller;

import life.lieren.memorygarden.dto.PaginationDTO;
import life.lieren.memorygarden.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GateController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String gate(
            Model model,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "15") Integer size,
            @RequestParam(name = "search", required = false) String search
    ) {
        PaginationDTO pagination = questionService.list(search, page, size);
        model.addAttribute("pagination", pagination);
        return "gate";
    }
}
