
package com.tienda.Controller;


public class PersonaController {
   @GetMapping("/delete/id")
   public String eliminarPersona(@PathVariable("id") Long idpersona ){
       personaService.delete(idpersona);
       return "redirect:/persona";
       
   }
   @PostMapping("/save")
   public String guardarPersona (@ModelAttribute Persona persona ) {
       personaService.savePersona(persona);
       return "redirect:/persona";
       
   }
   @GetMapping ("/editPersona/id")
   public String editarPersona (@PathVariable("id ")Long idPersona, Mode1 mode1){
       
   }
}
