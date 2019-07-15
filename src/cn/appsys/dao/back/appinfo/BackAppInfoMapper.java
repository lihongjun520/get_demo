package cn.appsys.dao.back.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;

public interface BackAppInfoMapper {

	List<AppInfo> queryAppPageInfo(
			@Param("querySoftwareName") String querySoftwareName,
			@Param("queryFlatformId") Integer queryFlatformId,
			@Param("queryCategoryLevel1") Integer queryCategoryLevel1,
			@Param("queryCategoryLevel2") Integer queryCategoryLevel2,
			@Param("queryCategoryLevel3") Integer queryCategoryLevel3, @Param("from") Integer from,
			@Param("pageSize") Integer pageSize);

	List<DataDictionary> queryAllFlatForm();

	List<AppCategory> queryCatgoryList(@Param("categoryId") Integer categoryId);

	/*@Select(" SELECT COUNT(1) FROM `app_info` a  WHERE 1 = 1 AND a.status IN (SELECT d.`valueId` FROM `data_dictionary` d WHERE d.`typeCode` = 'APP_STATUS' "
			+ " AND d.`valueName`='待审核')")*/
	Integer queryTotalCount(@Param("querySoftwareName") String querySoftwareName,
			@Param("queryFlatformId") Integer queryFlatformId,
			@Param("queryCategoryLevel1") Integer queryCategoryLevel1,
			@Param("queryCategoryLevel2") Integer queryCategoryLevel2,
			@Param("queryCategoryLevel3") Integer queryCategoryLevel3);
	
	/**
	 * 查询app信息
	 * @param aid
	 * @return
	 */
	AppInfo queryAppInfo(@Param("aid")Integer aid);
	
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
