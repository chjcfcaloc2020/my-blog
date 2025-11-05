package com.chjcfcaloc2020.my_blog.service;

import com.chjcfcaloc2020.my_blog.model.User;
import com.chjcfcaloc2020.my_blog.repository.UserRepository;
import com.chjcfcaloc2020.my_blog.security.BlogUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class BlogUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new BlogUserDetails(user);
    }
}
