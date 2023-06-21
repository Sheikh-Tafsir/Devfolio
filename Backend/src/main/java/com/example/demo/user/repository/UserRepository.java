package com.example.demo.user.repository;
import com.example.demo.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findById(long id);
    UserEntity findByEmail(String email);

    UserEntity findByName(String name);
}
