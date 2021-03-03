package life.lieren.memorygarden.mapper;

import life.lieren.memorygarden.model.Question;
import life.lieren.memorygarden.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
}