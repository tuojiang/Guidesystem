package com.controller.backend;

import com.common.Const;
import com.common.ResponseCode;
import com.common.ServerResponse;
import com.github.pagehelper.PageInfo;
import com.pojo.Content;
import com.pojo.User;
import com.service.IContentService;
import com.service.IUUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
@Controller
@RequestMapping("/manage/user/")
public class UserManageController {

	@Autowired
	private IUUserService iuUserService;

	@Autowired
	private IContentService iContentService;

	/**
	 * 管理员登陆
	 */
	@RequestMapping(value = "login.do")
	@ResponseBody
	public ServerResponse<User> login(int id, String passwd, HttpSession session) {
		ServerResponse<User> response = iuUserService.login(id, passwd);
		if (response.isSuccess()) {
			User user = response.getData();
			if (user.getRole() == Const.Role.ROLE_ADMIN) {
				//说明是管理员登录
				session.setAttribute(Const.CURRENT_USER, user);
				return response;
			} else {
				return ServerResponse.createBySuccessMessage("不是管理员，无法登录");
			}
		}
		return response;
	}

	/**
	 * 查看用户数据
	 */
	@RequestMapping(value = "get_users_info.do" )
	@ResponseBody
	public ServerResponse<PageInfo> getUsersInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
												 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
												 HttpSession session) {
		//User user = (User) session.getAttribute(Const.CURRENT_USER);
		//if (user == null) {
		//	return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		//}

		return iuUserService.getUsersInfo(pageNum, pageSize);

	}

	/**
	 * 查看通知
	 */
	@RequestMapping(value = "get_notify_info.do" )
	@ResponseBody
	public ServerResponse<PageInfo> getNotifyInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
												 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
												 HttpSession session) {
		//User user = (User) session.getAttribute(Const.CURRENT_USER);
		//if (user == null) {
		//	return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
		//}

		return iContentService.getNotifyInfo(pageNum, pageSize);

	}

	/**
	 * 更新前台通知内容
	 */
	@RequestMapping(value = "update_front_notice.do")
	@ResponseBody
	public ServerResponse updateFrontNotice(HttpSession session, Content content) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		}
		return iContentService.update(content);
	}

	/**
	 * 添加前台通知内容
	 */
	@RequestMapping(value = "add_front_notice.do")
	@ResponseBody
	public ServerResponse addFrontNotice(HttpSession session, Content content) {
		//User user = (User) session.getAttribute(Const.CURRENT_USER);
		//if (user == null) {
		//	return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
		//}
		return iContentService.add(content);
	}
}
