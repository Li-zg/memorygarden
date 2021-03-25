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
        tag_pool1.setTags(Arrays.asList("1","7","fas","das","dasf",",","dsafafq","grgqew","gfj","dasfgfrjwfur","==========","dgsayfaj","dasgfasggfagkfg","hello","+++++++++++++++++++++++++++++++++++++++++++++"));
        tagDTOS.add(tag_pool1);


        TagDTO tag_pool2 = new TagDTO();
        tag_pool2.setCategoryName("开发语言");
        tag_pool2.setTags(Arrays.asList("2","8"));
        tagDTOS.add(tag_pool2);

        TagDTO tag_pool3 = new TagDTO();
        tag_pool3.setCategoryName("数据库平台");
        tag_pool3.setTags(Arrays.asList("3","9"));
        tagDTOS.add(tag_pool3);

        TagDTO tag_pool4 = new TagDTO();
        tag_pool4.setCategoryName("开发工具");
        tag_pool4.setTags(Arrays.asList("4","5","6"));
        tagDTOS.add(tag_pool4);

        return tagDTOS;
    }
}
