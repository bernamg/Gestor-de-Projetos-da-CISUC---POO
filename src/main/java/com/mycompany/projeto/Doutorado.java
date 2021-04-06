/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Subclasse de Bolseiro, representa os doutorados
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Doutorado extends Bolseiro implements Serializable{
    
    /**
     * Costrutor da classe Doutorado
     * 
     * @param nome - Nome da pessoa
     * @param email - Email da pessoa
     * @param contratoInit - Data inicial do contrato de Bolseiro
     * @param contratoFim  - Data final do contrato de Bolseiro
     */
    public Doutorado(String nome, String email, Calendar contratoInit, Calendar contratoFim){
        
        super(nome, email, contratoInit, contratoFim);
        this.ordenado = 1200;
        
    }
    
    @Override
     public String toString(){
        return nome + " (Doutorado)" ;
    }
    
}
