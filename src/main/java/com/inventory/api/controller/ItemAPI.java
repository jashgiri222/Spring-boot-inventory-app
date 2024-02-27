package com.inventory.api.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.entity.Items;
import com.inventory.service.impl.ItemsImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/item")
public class ItemAPI {

	Logger logger = LoggerFactory.getLogger(ItemAPI.class);

	@Autowired
	private ItemsImpl itemsImpl;

	@Operation(summary = " Add Item  ", description = "Item Object must exist")

	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "201", description = "Success Created")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "500", description = "Internal server error")

	@PostMapping("/additem")
	public ResponseEntity<Items> createUser(@RequestBody Items item) {

		Items itemAdded = itemsImpl.addNewItem(item);
		return new ResponseEntity<Items>(itemAdded, HttpStatus.CREATED);
	}

	@Operation(summary = "get All Items", description = " Returns All Items From Database ")

	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "500", description = "Internal server error")

	@GetMapping("/getallitems")
	public ResponseEntity<List<Items>> getAllTems() {
		List<Items> items = itemsImpl.getAllItems();
		return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
	}

	@Operation(summary = "delte Item By ItemId", description = " Returns Item Based On ItemId")

	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "404", description = " Resource Not Found or Item Doesnot Exist With ItemId")
	@ApiResponse(responseCode = "500", description = "Internal server error")

	@DeleteMapping("/delteitem/{itemId}")
	public ResponseEntity<String> deleteItemById(@PathVariable Long itemId) {
		itemsImpl.deleteItem(itemId);
		return new ResponseEntity<>("Item Deleted ", HttpStatus.OK);
	}

	@Operation(summary = "Update Item By ItemId", description = " Returns Item Based On ItemId")

	@ApiResponse(responseCode = "200", description = "Success")
	@ApiResponse(responseCode = "400", description = "Invalid Request Payload")
	@ApiResponse(responseCode = "404", description = " Resource Not Found or Item Doesnot Exist With ItemId")
	@ApiResponse(responseCode = "500", description = "Internal server error")

	@PutMapping("/updateitem/{itemId}")
	public ResponseEntity<String> updateItems(@RequestBody Items items, @PathVariable Long itemId) {
		itemsImpl.updateItem(items, itemId);
		return new ResponseEntity<>("Item Updated Success", HttpStatus.OK);
	}
}
