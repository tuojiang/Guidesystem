package com.service;

import com.common.ServerResponse;
import com.github.pagehelper.PageInfo;
import com.pojo.User;

import java.util.List;

/**
 */
public interface IUUserService {
	ServerResponse<User> login(Integer id, String passwd);

	ServerResponse<String> resetPassword(String oldpassword, String newpassword, User user);

	ServerResponse<PageInfo> getUsersInfo(int pageNum,int pageSize);
}
