package br.com.albacares.bluetasks.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "app_user") // importante que a separa??o do nome seja com underline ("_") sen?o n?o identifica a tabela
public class AppUser {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "O nome do usu?rio ? obrigat?rio")	
	private String username;
	
	@NotEmpty(message = "A senha ? obrigat?ria")
	private String password;
	
	@NotEmpty(message = "O nome de exibi??o ? obrigat?rio")
	private String displayName;

	public AppUser() {
		
	}

	public AppUser(String username, String password, String displayName) {
		
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getId() {
		return id;
	}

	
	
	
	
	
	
	
	
	

}
