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
 *
 * Subclasse de ComOrientador, representa os Mestres.
 * 
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Mestre extends ComOrientador implements Serializable{
    
    /**
     * 
     * @param nome - Nome da pessoa
     * @param email - Email da pessoa
     * @param contratoInit - Data de inicio de contrato de Bolseiro
     * @param contratoFim - Data de final de contrato de Bolseiro
     * @param orientadoresList - Lista com orientadores do Bolseiro
     */
    public Mestre(String nome, String email, Calendar contratoInit, Calendar contratoFim, ArrayList<Docente> orientadoresList){
        
        super(nome, email, contratoInit, contratoFim);
        this.ordenado = 1000;
        this.orientadores = orientadoresList;
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
     public String toString(){
        return nome + " (Mestre)" ;
    }
    
}
