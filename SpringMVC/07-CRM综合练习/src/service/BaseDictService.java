package service;

import java.util.List;

import pojo.BaseDict;

public interface BaseDictService {

	//根据code查询
	public List<BaseDict> selectBaseDictListByCode(String code);
	
}
