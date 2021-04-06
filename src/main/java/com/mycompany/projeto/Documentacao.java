/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.Calendar;

/**
 * Subclasse de Tarefa, representa a tarefa documentação
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Documentacao extends Tarefa {
    
    /**
     * Construtor do objeto do tipo Documentacao
     * @param iniData - Data inicial da tarefa
     * @param duracao - Duração Prevista da Tarefa
     * @param responsavel - Pessoa responsável pela tarefa
     */
    public Documentacao(Calendar iniData, int duracao, Pessoa responsavel){
 
        super(iniData, duracao, responsavel);
        this.peso = (float) 0.25;
    }
    
    @Override
    public float getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return "Documentacao: "+this.responsavel+" Taxa: "+this.taxa+" Fim Previsto: "+this.getFimDataStrTarefa();
    }
}
