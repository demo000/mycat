package com.mod.mycat.service.impl;

import com.mod.mycat.domain.UserInfo;
import com.mod.mycat.mapper.UserInfoMapper;
import com.mod.mycat.repository.UserInfoJpaRepository;
import com.mod.mycat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoJpaRepository.findAll();
    }

    @Override
    public Long insert(UserInfo info) {
        UserInfo save = userInfoJpaRepository.save(info);
        return save.getId();
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public Double getAvgScore() {
        return userInfoMapper.getAvgScore();
    }
}
