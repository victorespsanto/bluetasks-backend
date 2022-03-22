package br.com.albacares.bluetasks.domain.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository // anota��o para incluir as fun��es SQL � classe
@RepositoryRestResource(exported = false) // nao permite que o repositorio seja exportado pelo webservice
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
	
	AppUser findByUserName(String userName);
	
}
