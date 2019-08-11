package com.zjldemo.demo.mapper;

import com.zjldemo.demo.mapper.provider.NoteProvider;
import com.zjldemo.demo.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("insert into t_note (title, description, cost, create_time) values (#{note.title}, #{note.description}, #{note.cost}, #{note.createTime})")
    int insertNote(@Param("note") Note note);

//    @Select("select id, title, description, cost, create_time createTime from t_note where title like concat('%', #{title}, '%') limit #{pageNum}, #{pageSize}")
    @SelectProvider(type = NoteProvider.class, method = "queryNotePageByTitleAndDescription")
    List<Note> queryNotePageByTitle(@Param("pageOffset") int pageOffset, @Param("pageSize") int pageSize, @Param("title") String title, @Param("description") String description);
}
