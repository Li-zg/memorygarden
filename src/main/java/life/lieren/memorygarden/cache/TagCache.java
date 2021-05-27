package life.lieren.memorygarden.cache;

import life.lieren.memorygarden.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();

        TagDTO tag_pool1 = new TagDTO();
        tag_pool1.setCategoryName("开发框架");
        tag_pool1.setTags(Arrays.asList("Spring Boot","Spring Cloud","Vue","Node"));
        tagDTOS.add(tag_pool1);


        TagDTO tag_pool2 = new TagDTO();
        tag_pool2.setCategoryName("开发语言");
        tag_pool2.setTags(Arrays.asList("java","C","C++","C#","Python","Ruby"));
        tagDTOS.add(tag_pool2);

        TagDTO tag_pool3 = new TagDTO();
        tag_pool3.setCategoryName("数据库平台");
        tag_pool3.setTags(Arrays.asList("MySql","SqlServer","Redis","PostgreSql"));
        tagDTOS.add(tag_pool3);

        TagDTO tag_pool4 = new TagDTO();
        tag_pool4.setCategoryName("开发工具");
        tag_pool4.setTags(Arrays.asList("Visual Paradigm","LOMBOK","Flyway","Git"));
        tagDTOS.add(tag_pool4);

        return tagDTOS;
    }
}
