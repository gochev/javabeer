package org.gochev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import lombok.Data;

@Entity
@Data
public class User extends AbstractEntity {
	
	private static final long serialVersionUID = -3337657800628993484L;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
