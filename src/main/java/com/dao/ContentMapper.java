package com.dao;

import com.pojo.Content;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public interface ContentMapper {

	int updateBycontent(Content content);

	int inser(Content content);

	int insertSelective(Content content);

	List<Content> queryNotify();
}
