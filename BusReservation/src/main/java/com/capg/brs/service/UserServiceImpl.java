package com.capg.brs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.User;
import com.capg.brs.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository dao;
	

	public static final User IUserRepository = new User();

	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		 dao.save(user);
		 return "account successfully created";
	}

	
	public User userLogin(int userId,String password)
	{
		
		System.out.println("in service");
		User result=dao.findOne(userId);
		if(result!=null)
		{
			User user=dao.getOne(userId);
			System.out.println(user);
			String pass=user.getPassword();
			if(pass.equals(password))
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	
}
	
}
