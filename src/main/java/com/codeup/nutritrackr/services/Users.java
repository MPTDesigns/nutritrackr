package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Users {

    private final UsersRepository usersDao;

    @Autowired
    public Users(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> findAll() {
        return (List<User>) usersDao.findAll();
    }

    public User findByEmail(String email) {
        return usersDao.findByEmail(email);
    }

    public User findOne(long id) {
        return usersDao.findOne(id);
    }

    public User save(User user) {
        return usersDao.save(user);
    }
}
