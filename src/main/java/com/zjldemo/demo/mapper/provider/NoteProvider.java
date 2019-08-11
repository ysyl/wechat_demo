package com.zjldemo.demo.mapper.provider;

import com.zjldemo.demo.model.Note;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class NoteProvider {
    public String queryNotePageByTitleAndDescription(@Param("pageOffset") int pageOffset,@Param("pageSize") int pageSize,@Param("title") String title,
                                                     @Param("description") String description) {
        return new SQL() {{
            SELECT("id, title, description, cost, create_time createTime");
            FROM("t_note");
            if (StringUtils.isNotBlank(title)) {
                WHERE("title like concat('%', #{title}, '%')");
            }
            if (StringUtils.isNotBlank(description)) {
                WHERE("description like concat('%', #{description}, '%')");
            }
            LIMIT("#{pageOffset}, #{pageSize}");
        }}.toString();
    }
}
