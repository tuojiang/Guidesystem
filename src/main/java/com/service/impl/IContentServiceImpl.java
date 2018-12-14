package com.service.impl;

import com.common.ServerResponse;
import com.dao.ContentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.pojo.Content;
import com.pojo.User;
import com.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
@Service("iContentService")
public class IContentServiceImpl implements IContentService {

	@Autowired
	private ContentMapper contentMapper;
	@Override
	public ServerResponse update(Content content) {
		int rowConunt = contentMapper.updateBycontent(content);
		if (rowConunt>0) {
			return ServerResponse.createBySuccess("更新前台通知成功");
		}
		return ServerResponse.createByErrorMessage("更新前台通知失败");
	}

	@Override
	public ServerResponse add(Content content) {
		int rowCount =contentMapper.insertSelective(content);
		if (rowCount>0) {
			Map result = Maps.newHashMap();
			result.put("content_id",content.getId());
			return ServerResponse.createBySuccess("新增前台通知成功",result);
		}
		return ServerResponse.createByErrorMessage("新增前台通知失败");
	}

	@Override
	public ServerResponse<PageInfo> getNotifyInfo(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Content> contents = contentMapper.queryNotify();
		PageInfo pageInfo = new PageInfo(contents);
		return ServerResponse.createBySuccess(pageInfo);
	}
}
