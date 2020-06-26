package it.istat.is2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.istat.is2.dao.UserDao;

import it.istat.is2.domain.User;
import it.istat.is2.domain.UserRole;
import it.istat.is2.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
    private ModelMapper modelMapper;


	public UserDTO createUser(String username, String password, String name, Long roleId) {
		User user = new User();
		user.setUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));
		user.setName(name);

		UserRole ur = new UserRole(roleId);
		user.setRole(ur);
		user=userDao.save(user);
		
		return convertToDTO(user);
	}



	public List<UserDTO> getUsers() {
	
		 List<User> users=(List<User>) userDao.findAll();
		 return users.stream()
		          .map(this::convertToDTO)
		          .collect(Collectors.toList());
	} 
	
	
	private UserDTO convertToDTO(User user) {
	  
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
}
