package life.lieren.memorygarden.service;

import life.lieren.memorygarden.dto.NotificationDTO;
import life.lieren.memorygarden.dto.PaginationDTO;
import life.lieren.memorygarden.enums.NotificationStatusEnum;
import life.lieren.memorygarden.enums.NotificationTypeEnum;
import life.lieren.memorygarden.exception.CustomizeErrorCode;
import life.lieren.memorygarden.exception.CustomizeException;
import life.lieren.memorygarden.mapper.NotificationMapper;
import life.lieren.memorygarden.mapper.UserMapper;
import life.lieren.memorygarden.model.Notification;
import life.lieren.memorygarden.model.NotificationExample;
import life.lieren.memorygarden.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Long userId, Integer page, Integer size) {
        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO();
        NotificationExample notificationExample = new NotificationExample();
        //拿到对当前用户所有的通知的总数
        notificationExample.createCriteria()
                .andRecieverEqualTo(userId);
        Integer totalCount = (int) notificationMapper.countByExample(notificationExample);
        //判断总共页数
        if (totalCount % size == 0) {
            paginationDTO.setTotalPage(totalCount / size);
        } else {
            paginationDTO.setTotalPage(totalCount / size + 1);
        }
        //容错处理
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        paginationDTO.setPagination(totalCount, page, size);
        //size*(page-1)
        Integer offset = size * (page - 1);
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andRecieverEqualTo(userId);
        example.setOrderByClause("gmtCreate desc");

        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        if (notifications.size() == 0) {
            return paginationDTO;
        }

        //拿到对当前用户所有通知的通知发起者id
        List<NotificationDTO> notificationDTOS = new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }

        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }

    public Long unreadCount(Long userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andRecieverEqualTo(userId)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
//        防止当前登录用户查看其他用户的notification
        if (notification==null){
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        if (!Objects.equals(notification.getReciever(), user.getId())){
            throw new CustomizeException(CustomizeErrorCode.READ_UNAUTHORIZED_NOTIFICATION);
        }

        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }
}
