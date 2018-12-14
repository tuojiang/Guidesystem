package com.service.impl;

import com.common.ServerResponse;
import com.dao.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.IUUserService;
import com.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
@Service("iUserService")
public class UserServiceImpl implements IUUserService {

	@Autowired
	private UserMapper userMapper;


	@Override
	public ServerResponse<User> login(Integer id, String passwd) {
		int resultCount = userMapper.checkUserid(id);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("用户名不存在");
		}
		User user =userMapper.selectLogin(id,passwd);
		if (user == null){
			return ServerResponse.createByErrorMessage("密码错误");
		}
		return ServerResponse.createBySuccess("登录成功",user);
	}

	@Override
	public ServerResponse<String> resetPassword(String oldpassword, String newpassword, User user) {
		int resultCount =userMapper.checkPassword(oldpassword,user.getId());
		if (resultCount == 0){
			return ServerResponse.createByErrorMessage("旧密码错误");
		}
		user.setPasswd(newpassword);
		int updateCount = userMapper.updateByPrimaryKeySelective(user);
		if (updateCount>0) {
			return ServerResponse.createBySuccess("密码更新成功");
		}
		return ServerResponse.createByErrorMessage("密码更新失败");
	}

	@Override
	public ServerResponse<PageInfo> getUsersInfo(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<User> users = userMapper.queryUser();
		PageInfo pageInfo = new PageInfo(users);
		return ServerResponse.createBySuccess(pageInfo);
	}


}
