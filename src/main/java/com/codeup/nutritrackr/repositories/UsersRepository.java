package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
