package com.inventory.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Item_List")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemId;
	
	private Long itemCode;
	private String itemName;
	private String category;
	private Long quantity;
	private String status;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
	private Date modifiedOn;
	

}
