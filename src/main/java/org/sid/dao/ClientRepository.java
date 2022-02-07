package org.sid.dao;


import org.sid.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Page<Client> findByNomContains(String mc,Pageable pageable);

}
