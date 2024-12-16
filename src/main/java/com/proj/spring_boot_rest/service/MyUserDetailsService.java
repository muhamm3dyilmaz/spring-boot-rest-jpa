package com.proj.spring_boot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proj.spring_boot_rest.model.User;
import com.proj.spring_boot_rest.model.UserPrincipal;
import com.proj.spring_boot_rest.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User Not Found!");
            throw new UsernameNotFoundException("404: User Not Found :(");
        }

        return new UserPrincipal(user);
    }

}
