package com.controller;

import com.common.Const;
import com.common.ResponseCode;
import com.common.ServerResponse;
import com.pojo.Bbs;
import com.pojo.User;
import com.service.IBbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
@Controller
@RequestMapping("/bbs/")
public class BbsController {

	@Autowired
	private IBbsService iBbsService;

	/**
	 *  发表帖子
	 */
	@RequestMapping(value = "add_note.do")
	@ResponseBody
	public ServerResponse addNote(HttpSession session, Bbs bbs) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iBbsService.addNote(bbs);
	}
	/**
	 * 发表回复
	 */
	@RequestMapping(value = "add_reply.do")
	@ResponseBody
	public ServerResponse addReply(HttpSession session, Bbs bbs) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iBbsService.addReply(bbs);
	}
	/**
	 * 点赞
	 */
	@RequestMapping(value = "add_like.do")
	@ResponseBody
	public ServerResponse addLike(HttpSession session, Bbs bbs) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		}
		return iBbsService.addLike(bbs);
	}
}
