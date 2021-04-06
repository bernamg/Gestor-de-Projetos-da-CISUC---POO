/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe onde estão guardados nas listas de projetos, projetos concluidos e pessoas
 * todos os dados do programa.
 * 
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Gestor implements Serializable{
    
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Projeto> projetos;
    private ArrayList<Projeto> projetosConcluidos;
    
    /**
     * Construtor de objetos da classe.
     * Inicializa três ArrayLists, projetos, projetos concluídos e pessoas.
     */
    public Gestor(){

        this.pessoas = new ArrayList<>();
        this.projetos = new ArrayList<>();
        this.projetosConcluidos = new ArrayList<>();
    }
    
    /**
     * 
     * @return Lista de pessoas existentes no sistema
     */
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    /**
     * 
     * @return Lista de projetos que ainda não foram terminados 
     */
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
    
    /**
     * Adiciona um projeto à lista de projetos
     * 
     * @param projeto Objeto do tipo Projeto
     */
    public void novoProjeto(Projeto projeto){
        
        this.projetos.add(projeto);   
    }
    
    /**
     * Adiciona um licenciado à lista de pessoas
     * 
     * @param licenciado Objeto do tipo Licenciado
     */
    public void registaLicenciado(Licenciado licenciado){
        
        this.pessoas.add(licenciado);   
    } 
    
    /**
     * Adiciona um mestre à lista de pessoas
     * 
     * @param mestre Objeto do tipo Mestre
     */
    public void registaMestre(Mestre mestre){
        
        this.pessoas.add(mestre);   
    }
    
    /**
     * Adiciona um doutorado à lista de pessoas
     * 
     * @param doutor Objeto do tipo Doutorado
     */
    public void registaDoutorado(Doutorado doutor){
        
        this.pessoas.add(doutor);  
    }
    
    /**
     * 
     * @return ArrayList com os projetos concluidos
     */
    public ArrayList<Projeto> getProjetosConcluidos() {
        return projetosConcluidos;
    }
    /**
     * Adiciona docente à lista de pessoas
     * 
     * @param docente Objeto do tipo Docente
     */
    public void registaDocente(Docente docente){
        
        this.pessoas.add(docente);
    }
    /**
     * Na primeira utilização, inicia o programa através da leitura de dados de um ficheiro do tipo txt
     * Carrega dados de pessoas, projetos e tarefas para as suas classes certas e adiciona todas as classes 
     * às listas a que pertencem.
     * Na segunda utilização vai ler de um ficheiro objeto que foi posteriormente criado.
     * 
     * @return  um ficheiro objeto do tipo Gestor
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Gestor leFicheiro() throws IOException, ClassNotFoundException{
        
        File f = new File("objeto.obj");
        Gestor gestor = new Gestor();
        String linha;
        String dados[];
        Docente docente;
        Licenciado licenciado;
        String orientadores[];
        String data[];
        ArrayList<Docente> orientadoresList;
        GregorianCalendar dataInit;
        GregorianCalendar dataFim;
        Docente orientador;
        Mestre mestre;
        Doutorado doutorado;
        int numLinha = 0;
        int duracao;
        String tarefas[];
        String registar[];
        String bolseiros[];
        Docente ip;
        Pessoa responsavel;
        Documentacao documentacao;
        Design design;
        Desenvolvimento desenvolvimento;
        Projeto projeto;
        String temp[];
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            gestor = (Gestor) ois.readObject();
            ois.close();      
            
        }catch(FileNotFoundException e){
            System.out.println("Dados carregados do ficheiro texto");
           
            try{
                f = new File("Dados.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                
                while("endDOCENTES".equals(linha = br.readLine()) != true){
                    numLinha++;
                    try{
                        dados = linha.split(",");

                        docente = new Docente(dados[0],dados[1],dados[2], Integer.parseInt(dados[3]));
                        gestor.getPessoas().add(docente);
                        
                    }catch(ArrayIndexOutOfBoundsException | NumberFormatException exp){
                        System.out.println("Docente na linha (" + numLinha + ") nao registado");
                    }
                }
                numLinha++;
                while("endLICENCIADOS".equals(linha = br.readLine()) != true){
                    numLinha++;
                    try{
                        dados = linha.split(":");
                        
                        orientadores = dados[1].split(",");
                        dados = dados[0].split(",");
                        
                        dataInit = new GregorianCalendar();
                        dataFim = new GregorianCalendar();
                        
                        data = dados[2].split("[-/]+");
                        dataInit.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataInit.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataInit.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        data = dados[3].split("[-/]+");
                        dataFim.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataFim.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataFim.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        orientadoresList = new ArrayList<>();
                        
                        for(Pessoa pessoa : gestor.getPessoas()){
                            if(pessoa.getNumero() != -1){
                                orientador = (Docente) pessoa;
                                for(String a : orientadores){
                                    if(a.equals(orientador.getEmail())){
                                        orientadoresList.add(orientador);
                                    }
                                }
                            }
                        }
                        
                        
                        licenciado = new Licenciado(dados[0],dados[1],dataInit,dataFim,orientadoresList);
                        gestor.getPessoas().add(licenciado);
                        
                    }catch(ArrayIndexOutOfBoundsException | NumberFormatException exp){
                        System.out.println("Licenciado na linha (" + numLinha + ") nao registado");
                    }  
                }
                
                numLinha++;
                while("endMESTRES".equals(linha = br.readLine()) != true){
                    numLinha++;
                    try{
                        dados = linha.split(":");

                        orientadores = dados[1].split(",");
                        dados = dados[0].split(",");
                        
                        dataInit = new GregorianCalendar();
                        dataFim = new GregorianCalendar();
                        
                        data = dados[2].split("[-/]+");
                        dataInit.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataInit.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataInit.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        data = dados[3].split("[-/]+");
                        dataFim.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataFim.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataFim.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        orientadoresList = new ArrayList<>();
                        
                        for(Pessoa pessoa : gestor.getPessoas()){
                            if(pessoa.getNumero() != -1){
                                orientador = (Docente) pessoa;
                                for(String a : orientadores){
                                    if(a.equals(orientador.getEmail())){
                                        orientadoresList.add(orientador);
                                    }
                                }
                            }
                        }
                        
                        
                        mestre = new Mestre(dados[0],dados[1],dataInit,dataFim, orientadoresList);
                        gestor.getPessoas().add(mestre);

                    }catch(ArrayIndexOutOfBoundsException | NumberFormatException exp){
                        System.out.println("Mestre na linha (" + numLinha + ") nao registado");
                    }
                    
                }
                
                numLinha++;
                while("endDOUTOURADOS".equals(linha = br.readLine()) != true){
                    numLinha++;
                    try{
                        dados = linha.split(",");
                        
                        dataInit = new GregorianCalendar();
                        dataFim = new GregorianCalendar();
                        
                        data = dados[2].split("[-/]+");
                        dataInit.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataInit.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataInit.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        data = dados[3].split("[-/]+");
                        dataFim.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataFim.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataFim.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        
                        doutorado = new Doutorado(dados[0],dados[1],dataInit,dataFim);
                        gestor.getPessoas().add(doutorado);

                    }catch(ArrayIndexOutOfBoundsException | NumberFormatException exp){
                        System.out.println("Doutorado na linha (" + numLinha + ") nao registado");
                    }
                }
                numLinha++;
                
                while("endPROJETOS".equals(linha = br.readLine()) != true){
                    numLinha++;
                    projeto = null;
                    try{
                        dataInit = new GregorianCalendar();
                        dados = linha.split(":");
                        
                        registar = dados[1].split(",");
                        bolseiros = dados[2].split(",");
                        tarefas = dados[3].split(";");
                        
                        dados = dados[0].split(",");
                        
                        data= dados[2].split("[/-]+");
                        
                        dataInit.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                        dataInit.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                        dataInit.set(Calendar.YEAR,Integer.parseInt(data[2]));
                        
                        duracao = Integer.parseInt(dados[3]);
                        
                        for(Pessoa pessoa : gestor.getPessoas()){
                            if(pessoa.getNumero() != -1){
                                docente = (Docente) pessoa;
                                if(pessoa.getEmail().equals(dados[4]) == true){
                                    ip = docente; 
                                    projeto = new Projeto(dados[0], dados[1], dataInit, duracao, ip);
                                    gestor.getProjetos().add(projeto);                                 
                                }
                            }
                        }
                        
                        if(projeto != null){
                            for(String email: registar){
                                
                                for(Pessoa a : gestor.getPessoas()){
                                     if(email.equals(a.getEmail()) && a.getNumero() != -1){
                                         if(projeto.verificaDocenteProjeto(email) == true){
                                            projeto.getDocentes().add((Docente)a);
                                         }
                                         else{
                                             System.out.println(a + "Nao adicionado");
                                         }
                                    }
                                }
                            } 
                            for(String email: bolseiros){
                                for(Pessoa a : gestor.getPessoas()){
                                    if(email.equals(a.getEmail()) && a.getNumero() == -1){ 
                                        Bolseiro b = (Bolseiro) a;
                                        if(b.getOrdenado() == 1200 && b.getContador() == 0){
                                            b.setEntradaProj(dataInit);
                                            b.setContador(1);
                                            projeto.getBolseiros().add(b);     
                                        }
                                        else if(b.getOrdenado() != 1200 && b.getContador() == 0){
                                             ComOrientador c = (ComOrientador) b;
                                             for(Docente orienta: c.getOrientadores()){
                                                 email = orienta.getEmail();
                                                 if(projeto.verificaOrientadorProjeto(email) == true && b.getContador() == 0){
                                                     b.setEntradaProj(dataInit);
                                                     b.setContador(1);
                                                     projeto.addBolseiro(b);
                                                 } 
                                             }
                                        }
                                    }
                                }
                            }
                            try{
                                for(String t : tarefas){
                                    float carga;
                                    dataInit = new GregorianCalendar();
                                    dataFim = new GregorianCalendar();
                                    
                                    temp = t.split(",");
                                    String tipoTarefa = temp[0];
                                    
                                    data = temp[1].split("[/-]+");        
                                    duracao = Integer.parseInt(temp[2]);
                                    String email = temp[3];
                                    
                                    
                                    dataInit.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]));
                                    dataInit.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                                    dataInit.set(Calendar.YEAR,Integer.parseInt(data[2]));
                                    
                                    dataFim.set(Calendar.DAY_OF_MONTH,Integer.parseInt(data[0]) + duracao);
                                    dataFim.set(Calendar.MONTH,Integer.parseInt(data[1])-1);
                                    dataFim.set(Calendar.YEAR,Integer.parseInt(data[2]));
                                    
                                    responsavel = null;
                                    for(Docente d : projeto.getDocentes()){
                                            if(d.getEmail().equals(email)){
                                                responsavel = (Pessoa) d;
                                            }
                                     }
                                     for(Bolseiro b : projeto.getBolseiros()){
                                         if(b.getEmail().equals(email)){
                                            responsavel = (Pessoa)b;       
                                         }
                                    }
                                    if(responsavel != null){ 
                                        if(tipoTarefa.equals("Design") || tipoTarefa.equals("design")){
                                            carga = (float)0.5;
                                            design = new Design(dataInit,duracao,responsavel);
                                            if(responsavel.verificaEsforco(dataInit, dataFim, carga) == true){
                                                        responsavel.addTarefa(design);
                                                        projeto.addTarefa(design);
                                                    }
                                        }
                                        else if(tipoTarefa.equals("Documentacao") || tipoTarefa.equals("documentacao")){
                                            carga = (float)0.25;
                                            documentacao = new Documentacao(dataInit,duracao,responsavel);
                                            if(responsavel.verificaEsforco(dataInit, dataFim, carga) == true){
                                                        responsavel.addTarefa(documentacao);
                                                        projeto.addTarefa(documentacao);
                                                    }
                                        }
                                        else if(tipoTarefa.equals("Desenvolvimento") || tipoTarefa.equals("desenvolvimento")){
                                            carga = 1;
                                            desenvolvimento = new Desenvolvimento(dataInit,duracao,responsavel);
                                            if(responsavel.verificaEsforco(dataInit, dataFim, carga) == true){
                                                        responsavel.addTarefa(desenvolvimento);
                                                        projeto.addTarefa(desenvolvimento);
                                                    }
                                        }
                                        else{
                                            System.out.println("Tarefa[" + tipoTarefa + "] nao adicionada na linha " + numLinha);
                                        }
                                    }
                                    else{
                                        System.out.println("Tarefa["+ tipoTarefa+"] nao adicionada na linha:"+ numLinha  +" " + email +" nao existente");
                                    }  
                                }
                            }
                            catch(NullPointerException excpt){
                                System.out.println("Tarefa nao adicionada na linha " + numLinha);
                            }
                        }
                        
                         
                    }catch(ArrayIndexOutOfBoundsException exp){
                        System.out.println("Projeto na linha (" + numLinha + ") nao registado");
                    }catch(NumberFormatException exp){
                        System.out.println("Projeto na linha (" + numLinha + ") nao registado");
                    }
                }
                
                fr.close();
            }catch(FileNotFoundException ex){
                System.out.println("Ficheiro texto nao existe");
            }
            
        }
        return gestor;
    }
    
    /**
     * Guarfa todos os dados relativos ao programa num ficheiro objeto
     * @param g objeto do tipo Gestor
     */
    public void guardaFicheiro(Gestor g){
        
        File f = new File("objeto.obj");
        
        try{
            FileOutputStream os = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            oos.writeObject(g);
            
            oos.close();
            
        }catch(FileNotFoundException ex){
            System.out.println("Erro a criar ficheiro");
        }
        catch(IOException ex){
            System.out.println("Erro a escrever para ficheiro");
        }
    }
}
