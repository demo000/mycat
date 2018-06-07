package com.mod.mycat.service;

import com.mod.mycat.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAll();

    Long insert(UserInfo info);

    UserInfo findById(Long id);
    int deleteById(Long id);
}
