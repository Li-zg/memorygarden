package life.lieren.memorygarden.controller;

import life.lieren.memorygarden.dto.CommentCreateDTO;
import life.lieren.memorygarden.dto.CommentDTO;
import life.lieren.memorygarden.dto.ResultDTO;
import life.lieren.memorygarden.enums.CommentTypeEnum;
import life.lieren.memorygarden.exception.CustomizeErrorCode;
import life.lieren.memorygarden.model.Comment;
import life.lieren.memorygarden.model.User;
import life.lieren.memorygarden.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        if(commentCreateDTO==null||commentCreateDTO.getContent()==null||commentCreateDTO.getContent()==""){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setType(commentCreateDTO.getType());
        comment.setContent(commentCreateDTO.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByParentId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
