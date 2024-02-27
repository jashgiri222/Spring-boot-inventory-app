package com.inventory.service;

import java.util.List;

import com.inventory.entity.Items;

public interface ItemsService {
	
	public Items addNewItem(Items items);
	
	public List<Items>getAllItems();
	
	public void deleteItem(Long itemId);
	
	public void updateItem(Items items,Long itemId);

}
