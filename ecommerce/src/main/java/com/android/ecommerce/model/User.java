package com.android.ecommerce.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import com.android.ecommerce.generic.IGenericEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * 
 * 
 * Documentation sur la stratégie du mapping d'héritage
 * https://www.axopen.com/blog/2014/03/hibernate-4-heritage-mapping-strategies/
 */

@Entity
@Table(name="t_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User implements IGenericEntity<User>{
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idUser;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$",  message = "Lastname must start with a capital letter and contain only alphabetic characters.")
	protected String lastName;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$")
	protected String firstName;
	
	@NotBlank
	protected String password;
	
	@NotBlank
	@Email
	protected String email;
	
	@NotBlank
	@Pattern(regexp = "\\d+") 
	protected String postcode;

	
	//Constructeur
	public User() {}

	//Getter
	public Integer getId() {
		return idUser;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPostcode() {
		return postcode;
	}
	
	//Setter
	public void setId(Integer id) {
		this.idUser = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public void update(User source) {
		idUser = source.getId();
		lastName = source.getLastName();
		firstName = source.getFirstName();
		password = source.getPassword();
		email = source.getEmail();
		postcode = source.getPostcode();
		
	}

}
