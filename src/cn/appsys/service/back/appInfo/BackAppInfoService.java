package cn.appsys.service.back.appInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;

public interface BackAppInfoService {
    
	List<AppInfo> queryAppPageInfo(String querySoftwareName,
			Integer queryFlatformId,
			Integer queryCategoryLevel1,
			Integer queryCategoryLevel2,
			Integer queryCategoryLevel3,
			Integer from,
			Integer pageSize);
	    
	int queryCount(
				String querySoftwareName,
				Integer queryFlatformId,
				Integer queryCategoryLevel1,
				Integer queryCategoryLevel2,
				Integer queryCategoryLevel3);
			  
	   
	   List<DataDictionary> queryAllFlatForm();
		
	   List<AppCategory> queryCatgoryList(Integer categoryId);
	   
	   /**
		 * 查询app信息
		 * @param aid
		 * @return
		 */
		AppInfo queryAppInfo(Integer aid);
		
		/**
		 * 查询本版信息
		 * @param vid
		 * @return
		 */
		AppVersion queryAppVersion(@Param("vid")Integer vid);
		
		/**
		 * 修改
		 * @param aid
		 * @param id
		 * @return
		 */
		int updateAppInfo(@Param("aid")Integer aid,@Param("id") Integer id);
}
