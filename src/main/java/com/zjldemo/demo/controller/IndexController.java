package com.zjldemo.demo.controller;

import com.zjldemo.demo.Common.Page;
import com.zjldemo.demo.Enum.EnumResponseCode;
import com.zjldemo.demo.model.Note;
import com.zjldemo.demo.model.ResponseVO;
import com.zjldemo.demo.service.NoteService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("/")
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private NoteService noteService;

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("test")
    public Page<Note> testQuery() {
        Page<Note> result = noteService.queryNotePageByTitle(0, 10, "");
        System.out.println(result);
        return result;
    }

    @GetMapping("test-insert")
    public void testInsert() {
        Note temp = new Note();
        temp.setCost(12.5);
        temp.setCreateTime(new Date());
        temp.setDescription("描述");
        temp.setTitle("title2141");
        noteService.addNote(temp);
    }

    @PostMapping("addNote")
    public ResponseVO<String> addNote(@RequestBody Note note) {
        LOG.info("enter addNote method, params: " + note);
        note.setCreateTime(new Date());
        noteService.addNote(note);
        LOG.info("end addNote");
        return ResponseVO.success(EnumResponseCode.SUCCESS.getMsg());
    }

    @GetMapping("queryNote")
    public ResponseVO<Page<Note>> queryNotePageByTitle(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                                                             @RequestParam(value = "title", defaultValue = "") String title) {
        LOG.info("enter queryNotePageByTitle");
        Page<Note> result = noteService.queryNotePageByTitle(pageNum, pageSize, title);
        return ResponseVO.success(result);
    }
}
