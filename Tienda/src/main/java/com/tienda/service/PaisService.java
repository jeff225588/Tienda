/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaisService implements IpaisService {

    @Autowired 
    private PaisRepository paisRepository;
    
    
    
    @Override
    public List<pais> listCountry() {
       return (List<pais>)PaisRepository.findAll;
       
    }
    
    
    
}
