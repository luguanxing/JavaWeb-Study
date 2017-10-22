package mapper;

import java.util.List;

import pojo.BaseDict;

public interface BaseDictMapper {
	
	//根据code查询
	public List<BaseDict> selectBaseDictListByCode(String code);
	
}
