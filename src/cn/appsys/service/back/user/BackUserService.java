package cn.appsys.service.back.user;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public interface BackUserService {
	BackendUser queryCodeAndPwd(String userCode, String userPassword);
}