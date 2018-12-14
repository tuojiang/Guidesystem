package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public interface UserMapper {
	int insert(User user);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKey(User user);

	int updateByPrimaryKeySelective(User user);

	User selectByPrimaryKey(Integer id);

	int checkUserid(int id);

	User selectLogin(@Param("id") Integer id, @Param("passwd") String passwd);

	int checkPassword(@Param(value = "passwd") String oldpasswd, @Param(value = "id") int userId);

	List<User> queryUser();
}
