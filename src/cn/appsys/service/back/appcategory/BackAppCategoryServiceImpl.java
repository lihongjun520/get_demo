package cn.appsys.service.back.appcategory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.back.appcategory.BackAppCategoryMapper;
import cn.appsys.pojo.AppCategory;
@Service("backAppCategoryService")
public class BackAppCategoryServiceImpl implements BackAppCategoryService {
	@Resource  
	private BackAppCategoryMapper backAppCategoryMapper;
	
	@Override
	public List<AppCategory> queryById(Integer parentId) {
		return backAppCategoryMapper.queryById(parentId);
	}

}
