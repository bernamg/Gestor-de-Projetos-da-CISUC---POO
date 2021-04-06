/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.Calendar;

/**
 * Subclasse de Tarefa, representa a tarefa design
 * 
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Design extends Tarefa {
    
    /**
     * Construtor do objeto do tipo Design
     * @param iniData - Data Inicial da Tarefa Design
     * @param duracao - Duração prevista da tarefa
     * @param responsavel - Responsável pela Tarefa
     */
    public Design(Calendar iniData, int duracao, Pessoa responsavel){
        super(iniData, duracao, responsavel);
        this.peso = (float) 0.5;
    }

    @Override
    public float getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return "Design: "+this.responsavel+" Taxa: "+this.taxa+" Fim Previsto: "+this.getFimDataStrTarefa();
    }
}
