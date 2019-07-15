package cn.appsys.dao.back.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

public interface BackDataDictionaryMapper {
    
	List<DataDictionary> queryByTypeCode(@Param("typeCode")String typeCode);
}
