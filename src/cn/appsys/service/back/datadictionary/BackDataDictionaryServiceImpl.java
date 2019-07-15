package cn.appsys.service.back.datadictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.back.datadictionary.BackDataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
@Service("backDataDictionaryService")
public class BackDataDictionaryServiceImpl implements BackDataDictionaryService {

	
	@Resource
	private BackDataDictionaryMapper backDataDictionaryMapper;
	
	@Override 
	public List<DataDictionary> queryByTypeCode(String typeCode) {
		
		return backDataDictionaryMapper.queryByTypeCode(typeCode);
	}

}
