package com.controller;

import com.common.Const;
import com.common.ServerResponse;
import com.pojo.User;
import com.service.IUUserService;
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
@RequestMapping("/user/")
public class UserController {

	/**
	 * 依赖注入service对象
	 */
	@Autowired
	private IUUserService iUserService;

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "login.do")
	@ResponseBody
	public ServerResponse<User> login(Integer id, String passwd, HttpSession session) {
		ServerResponse<User> response = iUserService.login(id, passwd);
		if (response.isSuccess()) {
			session.setAttribute(Const.CURRENT_USER, response.getData());
		}
		return response;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout.do")
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session) {
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();
	}

	/**
	 * 获取用户信息
	 */
	    @RequestMapping(value = "get_user_info.do")
	        @ResponseBody
	        public ServerResponse<User> getUserInfo(HttpSession session){
				User user = (User) session.getAttribute(Const.CURRENT_USER);
			if (user != null) {
				return ServerResponse.createBySuccess(user);
			}
	            return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户信息");
	        }
			/**
			 * 修改密码
			 */
		    @RequestMapping(value = "reset_password.do")
		        @ResponseBody
		        public ServerResponse<String> resetPassword(HttpSession session,String oldpassword,String newpassword ){
					User user = (User) session.getAttribute(Const.CURRENT_USER);
				if (user == null) {
					return ServerResponse.createByErrorMessage("用户未登录");
				}
				return iUserService.resetPassword(oldpassword,newpassword,user);
		        }
}
