package com.zjldemo.demo.service.impl;

import com.zjldemo.demo.Common.Page;
import com.zjldemo.demo.mapper.NoteMapper;
import com.zjldemo.demo.model.Note;
import com.zjldemo.demo.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private static final Logger LOG = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public void addNote(Note note) {
        LOG.info("enter noteServiceImpl method addNote, param: " + note);
        int rows = noteMapper.insertNote(note);
        LOG.info("insert rows: " + rows);
    }

    @Override
    public Page<Note> queryNotePageByTitle(int pageNum, int pageSize, String title) {
        int pageOffset = pageNum * pageSize;
        LOG.info("enter queryNotePageByTitle, params: pageNum = " + pageNum + " pageOffset: " + pageOffset + " pageSize = " + pageSize + " title = " +  title);
        List<Note> noteList = noteMapper.queryNotePageByTitle(pageOffset, pageSize, title, "");
        LOG.info("search data size: " + noteList.size());
        return new Page<>(pageNum, pageSize, noteList);
    }
}
