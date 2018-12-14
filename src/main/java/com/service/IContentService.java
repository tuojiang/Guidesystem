package com.service;

import com.common.ServerResponse;
import com.github.pagehelper.PageInfo;
import com.pojo.Content;

/**
 */
public interface IContentService {
	ServerResponse update(Content content);

	ServerResponse add(Content content);

	ServerResponse<PageInfo> getNotifyInfo(int pageNum, int pageSize);
}
