package com.perscholas.PRGS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<ModelUsers,Integer>{

	ModelUsers findByEmail(String email);
	
}
