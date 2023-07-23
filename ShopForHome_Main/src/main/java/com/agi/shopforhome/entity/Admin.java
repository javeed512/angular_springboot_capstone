package com.agi.shopforhome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Swapnil 
 * Modified Date: 24/08/2022
 * Description: Admin entity
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="admin_table")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique = true)
	private String email;
	private String password;

}
