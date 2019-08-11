package com.zjldemo.demo.service;

import com.zjldemo.demo.Common.Page;
import com.zjldemo.demo.model.Note;

import java.util.List;

public interface NoteService {

   /**
    * 新增记事
    * @param note
    */
   void addNote(Note note);

   /**
    * 分页查询记事
    * @param pageNum
    * @param pageSize
    * @param title
    * @return
    */
   Page<Note> queryNotePageByTitle(int pageNum, int pageSize, String title);
}
