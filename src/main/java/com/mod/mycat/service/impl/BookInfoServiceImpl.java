package com.mod.mycat.service.impl;

import com.mod.mycat.domain.BookInfo;
import com.mod.mycat.mapper.BookInfoMapper;
import com.mod.mycat.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;


    @Override
    public List<BookInfo> findBookByAuthorId(Long id) {
        return bookInfoMapper.findBookByAuthorId(id);
    }

    @Override
    public BookInfo findById(Long id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }
}
