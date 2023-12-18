package com.android.ecommerce.model;

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
	private Integer idUser;
	
	private String lastName;
	
	private String firstName;
	
	private String login;
	
	private String password;
	
	private String email;
	
	private String postcode;

	
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

	public String getLogin() {
		return login;
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

	public void setLogin(String login) {
		this.login = login;
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
		login = source.getLogin();
		password = source.getPassword();
		email = source.getEmail();
		postcode = source.getPostcode();
		
	}

}
