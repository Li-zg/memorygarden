package life.lieren.memorygarden.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//一般开发前端在js中完成，这里通过后端简单实现
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    //按钮
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNextPage;
    private boolean showLastPage;
    //页码
    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.currentPage = page;
        pages.add(page);
        //页码显示处理
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0,page-i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否显示到上一页的按钮
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否显示到下一页的按钮
        if (page == totalPage) {
            showNextPage = false;
        } else {
            showNextPage = true;
        }
        //是否显示到第一页按钮
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否显示到最后一页按钮
        if (pages.contains(totalPage)) {
            showLastPage = false;
        } else {
            showLastPage = true;
        }

    }
}
