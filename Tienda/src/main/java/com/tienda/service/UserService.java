
package com.tienda.service;

import com.tienda.entity.persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 
public class UserService implements UserDetailsService {
    @Autowired 
    public IpersonaService personaService;
    
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            persona persona = this.personaService.findByNombre(username);
            userprincipal userprincipal = new userprincipal(persona);
            return userprincipal;
    }   
}
