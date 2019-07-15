package cn.appsys.dao.back.user;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackUserMapper {
	BackendUser queryCodeAndPwd(@Param("userCode")String userCode,
    		@Param("userPassword")String userPassword);
	
}