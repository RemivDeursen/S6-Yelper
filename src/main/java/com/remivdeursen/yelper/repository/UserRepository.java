package com.remivdeursen.yelper.repository;

import com.remivdeursen.yelper.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // custom query methods can be defined here
}
