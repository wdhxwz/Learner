package com.wangdh.learner.mybatis.mapper;

import com.wangdh.learner.mybatis.entity.UserEntity;

public interface UserMapper {
	UserEntity getUser(String id);
}