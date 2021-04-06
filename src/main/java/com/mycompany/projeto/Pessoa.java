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
 * Classe abstrata que representa as pessoas criadas
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public abstract class Pessoa implements Serializable {
    
    protected String nome;
    protected String email;
    protected float esforco;
    protected ArrayList<Tarefa> tarefas;
    
    
    /**
     * Construtor da classe abstrata Pessoa
     * @param nome - Nome da pessoa
     * @param email - Email da pessoa
     */
    
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.esforco = 0;
        this.tarefas = new ArrayList<>();
    }
    /**
     *
     * @return Número mecanográfico da pesso
     */
    abstract public int getNumero();  
    
    /**
     * Método abstrato que vai verificar o esforço da pessoa em todos os dias
     * que a tarefa vai ocupar
     * 
     * @param ini - tempo inicial da tarefa a atribuir
     * @param fim - tempo final da terefa a atribuir
     * @param peso - peso da tarefa a atribuir
     * @return true - caso possa aceitar a tarefa
     */
    abstract  public boolean verificaEsforco(Calendar ini, Calendar fim, float peso);
    
    /**
     *
     * 
     * @return Nome da pessoa 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @return Devolve o email da pessoa
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @return Esforço acumulado
     */
    public float getEsforco() {
        return esforco;
    }
    /**
     * 
     * @return lista de tarefas 
     */
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    /**
     * Recebe o peso da tarefa que lhe foi atribuida
     * 
     * @param esforco - peso da tarefa
     */
    public void setEsforco(float esforco) {
        this.esforco = esforco;
    }
    /**
     * Recebe uma objeto do tipo Tarefa e adiciona-o à lista de tarefas
     * da pessoa.
     * 
     * @param tarefa - Desenvolvimento, Design ou Documentacao
     */
    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        this.esforco += tarefa.getPeso();
    }
    
}