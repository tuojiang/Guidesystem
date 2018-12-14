package com.service.impl;

import com.common.ServerResponse;
import com.dao.BbsMapper;
import com.google.common.collect.Maps;
import com.pojo.Bbs;
import com.service.IBbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
@Service("iBbsService")
public class IBbsServiceImpl implements IBbsService {

	@Autowired
	private BbsMapper bbsMapper;

	@Override
	public ServerResponse addNote(Bbs bbs) {
		int rowCount =bbsMapper.addNote(bbs);
		if (rowCount>0) {
			Map result = Maps.newHashMap();
			result.put("bbs_id",bbs.getId());
			result.put("bbs_title",bbs.getTitle());
			result.put("bbs_content",bbs.getContent());
			result.put("bbs_time",new Date());
			result.put("bbs_author",bbs.getAuthor());
			result.put("bbs_applaud",0);
			return ServerResponse.createBySuccess("发表帖子成功",result);
		}
		return ServerResponse.createByErrorMessage("发表帖子失败");
	}

	@Override
	public ServerResponse addReply(Bbs bbs) {
		int rowCount =bbsMapper.addReply(bbs);
		if (rowCount>0) {
			Map result = Maps.newHashMap();
			result.put("bbs_id",bbs.getId());
			result.put("bbs_cmcontent",bbs.getCmcontent());
			result.put("bbs_cmtime",new Date());
			result.put("bbs_cmauthor",bbs.getCmauthor());
			return ServerResponse.createBySuccess("发表评论成功",result);
		}
		return ServerResponse.createByErrorMessage("发表评论失败");
	}

	@Override
	public ServerResponse addLike(Bbs bbs) {
		int rowCount = bbsMapper.updateLike(bbs);
		if (rowCount>0) {
			Map result = Maps.newHashMap();
			result.put("bbs_id",bbs.getId());
			result.put("bbs_applaud",bbs.getApplaud());
			return ServerResponse.createBySuccess("点赞成功",result);
		}
		return ServerResponse.createByErrorMessage("点赞失败");
	}
}
