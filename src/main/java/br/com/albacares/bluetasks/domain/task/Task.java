package br.com.albacares.bluetasks.domain.task;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.albacares.bluetasks.domain.user.AppUser;

@Entity
@EntityListeners(TaskListener.class)
public class Task {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "A descri��o da mensagem � obrigat�ria")
	@Length(min = 3, max = 40, message = "O tamanho da descri��o da tarefa n�o est� adequado")	
	private String description;
	
	@NotNull(message = "A data da tarefa � obrigat�ria")
	@FutureOrPresent(message = "A data da tarefa n�o pode estar no passado")
	private LocalDate whenToDo;
	
	private boolean done = false;
	
	@ManyToOne // Muitas tarefas (task) para um unico usuario (appUser)
	@JoinColumn(name = "app_user_id")  // n�o deixa que a JPA crie um nome aleat�rio
	//@NotNull(message = "O usu�rio da tarefa � obrigat�rio")
	@JsonIgnore
	private AppUser appUser;

	public Task() {
		
	}

	public Task(String description, LocalDate whenToDo, boolean done) {
		
		this.description = description;
		this.whenToDo = whenToDo;
		this.done = done;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getWhenToDo() {
		return whenToDo;
	}

	public void setWhenToDo(LocalDate whenToDo) {
		this.whenToDo = whenToDo;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Integer getId() {
		return id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	
	
	
	
	

}
