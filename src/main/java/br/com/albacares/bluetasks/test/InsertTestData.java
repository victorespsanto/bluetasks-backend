package br.com.albacares.bluetasks.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.albacares.bluetasks.domain.task.Task;
import br.com.albacares.bluetasks.domain.task.TaskRepository;
import br.com.albacares.bluetasks.domain.user.AppUser;
import br.com.albacares.bluetasks.domain.user.AppUserRepository;

@Component
public class InsertTestData {

	private TaskRepository taskRepository;
	
	private AppUserRepository appUserRepository;

	@Autowired
	public InsertTestData(TaskRepository taskRepository, AppUserRepository appUserRepository) {		
		this.taskRepository = taskRepository;
		this.appUserRepository = appUserRepository;
	}
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		AppUser appUser1 = new AppUser("John", encoder.encode("abc"), "John Coder");
		appUserRepository.save(appUser1);
		
		AppUser appUser2 = new AppUser("Paul", encoder.encode("abc"), "Paul Nit");
		appUserRepository.save(appUser2);
		
		LocalDate baseDate = LocalDate.parse("2025-02-01");
		
		for (int i = 1; i <= 5; i++) {			
			Task task = new Task(String.format("Tarefa #%d de %s", i, appUser1.getUserName()), baseDate.plusDays(i), false);
			task.setAppUser(appUser1);
			taskRepository.save(task);
		}
		
		for (int i = 1; i <= 5; i++) {			
			Task task = new Task(String.format("Tarefa #%d de %s", i, appUser2.getUserName()), baseDate.plusDays(i), false);
			task.setAppUser(appUser2);
			taskRepository.save(task);
		}
	
	}
	
}
