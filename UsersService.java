package com.perscholas.PRGS;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsersService {
	@Autowired
	private UsersRepository repo;
	
	
	public List<ModelUsers> listAll(){
		
		return repo.findAll();
	}
	
	
	public void save(ModelUsers users) {
		repo.save(users);
	}
	
	
	public ModelUsers get(int id) {
		return repo.findById(id).get();
		
	}
	
	public void delete(int id) {
		
		repo.deleteById(id);
	}
	
	public ModelUsers findByEmail(String email) {
		
	        return repo.findByEmail(email);	 
	        
	}
	
}
