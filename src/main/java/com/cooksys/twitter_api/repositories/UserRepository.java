package com.cooksys.twitter_api.repositories;


import java.util.List;
import java.util.Optional;


import com.cooksys.twitter_api.entities.User;
import com.cooksys.twitter_api.entities.embeddable.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	Optional<User> findByCredentialsUsername(String username);
  
    Optional<User> findByCredentials(Credentials credentials);
    
    List<User> findByDeletedIsFalse();



}
