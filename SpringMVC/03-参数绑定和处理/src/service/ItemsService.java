package service;

import java.util.List;

import pojo.Items;

public interface ItemsService {

	public List<Items> selectItemsList();
	
	public Items selectItemsById(Integer id);
	
	public void editItemsById(Items items);
	
}
