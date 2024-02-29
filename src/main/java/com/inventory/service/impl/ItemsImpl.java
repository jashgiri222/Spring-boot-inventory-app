package com.inventory.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Items;
import com.inventory.repository.ItemListRepository;
import com.inventory.service.ItemsService;

@Service
public class ItemsImpl implements ItemsService {

	@Autowired
	private ItemListRepository itemRepositoty;

	@Override
	public Items addNewItem(Items items) {

		Items itemData = new Items();
		itemData.setCategory(items.getCategory());
		itemData.setItemCode(items.getItemCode());
		itemData.setItemName(items.getItemName());
		itemData.setQuantity(items.getQuantity());
		itemData.setStatus(items.getStatus());
		itemData.setCreatedBy(items.getCreatedBy());
		itemData.setCreatedOn(new Date());
		itemData.setModifiedBy(items.getModifiedBy());
		itemData.setModifiedOn(new Date());

		return itemRepositoty.save(itemData);

	}

	@Override
	public List<Items> getAllItems() {

		return itemRepositoty.findAll();
	}

	@Override
	public void deleteItem(Long itemId) {

		Optional<Items> item = Optional.ofNullable(itemRepositoty.findById(itemId).get());

		if (item.isPresent()) {
			itemRepositoty.deleteById(itemId);

		} else {
			throw new RuntimeException(" Item Does Not Exist with Id :" + itemId);
		}

	}

	@Override
	public void updateItem(Items items, Long itemId) {

		Optional<Items> item = Optional.ofNullable(itemRepositoty.findById(itemId).get());

		if (item.isPresent()) {

			item.get().setCategory(items.getCategory());
			item.get().setQuantity(items.getQuantity());
			item.get().setItemCode(items.getItemCode());
			item.get().setItemName(items.getItemName());
			item.get().setStatus(items.getStatus());
			item.get().setModifiedOn(new Date());
			// item.get().setCreatedBy(items.getCreatedBy());
			item.get().setModifiedBy(items.getModifiedBy());
			itemRepositoty.save(item.get());

		} else {
			throw new RuntimeException(" Item Does Not Exist with Id :" + itemId);

		}

	}

	@Override
	public Items getItemById(Long id) {
		Optional<Items> item = itemRepositoty.findById(id);

		if (item.isPresent()) {

			item = Optional.of(item.get());

		}
		return item.get();

	}

}
