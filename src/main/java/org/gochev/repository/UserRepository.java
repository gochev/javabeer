package org.gochev.repository;

import org.gochev.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository(value = UserRepository.NAME)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	public static final String NAME = "userRepository";
	
	public User findUserByUsername(String username);
	
}
