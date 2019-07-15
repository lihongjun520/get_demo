package cn.appsys.service.back.datadictionary;

import java.util.List;

import cn.appsys.pojo.DataDictionary;

public interface BackDataDictionaryService {
    
	List<DataDictionary> queryByTypeCode(String typeCode);
}
