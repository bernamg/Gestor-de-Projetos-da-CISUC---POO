/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Subclasse de Pessoa, representa os bolseiros
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public abstract class Bolseiro extends Pessoa {
    
    protected Calendar contratoInit;
    protected Calendar contratoFim;
    protected int ordenado;
    protected int contador;
    protected Calendar entradaProj; 
    
    /**
     * Construtos da classe abstrata Bolseiro
     * @param nome - Nome da pessoa
     * @param email - Email da pessoa
     * @param contratoInit - Data de inicio de contrato do Bolseiro
     * @param contratoFim - Data do fim de contrato do Bolseiro
     */
    public Bolseiro(String nome, String email, Calendar contratoInit, Calendar contratoFim){
        
        super(nome,email);
        this.contratoInit = contratoInit;
        this.contratoFim = contratoFim;
        this.contador = 0;
        this.entradaProj = new GregorianCalendar();
    }
    
    /**
     * Serve para destinguir Bolseiro de Docente
     * @return -1 
     */
    @Override
    public int getNumero() {
        return -1;
    }
    /**
     * 
     * @return contador que indica se está livre ou ocupado
     */
    public int getContador(){
        return contador;
    }
    
    /**
     * 
     * @return ordenado da pessoa
     */
    public int getOrdenado() {
        return ordenado;
    }
    
    /**
     * 
     * @return Data em que bolsiro entrou no projeto 
     */
    public Calendar getEntradaProj() {
        return entradaProj;
    }
    
    /**
     * Atribui valor ao contador que indica se está em algum 
     * projeto ou não.
     * 
     * @param contador 
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
    /**
     * Atribui data em de entrada no projeto
     * 
     * @param entradaProj 
     */
    public void setEntradaProj(Calendar entradaProj) {
        int dia, mes, ano;
        dia = entradaProj.get(Calendar.DAY_OF_MONTH);
        mes = entradaProj.get(Calendar.MONTH);
        ano = entradaProj.get(Calendar.YEAR);
        this.entradaProj.set(Calendar.DAY_OF_MONTH, dia);
        this.entradaProj.set(Calendar.MONTH, mes);
        this.entradaProj.set(Calendar.YEAR, ano);
    }
    
    @Override
    public boolean verificaEsforco(Calendar ini, Calendar fim, float peso){
        
        float sobrecarga = 0;
        float maximo = 0;
        Calendar temp = new GregorianCalendar();
        temp.set(Calendar.DAY_OF_MONTH,ini.get(Calendar.DAY_OF_MONTH));
        temp.set(Calendar.MONTH,ini.get(Calendar.MONTH));
        temp.set(Calendar.YEAR,ini.get(Calendar.YEAR));
        
        if(ini.compareTo(contratoInit) < 0 || fim.compareTo(contratoFim)>0){
            return false;
        }
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
