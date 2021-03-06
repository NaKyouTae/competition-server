package com.mercury.process.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.jpa.model.user.User;
import com.mercury.jpa.repository.user.UserRepository;

@Component
@Transactional
@SuppressWarnings("unchecked")
public class UserProcess {
	@Autowired
	private UserRepository userRepository;

	public <T extends Object> T seUserByIdx(String idx) throws Exception {
		return (T) userRepository.findByIdx(idx);
	}

	public <T extends Object> T seUserByEmail(String email) throws Exception {
		return (T) userRepository.findByEmail(email);
	}

	public <T extends Object> T getLists() throws Exception {
		return (T) userRepository.findAll();
	}

	public <T extends Object> T signUp(User user) throws Exception {
		return (T) userRepository.save(user);
	}

	public <T extends Object> T upUser(User user) throws Exception {
		return (T) userRepository.save(user);
	}

	public void destoryUser(User user) throws Exception {
		userRepository.delete(user);
	}
}
