package com.mod.mycat.repository;

import com.mod.mycat.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
}
