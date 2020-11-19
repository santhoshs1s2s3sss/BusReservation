package com.capg.brs.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.brs.entity.User;
@Service
@Transactional
public interface IUserService {

	public User userLogin(int userId,String password);
	
	public String register(User user);
}
