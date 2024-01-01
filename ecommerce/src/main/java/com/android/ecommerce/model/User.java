package com.android.ecommerce.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.android.ecommerce.generic.IGenericEntity;
import com.android.ecommerce.model.enumeration.Category;
import com.android.ecommerce.model.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * 
 * 
 * Documentation sur la stratégie du mapping d'héritage
 * https://www.axopen.com/blog/2014/03/hibernate-4-heritage-mapping-strategies/
 */

@Entity
@Table(name="t_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Supplier.class, name = "SUPPLIER"),
    @JsonSubTypes.Type(value = Client.class, name = "CLIENT")
})
public abstract class User implements IGenericEntity<User>, UserDetails{
	
	private static final long serialVersionUID = 6315138356298279759L;

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idUser;
	
	@NotBlank(message = "{validation.notblank}")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$",  message = "Lastname must start with a capital letter and contain only alphabetic characters.")
	protected String lastName;
	
	@NotBlank(message = "{validation.notblank}")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$")
	protected String firstName;
	
	@NotBlank(message = "{validation.notblank}")
	protected String password;
	
	@NotBlank(message = "{validation.notblank}")
	@Email
	protected String email;
	
	@NotBlank(message = "{validation.notblank}")
	@Pattern(regexp = "\\d+") 
	protected String postcode;
	
    @Enumerated(EnumType.STRING)
    protected Role userType;
	
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
	
	public Role getUserType() {
		return userType;
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
	

	public void setUserType(Role userType) {
		this.userType = userType;
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(getUserType().toString()));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {	
		return false;
	}


}
