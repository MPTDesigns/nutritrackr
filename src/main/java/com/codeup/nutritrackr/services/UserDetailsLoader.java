package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email %s", email));
        }

        return new UserWithRoles(user);
    }
}
