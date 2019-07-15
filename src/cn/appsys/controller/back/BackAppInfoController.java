package cn.appsys.controller.back;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.dao.back.appcategory.BackAppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.Page;
import cn.appsys.service.back.appInfo.BackAppInfoService;
import cn.appsys.service.back.appcategory.BackAppCategoryService;
import cn.appsys.service.back.datadictionary.BackDataDictionaryService;
import cn.appsys.service.back.user.BackUserService;

@Controller
@RequestMapping("/backAppInfo")
public class BackAppInfoController {

	@Resource
	private BackAppInfoService backAppInfoService;

	@Resource
	private BackDataDictionaryService dataDictionaryService;

	@Resource
	private BackAppCategoryService appCategoryService;

	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "currPageNo", required = false, defaultValue = "1") Integer currPageNo,
			Model model2) {

		int totalCount = backAppInfoService.queryCount(querySoftwareName, queryFlatformId, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3);
		Page page = new Page();
		page.setCurrPageNo(currPageNo);
		page.setPageSize(5);
		page.setTotalCount(totalCount);
		List<AppInfo> appInfoList = backAppInfoService.queryAppPageInfo(querySoftwareName, queryFlatformId,
				queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, currPageNo, page.getPageSize());
		List<DataDictionary> flatFormList = backAppInfoService.queryAllFlatForm();

		List<AppCategory> categoryLevel1List = backAppInfoService.queryCatgoryList(queryCategoryLevel1);// 一级分类

		model.addAttribute("pages", page);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryFlatformId", queryFlatformId);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);

		return "backend/applist";
	}

	@RequestMapping("/main")
	public String main() {
		return "bacKend/main";
	}

	// 页面中下拉框的三级联动
	@RequestMapping(value = "/queryCategoryListByParentId", method = RequestMethod.GET)
	@ResponseBody
	public Object queryCategoryListByParentId(@RequestParam("pid") Integer pid) {
		List<AppCategory> appCategryList = appCategoryService.queryById(pid);
		return appCategryList;
	}

	@RequestMapping("/check")
		public String AppInfo(@RequestParam("aid")Integer aid,@RequestParam("vid")Integer vid,Model model){
			AppInfo appInfo = backAppInfoService.queryAppInfo(aid);
			AppVersion appVersion=	backAppInfoService.queryAppVersion(vid);
			model.addAttribute("appInfo", appInfo);
			model.addAttribute("appVersion", appVersion);
				return"backend/appcheck";
	}
	
	 //审核
    @RequestMapping("/info")
	public String info(@RequestParam("status")Integer status,@RequestParam("id")Integer id){
		backAppInfoService.updateAppInfo(status, id);
		return "redirect:/backAppInfo/list";
	}
}
