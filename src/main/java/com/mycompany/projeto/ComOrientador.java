/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Subclasse de Bolseiro, representa os bolseiros que têm orientador
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public abstract class ComOrientador extends Bolseiro {
    
    protected ArrayList<Docente> orientadores = new ArrayList<>();
    
    /**
     * Construtor da classe abstrata ComOrientador
     * 
     * @param nome - Nome da Pessoa
     * @param email - Email da pessoa
     * @param contratoInit - Data do inicio do contrato de bolseiro
     * @param contratoFim - Data do fim do contrato de bolseiro
     */
    public ComOrientador(String nome, String email, Calendar contratoInit, Calendar contratoFim){ 
        
        super(nome,email,contratoInit,contratoFim);
    }
    
    /**
     *
     * @return lista com orientadores
     */
    public ArrayList<Docente> getOrientadores() {
        return orientadores;
    }
    
}
