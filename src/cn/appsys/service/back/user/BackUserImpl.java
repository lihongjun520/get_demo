package cn.appsys.service.back.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.back.user.BackUserMapper;
import cn.appsys.pojo.BackendUser;

@Service("backUserService")
public class BackUserImpl implements BackUserService {
	
	@Resource
	private BackUserMapper backUserMapper;
	
   @Override 
   public BackendUser queryCodeAndPwd(String userCode,String userPassword) {
	   return backUserMapper.queryCodeAndPwd(userCode, userPassword);
   }
}
