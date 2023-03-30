
package com.tienda.service;

import com.tienda.entity.persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class userprincipal implements UserDetails{
    private persona Persona;
    
    public userprincipal (persona Persona){
        this.Persona = Persona;
        
    }
    
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    this.Persona.getPermissionList().forEach(p -> {
        GrantedAuthority authority = new SimpleGrantedAuthority(p);
        authorities.add(authority);
        
        
        
    
    }
    }



    @Override
    public String getPassword() {
        return this.Persona.getpassword();
        
    }

    @Override
    public String getUsername() {
     return this.Persona.getnombre; 
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
     return this.Persona.getactive() == 1;
     
     
    }
    
    
}
