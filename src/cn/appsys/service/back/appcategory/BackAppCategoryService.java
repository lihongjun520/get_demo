package cn.appsys.service.back.appcategory;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface BackAppCategoryService {
	List<AppCategory> queryById(Integer parentId);
}
