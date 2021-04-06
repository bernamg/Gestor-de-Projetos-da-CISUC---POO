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
 * Classe abstrata que representa as tarefas
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public abstract class Tarefa implements Serializable{
    
    protected Calendar iniData;
    protected Calendar finalData;
    protected int duracao;  
    protected Pessoa responsavel;
    protected int taxa; 
    protected float peso;
    
    /**
     * Construtor do objeto tipo Tarefa
     * @param iniData - Data de inicio da Tarefa
     * @param duracao - Duração da Tarefa
     * @param responsavel - Responsável pela Tarefa
     */
    public Tarefa(Calendar iniData, int duracao, Pessoa responsavel){
        
        this.iniData = iniData;
        this.duracao = duracao;
        this.responsavel = responsavel;
        this.finalData = new GregorianCalendar();
        this.finalData.set(Calendar.DAY_OF_MONTH,this.iniData.get(Calendar.DAY_OF_MONTH));
        this.finalData.set(Calendar.MONTH,this.iniData.get(Calendar.MONTH));
        this.finalData.set(Calendar.YEAR,this.iniData.get(Calendar.YEAR));
        this.finalData.add(Calendar.DAY_OF_MONTH, duracao);  
        this.taxa = 0;
    }
    
    /**
     * 
     * @return Peso de determinada tarefa consoante seja Desenvolvimento, Design ou Documentação
     */
    public float getPeso() {
        return peso;
    }
    
    /**
     * 
     * @return - Devolve a taxa de conclusão da respetiva tarefa
     */
    public float getTaxa() {
        return taxa;
    }

    /**
     * 
     * @return - Devolve o Responsável pela tarefa em questão
     */
    public Pessoa getResponsavel() {
        return responsavel;
    }
    
    /**
     * Recebe um inteiro e iguala o atributo "taxa" a esse valor
     * @param taxa - Taxa de realização de uma tarefa
     */
    public void setTaxa(int taxa) {
        this.taxa = taxa;
    }

    /**
     * 
     * @return - Devolve a data inicial da tarefa 
     */
    public Calendar getIniData() {
        return iniData;
    }

    /**
     * 
     * @return - Devolve a data final prevista da tarefa
     */
    public Calendar getFinalData() {
        return finalData;
    }
    
    /**
     * 
     * @return - Devolve true se ainda não tiver passado a data final prevista da tarefa e true se já tiver passado
     */
    public boolean checkLegitData(){
       
        Calendar atual;
        atual = Calendar.getInstance();
        
        // Se for maior que 0 o atual é depois do finaldata se for meno o final é depois do atual
        if (atual.compareTo(finalData)>0){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * 
     * @return - Converte de Calendar para String e devolve a data prevista do final da tarefa 
     */
    public String getFimDataStrTarefa(){
        String d, m, a;
        int dia,mes,ano;
        dia = this.finalData.get(Calendar.DAY_OF_MONTH);
        mes = this.finalData.get(Calendar.MONTH)+1;
        ano = this.finalData.get(Calendar.YEAR);
        d = Integer.toString(dia);
        m = Integer.toString(mes);
        a = Integer.toString(ano);
        
        return d+"/"+m+"/"+a;
    }

}
