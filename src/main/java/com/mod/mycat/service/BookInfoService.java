package com.mod.mycat.service;

import com.mod.mycat.domain.BookInfo;

import java.util.List;

public interface BookInfoService {

    List<BookInfo> findBookByAuthorId(Long id);


    int insert(BookInfo bookInfo);
}
