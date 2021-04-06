/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe para objetos que representam os projetos no programa
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Projeto implements Serializable {
    
    private String nome;
    private String acronimo;
    private Calendar iniData;
    private Calendar finalData;
    private int duracao;
    private Docente ip;
    private ArrayList<Docente> docentes;
    private ArrayList<Bolseiro> bolseiros;
    private ArrayList<Tarefa> tarefas;
    
    /**
     * Construtor do Tipo Projeto
     * @param nome - Nome de Projeto
     * @param acronimo - Acronimo do Projeto
     * @param iniData - Data inicial do Projeto
     * @param duracao - Duração Prevista do Projeto
     * @param ip - Investigador Principal do Projeto
     */
    public Projeto(String nome, String acronimo, Calendar iniData, int duracao, Docente ip){
        
        this.nome = nome;
        this.acronimo = acronimo;
        this.iniData = iniData;
        this.duracao = duracao;
        this.finalData = new GregorianCalendar();
        this.finalData.set(Calendar.DAY_OF_MONTH,this.iniData.get(Calendar.DAY_OF_MONTH));
        this.finalData.set(Calendar.MONTH,this.iniData.get(Calendar.MONTH));
        this.finalData.set(Calendar.YEAR,this.iniData.get(Calendar.YEAR));
        this.finalData.add(Calendar.MONTH, duracao);    
        this.ip = ip;
        this.docentes = new ArrayList<>();
        this.bolseiros = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    /**
     * Associa um docente ao projeto
     * @param docente - Pessoa do tipo Docente 
     */
    public void addDocente(Docente docente) {
        this.docentes.add(docente);
    }
    
    /**
     * Associa um bolseiro ao projeto
     * @param bolseiro - Pessoa do tipo Bolseiro
     */
    public void addBolseiro(Bolseiro bolseiro) {
        this.bolseiros.add(bolseiro);
    }

     /**
     * 
     * @return - Devolve o nome do projeto
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return - Devolve o acrónimo de projeto
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * ´
     * @return - Devolve a data inicial do projeto 
     */
    public Calendar getIniData() {
        return iniData;
    }

    /**
     * 
     * @return - devolve a data final prevista do projeto 
     */
    public Calendar getFinalData() {
        return finalData;
    }

    /**
     * 
     * @return - Devolve a duração prevista do projeto
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * 
     * @return - Devolve o Investigador Principal do projeto que tem de ser do tipo Docente 
     */
    public Pessoa getIp() {
        return ip;
    }

    /**
     * 
     * @return - Devolve o Array dos Docentes associado ao Projeto
     */
    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    /**
     * 
     * @return - Devolve o Array de Bolseiros associados ao projeto
     */
    public ArrayList<Bolseiro> getBolseiros() {
        return bolseiros;
    }

    /**
     * 
     * @return - Devolve o Array de Tarefas existentes no projeto 
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    /**
     * Converte a data inicial do tipo Calendar para String 
     * @return Devolve uma string com a data inicial do projeto
     */
    public String getIniDataStr(){
        String d, m, a;
        int dia,mes,ano;
        dia = this.iniData.get(Calendar.DAY_OF_MONTH);
        mes = this.iniData.get(Calendar.MONTH)+1;
        ano = this.iniData.get(Calendar.YEAR);
        d = Integer.toString(dia);
        m = Integer.toString(mes);
        a = Integer.toString(ano);
        
        return d+"/"+m+"/"+a;
    }
    
    /**
     * Converte a data final do tipo Calendar para String
     * @return Devolve uma string com a data final prevista do projeto
     */
    public String getFimDataStr(){
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
    
    /**
     * Função para verificar se Docente já está inserido  no respetivo Projeto 
     * @param email  email do Docente que queremos verificar
     * @return Devolve true se o docente não estiver no Projeto e false se estiver associado
     */
    public boolean verificaDocenteProjeto(String email){
         
         for(Docente docente : this.docentes){
             if(docente.getEmail().equals(email) == true){
                 return false;
                 
             }
         }
         if(ip.getEmail().equals(email) == true){
             return false;
         }
         else{
             return true;
         }
    }
     
    /**
     * Verifica
     * @param email Recebe o mail do respetivo orientador
     * @return Devolve true se esse docente estiver no projeto e false se não estiver associado 
     */
    public boolean verificaOrientadorProjeto(String email){
        int count = 0;
        
        for(Docente docente: this.docentes){
            if(docente.getEmail().equals(email) == true){
                count++;
            }
        }
        if(ip.getEmail().equals(email) == true || count > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Função para determinar o custo atual do projeto
     * @return Devolve custo atual do projeto
     */
    public int getCusto(){
        
        Calendar temp = new GregorianCalendar();
        int dia, mes, ano;
        int contador = 0;
        int custo = 0;
        Calendar hoje = new GregorianCalendar();
        
        for(Bolseiro bolseiro: this.bolseiros){
            contador =0;
            dia = bolseiro.getEntradaProj().get(Calendar.DAY_OF_MONTH);
            mes = bolseiro.getEntradaProj().get(Calendar.MONTH);
            ano = bolseiro.getEntradaProj().get(Calendar.YEAR);
            
            temp.set(Calendar.DAY_OF_MONTH, dia);
            temp.set(Calendar.MONTH, mes);
            temp.set(Calendar.YEAR, ano);
            
            while(temp.compareTo(hoje) < 0){
                temp.add(Calendar.DAY_OF_MONTH,1);
                contador ++;
            }
            contador++;
            contador = contador / 30;
            contador = contador * bolseiro.getOrdenado();
            custo = custo + contador;
        }
        return custo;
    }
    
    /**
     * Função para adicionar ao array das tarefas do projeto uma outra tarefa
     * @param tarefa Tarefa a ser adicionada ao projeto
     */
     public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }
    
    /**
    * Função para verificar se o projeto em questão está concluido (Todas as tarefas com taxa a 100)
    * @return Devolve True se o projeto estiver concluido e false se não estiver 
    */
    public boolean checkProjetoConcluido(){

        if(this.tarefas.isEmpty()){
            return false;
        }
        else{
           for(Tarefa t: this.tarefas){
               if(t.getTaxa() !=100){
                   return false;
               }
           }
           return true;
        }
    }

    /**
    * Atualiza a data final do projeto quando se termina as tarefas de um projeto depois 
    * de passada a sua data final prevista
    */
    public void atualizaDataFinal(){

       Calendar hoje = new GregorianCalendar();

       this.finalData.set(Calendar.DAY_OF_MONTH,hoje.get(Calendar.DAY_OF_MONTH));
       this.finalData.set(Calendar.MONTH,hoje.get(Calendar.MONTH));
       this.finalData.set(Calendar.YEAR,hoje.get(Calendar.YEAR));

    }

}
