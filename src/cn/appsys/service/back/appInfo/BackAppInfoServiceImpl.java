package cn.appsys.service.back.appInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.back.appinfo.BackAppInfoMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;

@Service("backAppInfoService")
public class BackAppInfoServiceImpl implements BackAppInfoService {

	@Resource
	private BackAppInfoMapper backAppInfoMapper;

	@Override
	public int queryCount(String querySoftwareName, Integer queryFlatformId, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3) {

		int row = backAppInfoMapper.queryTotalCount(querySoftwareName, queryFlatformId, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3);
		return row;
	}

	@Override
	public List<DataDictionary> queryAllFlatForm() {
		return backAppInfoMapper.queryAllFlatForm();
	}

	@Override
	public List<AppCategory> queryCatgoryList(Integer categoryId) {
		return backAppInfoMapper.queryCatgoryList(categoryId);
	}

	@Override
	public List<AppInfo> queryAppPageInfo(String querySoftwareName, Integer queryFlatformId,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer from,
			Integer pageSize) {
		from = (from - 1) * pageSize;
		List<AppInfo> list = backAppInfoMapper.queryAppPageInfo(querySoftwareName, queryFlatformId, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3, from, pageSize);
		System.out.println("service:" + list.size());
		return list;
	}

	@Override
	public AppInfo queryAppInfo(Integer aid) {
		// TODO Auto-generated method stub
		AppInfo app= backAppInfoMapper.queryAppInfo(aid);
		System.out.println("是指："+app);
		return app;
	}

	@Override
	public AppVersion queryAppVersion(Integer vid) {
		// TODO Auto-generated method stub
		return backAppInfoMapper.queryAppVersion(vid);
	}

	@Override
	public int updateAppInfo(Integer aid, Integer id) {
		// TODO Auto-generated method stub
		return backAppInfoMapper.updateAppInfo(aid, id);
	}

}
