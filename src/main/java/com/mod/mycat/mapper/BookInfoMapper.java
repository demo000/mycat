package com.mod.mycat.mapper;

import com.mod.mycat.domain.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> findBookByAuthorId(@Param("authorId") Long authorId);
}