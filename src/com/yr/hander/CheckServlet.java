package com.yr.hander;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = ("login_user"))
public class CheckServlet {

	@RequestMapping(value = "/checkServlet", method = RequestMethod.POST)
	protected String doPost(HttpServletRequest request, HttpServletResponse response, @RequestParam("user") String user,
			@RequestParam("pd") String pd, @RequestParam("randomCode") String randomCode,
			@RequestParam("hiddenCode") String hiddenCode,Map<String, Object> map) {

		// 刚开始登录的审核提示验证码是隐藏的，所以等于空
		if (null == hiddenCode || "".equals(hiddenCode)) {// 等于空的时候
			if ("admin".equals(user) && "admin".equals(pd)) {// 如果用户名和密码正确，跳转到欢迎页面
				map.put("login_user", "admin");
				return "forward:menu.jsp";
			} else {
				request.setAttribute("err", 1);// 提示请输入用户名或密码
				request.setAttribute("hiddenCode", 1);// 改变hiddenCode的值
				return "forward:login.jsp";
			}
		}
		// 第二次进来hiddenCode的值肯定改变了，如果验证码为空提示请输入验证码
		if (null == randomCode || "".equals(randomCode)) {
			request.setAttribute("err", 0);// 请输入验证码
			request.setAttribute("hiddenCode", 1);// 改变hiddenCode的值
			return "forward:login.jsp";
		}
		// 如果验证码不为空，那就判断验证码输入是否正确如果正确，那么判断用户名或密码是否正确，如果不正确
		if (randomCode.toUpperCase().equals(request.getSession().getAttribute("rand"))) {

			if ("admin".equals(user) && "admin".equals(pd)) {// 如果验证码正确，用户名和密码也正确，跳转到欢迎页面

				return "forward:menu.jsp";
			} else {// 否则提示用户名或密码错误，这里还有一种可能，就是验证码正确，用户名或密码为null，可以判断null，也可以直接提示用户名或密码错误，是null也是错误
				request.setAttribute("err", 2);// 用户名或密码错误
				request.setAttribute("hiddenCode", 1);// 改变hiddenCode的值
				return "forward:login.jsp";
			}
		} else {// 提示验证码输入错误
			request.setAttribute("err", 3);// 验证码错误
			request.setAttribute("hiddenCode", 1);// 改变hiddenCode的值
			return "forward:login.jsp";
		}

	}
}