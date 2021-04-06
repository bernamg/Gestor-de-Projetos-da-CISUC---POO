/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Subclasse de Pessoa, representa os docentes
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Docente extends Pessoa implements Serializable{
    private int numeroDocente;
    private String areaInv;
    
    /**
     * Construtor da classe Docente
     * @param nome - Nome da pessoa
     * @param email - Email da Pessoa
     * @param areaInv - Area de Investigação da pessoa
     * @param numeroDocente - Numero mecanográfico do docente
     */
    public Docente(String nome, String email, String areaInv, int numeroDocente){
        super(nome, email);
        this.areaInv = areaInv;
        this.numeroDocente = numeroDocente;
        
    }
 
    @Override
    public int getNumero() {
        return numeroDocente;
    }

    @Override
    public String toString(){
        return nome + " (Docente)";
    }
      
    @Override
    public boolean verificaEsforco(Calendar ini, Calendar fim, float peso){
        
        float sobrecarga = 0;
        float maximo = 0;
        Calendar temp = new GregorianCalendar();
        temp.set(Calendar.DAY_OF_MONTH,ini.get(Calendar.DAY_OF_MONTH));
        temp.set(Calendar.MONTH,ini.get(Calendar.MONTH));
        temp.set(Calendar.YEAR,ini.get(Calendar.YEAR));
        

        while(temp.compareTo(fim) <= 0 ){
            sobrecarga = 0;
            for(Tarefa tarefa : this.tarefas){
                if((temp.compareTo(tarefa.getIniData()) == 0 || temp.compareTo(tarefa.getIniData()) > 0) && (temp.compareTo(tarefa.getFinalData()) == 0 || temp.compareTo(tarefa.getFinalData()) < 0)){
                    sobrecarga += tarefa.peso;
                    }
                }
            if(sobrecarga > maximo){
                maximo = sobrecarga;
            }
            temp.add(Calendar.DAY_OF_MONTH, 1);
        }
        if((maximo + peso) > 1){
            return false;
        }
        else{
            return true;
        }
        
    }

    
}
