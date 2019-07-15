package cn.appsys.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.constant.Constants;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.back.user.BackUserService;


@Controller
@RequestMapping("/manager/login")
public class BackLoginController {
	@Resource
	private BackUserService backUserService;
	
   @RequestMapping("/login")
   public String login() {
	   return "backendlogin";
   }
   
   @RequestMapping("/dologin")
   public String doLogin(HttpSession session,HttpServletRequest request,
		   @RequestParam("userCode")String userCode,
		   @RequestParam("userPassword") String userPassword) {
	   BackendUser backendUser = backUserService.queryCodeAndPwd(userCode, userPassword);
	   if(backendUser !=null) {
		   session.setAttribute(Constants.DEV_USER_SESSION,backendUser);
		   return "backend/main";
	   }else {
		   request.setAttribute("error","用户名不正确！");
		   return "backendlogin";
	   }
   }
	  //实现注销操作
	   @RequestMapping("/logoin")
	   public String logout(HttpSession session) {
		   session.removeAttribute(Constants.DEV_USER_SESSION);
		   return "backendlogin";
	   }
   }

