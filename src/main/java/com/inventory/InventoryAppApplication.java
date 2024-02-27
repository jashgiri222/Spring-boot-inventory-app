package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inventory.entity.User;

@SpringBootApplication
public class InventoryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryAppApplication.class, args);
		System.out.println("Inventory AppApplication Satared!!");

	
	}

}
