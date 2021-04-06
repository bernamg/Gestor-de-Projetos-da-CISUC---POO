/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.Calendar;

/**
 * Subclasse de Tarefa, representa a tarefa desenvolvimento
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Desenvolvimento extends Tarefa {
    
    /**
     * Contrutor do objeto do tipo desenvolvimento
     * ´@param iniData - Data inicial da tarefa
     * @param duracao - Duração prevista da tarefa
     * @param responsavel - Responsável pela tarefa
     */
    public Desenvolvimento(Calendar iniData, int duracao, Pessoa responsavel){
 
        super(iniData, duracao, responsavel);
        this.peso = 1;
    }
    
    @Override
    public float getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return "Desenvolvimento: "+this.responsavel+" Taxa: "+this.taxa+" Fim Previsto: "+this.getFimDataStrTarefa();
    }
}
