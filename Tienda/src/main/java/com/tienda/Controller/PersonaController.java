
package com.tienda.Controller;

import com.tienda.entity.pais;
import com.tienda.entity.persona;
import com.tienda.service.IpaisService;
import com.tienda.service.IpersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PersonaController {
    
    @Autowired
    private IpersonaService personaService;
    
    @Autowired
    private IpaisService paisService;
    
    @GetMapping("/persona")
    public String index(Model model){
    List<persona> listaPersona= personaService.getALLPersona();
    model.addAttribute("Titulo","Tabla Personas");
    model.addAttribute("personas", listaPersona);
    return "personas";
    }
    
    @GetMapping("/persona")
    public String crearPersona (Model model){
        
     List<pais> listaPaises = paisService.listCountry();
     model.addAttribute("Persona", new persona());
     model.addAttribute("paises", listaPaises);
     return "crear";
     
    }
}


