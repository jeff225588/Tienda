
package com.tienda.Controller;

import org.springframework.web.bind.annotation.GetMapping;


public class logincontroller {
    
@GetMapping("/login")
public String index(){
    return"/login";
}

    
}
