package cn.appsys.dao.back.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

public interface BackAppCategoryMapper {
	
	List<AppCategory> queryById(@Param("parentId")Integer parentId);
}
