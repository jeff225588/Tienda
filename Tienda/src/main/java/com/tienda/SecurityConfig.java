
package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired 
    private UserService userDetailService;
    
    @Bean 
    public BCryptPasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();  
    }
    
    @Bean
    public UserService getUserService() {
        return new UserService();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
      daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
      daoauthenticationProvider.setUserDetailsService(getUserService());
      return daoauthenticationProvider;
      
      
      @Bean 
      public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
        
        
    }
     public SecurityConfig(UserService userPrincipalDetailsService){
         this.userDetailService = userPrincipalDetailsService;
         
     }
     @Override
     protected void configure(AuthenticationManagerBuilder auth){
         auth.authenticationProvider(authenticationProvider());
         
         
         
         
     }
     
     @Override
     protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/persona"  , "/login")
                .hasRole("Admin")
                
                
               
     }
      
    }
    
    
    

