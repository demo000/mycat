package com.mod.mycat.service.impl;

import com.mod.mycat.domain.BookInfo;
import com.mod.mycat.mapper.BookInfoMapper;
import com.mod.mycat.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;


    @Override
    public List<BookInfo> findBookByAuthorId(Long id) {
        return bookInfoMapper.findBookByAuthorId(id);
    }


    @Override
    public int insert(BookInfo bookInfo) {
        bookInfo.setId(UUID.randomUUID().toString().replace("-", ""));
        return bookInfoMapper.insert(bookInfo);
    }
}
