package life.lieren.memorygarden.controller;

import life.lieren.memorygarden.dto.NotificationDTO;
import life.lieren.memorygarden.enums.NotificationTypeEnum;
import life.lieren.memorygarden.model.User;
import life.lieren.memorygarden.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            return "redirect:/";
        NotificationDTO notificationDTO = notificationService.read(id, user);

        //判断消息类型是否为评论或者问题的回复（目前只有这两种消息类型，判断是为了以后类型增加考虑）
        if (NotificationTypeEnum.REPLY_COMMENT.getType()==notificationDTO.getType()
                ||NotificationTypeEnum.REPLY_QUESTION.getType()==notificationDTO.getType()){
            return "redirect:/question/" + notificationDTO.getOuterid();
        }else {
            return "redirect:/";
        }
    }
}
