package com.dbp.backendtourplus.user.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementa la lógica para cargar el usuario desde la base de datos
        // y retorna un objeto UserDetails
        return null; // Reemplaza esto con la lógica real
    }
}
