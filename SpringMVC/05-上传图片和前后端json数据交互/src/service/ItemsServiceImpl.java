package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ItemsMapper;
import pojo.Items;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	
	@Override
	public Items selectItemsById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void editItemsById(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
}
