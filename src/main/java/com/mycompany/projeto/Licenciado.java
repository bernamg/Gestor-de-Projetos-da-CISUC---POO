/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Subclasse de ComOrientador, representa os licenciados
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Licenciado extends ComOrientador implements Serializable{
    
    /**
     * 
     * @param nome - Nome da pessoa
     * @param email - Email da pessoa
     * @param contratoInit - Data inicial do contrato de Bolseiro
     * @param contratoFim - Data final do contrato de Bolseiro
     * @param orientadoresList 
     */
    public Licenciado(String nome, String email, Calendar contratoInit, Calendar contratoFim, ArrayList<Docente> orientadoresList){
        
        super(nome, email, contratoInit, contratoFim);
        this.ordenado = 800;
        this.orientadores = orientadoresList;  
    }
    
    @Override
     public String toString(){
        return nome + " (Licenciado)" ;
    }

}
