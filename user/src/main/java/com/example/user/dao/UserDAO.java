package com.example.user.dao;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.user.entity.UserEntity;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserName(String userName);
	UserEntity findByUserId(Integer userId);
	
}
