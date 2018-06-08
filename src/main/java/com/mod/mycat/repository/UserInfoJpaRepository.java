package com.mod.mycat.repository;

import com.mod.mycat.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {

    List<UserInfo> queryByName(String name);

}
