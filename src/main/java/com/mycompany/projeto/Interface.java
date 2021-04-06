/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Classe Interface, cria toda a interface do programa
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Interface extends JFrame {
    
    
    private JLayeredPane layered;
    private Gestor gestor;
    
    //Global Variables
    private Projeto projetoSelecionado = null;
    private Calendar dataAtual = Calendar.getInstance();
    private Pessoa pessoaSelecionada = null;
    Desenvolvimento desenvolvimento = null;
    Design design = null;
    Documentacao documentacao = null;
    GregorianCalendar iniDataTarefa = null;
    GregorianCalendar fimDataTarefa = null;
    int tipoTarefa = 0;
    int duracao = 0;
    
    
    //Menu variables
    private JPanel panelMenu;
    private JLabel titulo;
    private JButton registerButton, newProjectButton, listButton, unfinishedButton, concludedButton;
    
    //Registo variables
    private JPanel panelRegisto;
    private JButton buttonLicenciado, buttonMestre, buttonDoutorado,buttonDocente,buttonVoltar;
    
    //Licenciado variables
    private JPanel panelLicenciado;
    private JLabel labelNomeL, labelMailL, labelDataIL, labelDataFL, labelOrientadorL;
    private JTextField nomeFieldL, emailFieldL, dataFFieldL, dataIFieldL;
    private JButton buttonGuardarL, buttonVoltarL;
    private JList listaOrientadoresL;
    private DefaultListModel listaDocentes;
    private JScrollPane scrollOrientadoresL;
    
    //Mestre variables
    private JPanel panelMestre;
    private JLabel labelNomeM, labelMailM, labelDataIM, labelDataFM, labelOrientadorM;
    private JTextField nomeFieldM, emailFieldM, dataFFieldM, dataIFieldM;
    private JButton buttonGuardarM, buttonVoltarM;
    private JList listaOrientadoresM;
    private JScrollPane scrollOrientadoresM;
    
    //Doutorado variables
    private JPanel panelDoutorado;
    private JLabel labelNomeDtr, labelMailDtr, labelDataIDtr, labelDataFDtr;
    private JTextField nomeFieldDtr, emailFieldDtr, dataFFieldDtr, dataIFieldDtr;
    private JButton buttonGuardarDtr, buttonVoltarDtr;
    
    //Docente variables
    private JPanel panelDocente;
    private JLabel labelNomeD, labelMailD, labelAreaD, labelNumeroD;
    private JTextField nomeFieldD, emailFieldD, areaFieldD, numeroFieldD;
    private JButton buttonGuardarD, buttonVoltarD;
    
    //Novo Projeto variables
    private JPanel panelNovoProjeto;
    private JLabel labelNomeNP, labelAcronimoNP, labelDataINP, labelDuracaoNP, labelInvestigadorNP;
    private JTextField nomeFieldNP, acronimoFieldNP, dataIFieldNP, duracaoFieldNP;
    private JButton buttonGuardarNP, buttonVoltarNP;
    private JList listaInvestigadoresP;
    private JScrollPane scrollInvestigadoresP;
    
    //Projetos
    private JPanel panelProjetos;
    private JLabel labelTituloProjetos;
    private JButton buttonSelecionaProjeto, buttonVoltarProjeto;
    private JList listaProjeto;
    private DefaultListModel defProjeto;
    private JScrollPane scrollProjeto;
    
    //Projeto Selecionado
    private JPanel panelProjetoSelecionado;
    private JLabel labelNomeSelecionado, labelAcronimoSelecionado, labelIniSelecionado, labelFimSelecionado, labelIpSelecionado;
    private JButton buttonCustoSelecionado, buttonVoltarSelecionado, buttonTarefasSelecionado, buttonPessoasSelecionado;
    
    //Pessoas Projeto
    private JPanel panelPessoasProjeto;
    private JLabel labelDocenteAssociado, labelBolseiroAssociado;
    private JButton buttonVoltarMenuProjeto, buttonAssocia;
    private JList listaDocentesAssociados, listaBolseirosAssociados;
    private DefaultListModel defDocentesAssociados;
    private DefaultListModel defBolseirosAssociados;
    private JScrollPane scrollDocentesAssociados, scrollBolseirosAssociados;
    
    //Associar Pessoas a Projetos
    private JPanel panelAssociaPessoas;
    private JLabel labelAssociaPessoas;
    private JButton buttonAssociaPessoa, buttonAssociaVoltar;
    private DefaultListModel pessoasProjeto;
    private JList listaAssociaPessoas;
    private JScrollPane scrollAssociaPessoas;
    
    //Projetos Concluidos
    private JPanel panelConcprojetos,  panelDetalhesConc;
    private JLabel labelnomeProjeto, labelacrProjeto, labeliniProjeto, labelfimProjeto, labelpessoaslistaProjeto, labelipProjeto, labeltarefasProjeto, labelCusto;
    private JButton buttonDetalhesConc, buttonVoltarConc, buttonVoltarDetalhes;
    private JList listaconcProjetos, listapessoasProjeto, listatarefasProjeto;
    private DefaultListModel concProjetos;
    private DefaultListModel defpessoasProjeto;
    private DefaultListModel deftarefasProjeto;
    private JScrollPane scrollconcProjetos, scrollpessoasProjeto, scrolltarefasProjeto;
    
    //Projetos Inacabados
    private JPanel panelInacabado, panelDetalhesInacabado;
    private JButton buttonIDetalhes, buttonIVoltar, buttonIVoltarDetalhes;
    private JLabel labelINomeProjeto, labelIAcrProjeto, labelInacabadoIniProjeto, labelIFimProjeto, labelIPessoasListaProjeto, labelIIpProjeto, labelITarefasProjeto, labelICusto;
    private DefaultListModel defIProjetos, defIPessoasProjetos, defITarefasProjetos;
    private JScrollPane scrollIProjetos, scrollIPessoasProjetos, scrollITarefasProjetos;
    private JList listaIProjetos, listaIPessoasProjetos, listaITarefasProjetos;
    
    //Tarefas Menu
    private JPanel panelMenuTarefas;
    private JButton buttonListarTarefas, buttonCriarTarefas, buttonEliminarTarefas, buttonAtualizarTarefas, buttonVoltarTarefas;
    
    //Listar Tarefas
    private JPanel panelListarTarefas;
    private JButton buttonVoltarListarTarefas;
    private JLabel labelTarefasEmCurso, labelTarefasNaoIniciadas, labelTarefasNaoConcluidasData, labelTarefasConcluidas;
    private DefaultListModel defTarefasEmCurso, defTarefasNaoIniciadas, defTarefasNaoConcluidasData, defTarefasConcluidas;
    private JList listaTarefasEmCurso, listaTarefasNaoIniciadas, listaTarefasNaoConcluidasData, listaTarefasConcluidas;
    private JScrollPane scrollTarefasEmCurso, scrollTarefasNaoIniciadas, scrollTarefasNaoConcluidasData, scrollTarefasConcluidas;
    
    //Criar Tarefa
    private JPanel panelCriarTarefa;
    private JButton buttonVoltarCriarTarefa, buttonProximoCriaTarefa;
    private JLabel labelTipoTarefa, labelIniData, labelFimData;
    private JTextField CriarTarefainiData, CriarTarefaFimData;
    private JComboBox boxCriarTarefa;
    
    //CRIAR TAREFA - SELECIONAR PESSOA
    private JPanel panelSelecionaPessoa;
    private JButton buttonVoltarTipoTarefa, buttonCriarTarefaFinal;
    private DefaultListModel defCriarTarefa;
    private JList listaCriarTarefa;
    private JScrollPane scrollCriarTarefa;
    
    //ATUALIZAR TAXA TAREFA
    private JPanel panelAtualizarTaxa;
    private JButton buttonAtualizarTaxa, buttonVoltarAtualizarTaxa;
    private JLabel labelValorTaxa;
    private JTextField valorTaxa;
    private DefaultListModel defAtualizarTaxa;
    private JList listaAtualizarTaxa;
    private JScrollPane scrollAtualizarTaxa;
    
    //ELIMINAR TAREFA
    private JPanel panelEliminaTarefa;
    private JButton buttonEliminaTarefa, buttonVoltarEliminaTarefa;
    private DefaultListModel defEliminaTarefa;
    private JList listaEliminaTarefa;
    private JScrollPane scrollEliminaTarefa;
    
    
    public Interface(Gestor gestor){
        
        super();
        this.gestor = gestor;
        layered = new JLayeredPane();
        
    /*-------------------------------Adicionar elementos listas-------------------------------*/
    
        listaDocentes = new DefaultListModel();
        for(Pessoa p : gestor.getPessoas()){
            if(p.getNumero() != -1){
                listaDocentes.addElement(p);
            }
        }
    /*------------------------------------------MENU------------------------------------------*/
        //menu buttons
        registerButton = new JButton("Registar Pessoa");
        newProjectButton = new JButton("Novo Projeto");
        listButton = new JButton("Projetos");
        unfinishedButton = new JButton("Projetos Inacabados");
        concludedButton = new JButton("Projetos Concluidos");
        titulo = new JLabel("Gestor de Projetos");
        
        //menu panel
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0,400,600);
        panelMenu.add(titulo);
        titulo.setBounds(140,80,200,20);
        panelMenu.add(registerButton);
        registerButton.setBounds(100,150,200,25);
        panelMenu.add(newProjectButton);
        newProjectButton.setBounds(100,200,200,25);
        panelMenu.add(listButton);
        listButton.setBounds(100,250,200,25);
        panelMenu.add(unfinishedButton);
        unfinishedButton.setBounds(100,300,200,25);
        panelMenu.add(concludedButton);
        concludedButton.setBounds(100,350,200,25);
        
        //menu listeners
        ButtonMenuListener buttonMenuL = new ButtonMenuListener();
        registerButton.addActionListener(buttonMenuL);
        newProjectButton.addActionListener(buttonMenuL);
        listButton.addActionListener(buttonMenuL);
        unfinishedButton.addActionListener(buttonMenuL);
        concludedButton.addActionListener(buttonMenuL);
        
    /*------------------------------------------REGISTO------------------------------------------*/
    
        //Registo buttons
        buttonLicenciado = new JButton("Licenciado");
        buttonMestre = new JButton("Mestre");
        buttonDoutorado = new JButton("Doutorado");
        buttonDocente = new JButton("Docente");
        buttonVoltar = new JButton("voltar");
        
        //Registo panel
        panelRegisto = new JPanel();
        panelRegisto.setLayout(null);
        panelRegisto.setBounds(0,0,400,600);
        panelRegisto.add(buttonLicenciado);
        buttonLicenciado.setBounds(100,100,200,25);
        panelRegisto.add(buttonMestre);
        buttonMestre.setBounds(100,150,200,25);
        panelRegisto.add(buttonDoutorado);
        buttonDoutorado.setBounds(100,200,200,25);
        panelRegisto.add(buttonDocente);
        buttonDocente.setBounds(100,250,200,25);
        panelRegisto.add(buttonVoltar);
        buttonVoltar.setBounds(160,500,80,25);
        
        //Registo listeners
        ButtonRegistoListener buttonRegistoL = new ButtonRegistoListener();
        buttonLicenciado.addActionListener(buttonRegistoL);
        buttonMestre.addActionListener(buttonRegistoL);
        buttonDoutorado.addActionListener(buttonRegistoL);
        buttonDocente.addActionListener(buttonRegistoL);
        buttonVoltar.addActionListener(buttonRegistoL);
        
    /*------------------------------------------LICENCIADO------------------------------------------*/
        
         //Licenciado buttons
        buttonGuardarL = new JButton("Guardar");
        buttonVoltarL = new JButton("Voltar");
        
        //Licenciado lista
        listaOrientadoresL = new JList(listaDocentes);
        scrollOrientadoresL = new JScrollPane(listaOrientadoresL);
        
        //Licenciado TextField
        nomeFieldL = new JTextField(40);
        emailFieldL = new JTextField(40);
        dataIFieldL = new JTextField(20);
        dataFFieldL = new JTextField(20);
        
        //Licenciado labels
        labelNomeL = new JLabel("Nome: ");
        labelMailL = new JLabel("Email: ");
        labelDataIL = new JLabel("Inicio Contrato: ");
        labelDataFL = new JLabel("Fim do Contrato: ");
        labelOrientadorL = new JLabel("Orientador: ");
        
        //Licenciado panel
        panelLicenciado = new JPanel();
        panelLicenciado.setBounds(10, 100, 360, 400);
        panelLicenciado.setLayout(new GridLayout(6,2));
        panelLicenciado.add(labelNomeL);
        panelLicenciado.add(nomeFieldL);
        panelLicenciado.add(labelMailL);
        panelLicenciado.add(emailFieldL);
        panelLicenciado.add(labelDataIL);
        panelLicenciado.add(dataIFieldL);
        panelLicenciado.add(labelDataFL);
        panelLicenciado.add(dataFFieldL);
        panelLicenciado.add(labelOrientadorL);
        panelLicenciado.add(scrollOrientadoresL);
        panelLicenciado.add(buttonGuardarL);
        panelLicenciado.add(buttonVoltarL); 
        
        
        //Licenciado listeners
        ButtonLicenciadoListener buttonLicenciadoL = new ButtonLicenciadoListener();
        buttonGuardarL.addActionListener(buttonLicenciadoL);
        buttonVoltarL.addActionListener(buttonLicenciadoL);

        /*------------------------------------------MESTRE------------------------------------------*/
            
        //Mestre buttons
        buttonGuardarM = new JButton("Guardar");
        buttonVoltarM = new JButton("Voltar");
        
        //Mestre lista
        listaOrientadoresM = new JList(listaDocentes);
        scrollOrientadoresM = new JScrollPane(listaOrientadoresM);
        
        //Mestre TextField
        nomeFieldM = new JTextField(40);
        emailFieldM = new JTextField(40);
        dataIFieldM = new JTextField(20);
        dataFFieldM = new JTextField(20);
        
        //Mestre labels
        labelNomeM = new JLabel("Nome: ");
        labelMailM = new JLabel("Email: ");
        labelDataIM = new JLabel("Inicio Contrato: ");
        labelDataFM = new JLabel("Fim do Contrato: ");
        labelOrientadorM = new JLabel("Orientador: ");
        
        //Mestre panel
        panelMestre = new JPanel();
        panelMestre.setBounds(10, 100, 360, 400);
        panelMestre.setLayout(new GridLayout(6,2));
        panelMestre.add(labelNomeM);
        panelMestre.add(nomeFieldM);
        panelMestre.add(labelMailM);
        panelMestre.add(emailFieldM);
        panelMestre.add(labelDataIM);
        panelMestre.add(dataIFieldM);
        panelMestre.add(labelDataFM);
        panelMestre.add(dataFFieldM);
        panelMestre.add(labelOrientadorM);
        panelMestre.add(scrollOrientadoresM);
        panelMestre.add(buttonGuardarM);
        panelMestre.add(buttonVoltarM); 
        
        
        //Mestre listeners
        ButtonMestreListener buttonMestreL = new ButtonMestreListener();
        buttonGuardarM.addActionListener(buttonMestreL);
        buttonVoltarM.addActionListener(buttonMestreL);

        /*------------------------------------------DOUTORADO------------------------------------------*/

        //Doutorado buttons
        buttonGuardarDtr = new JButton("Guardar");
        buttonVoltarDtr = new JButton("Voltar");
        
        //Doutorado TextField
        nomeFieldDtr = new JTextField(40);
        emailFieldDtr = new JTextField(40);
        dataIFieldDtr = new JTextField(20);
        dataFFieldDtr = new JTextField(20);
        
        //Doutorado labels
        labelNomeDtr = new JLabel("Nome: ");
        labelMailDtr = new JLabel("Email: ");
        labelDataIDtr = new JLabel("Inicio Contrato: ");
        labelDataFDtr = new JLabel("Fim do Contrato: ");
        
        //Mestre panel
        panelDoutorado = new JPanel();
        panelDoutorado.setBounds(10, 100, 360, 400);
        panelDoutorado.setLayout(new GridLayout(6,2));
        panelDoutorado.add(labelNomeDtr);
        panelDoutorado.add(nomeFieldDtr);
        panelDoutorado.add(labelMailDtr);
        panelDoutorado.add(emailFieldDtr);
        panelDoutorado.add(labelDataIDtr);
        panelDoutorado.add(dataIFieldDtr);
        panelDoutorado.add(labelDataFDtr);
        panelDoutorado.add(dataFFieldDtr);
        panelDoutorado.add(buttonGuardarDtr);
        panelDoutorado.add(buttonVoltarDtr);   
        
        //Doutorado listeners
        ButtonDoutoradoListener buttonDoutoradoL = new ButtonDoutoradoListener();
        buttonGuardarDtr.addActionListener(buttonDoutoradoL);
        buttonVoltarDtr.addActionListener(buttonDoutoradoL);
        
        /*------------------------------------------DOCENTE------------------------------------------*/

        //Docente buttons
        buttonGuardarD = new JButton("Guardar");
        buttonVoltarD = new JButton("Voltar");
        
        //Docente TextField
        nomeFieldD = new JTextField(40);
        emailFieldD = new JTextField(40);
        areaFieldD = new JTextField(20);
        numeroFieldD = new JTextField(20);
        
        //Docente labels
        labelNomeD = new JLabel("Nome: ");
        labelMailD = new JLabel("Email: ");
        labelAreaD = new JLabel("Area de Investigacao: ");
        labelNumeroD = new JLabel("Numero Mecanografico: ");
        
        //Docente panel
        panelDocente = new JPanel();
        panelDocente.setBounds(10, 100, 360, 400);
        panelDocente.setLayout(new GridLayout(6,2));
        panelDocente.add(labelNomeD);
        panelDocente.add(nomeFieldD);
        panelDocente.add(labelMailD);
        panelDocente.add(emailFieldD);
        panelDocente.add(labelAreaD);
        panelDocente.add(areaFieldD);
        panelDocente.add(labelNumeroD);
        panelDocente.add(numeroFieldD);
        panelDocente.add(buttonGuardarD);
        panelDocente.add(buttonVoltarD);   
        
        //Docente listeners
        ButtonDocenteListener buttonDocenteL = new ButtonDocenteListener();
        buttonGuardarD.addActionListener(buttonDocenteL);
        buttonVoltarD.addActionListener(buttonDocenteL);
        
        /*---------------------------------------NOVO PROJETO---------------------------------------*/
        
        //Novo Projeto buttons
        buttonGuardarNP = new JButton("Guardar");
        buttonVoltarNP = new JButton("Voltar");
        
        //Novo Projeto lista
        listaInvestigadoresP = new JList(listaDocentes);
        scrollInvestigadoresP = new JScrollPane(listaInvestigadoresP);
        
        //Novo Projeto TextField
        nomeFieldNP = new JTextField(40);
        acronimoFieldNP = new JTextField(40);
        dataIFieldNP = new JTextField(20);
        duracaoFieldNP = new JTextField(20);
        
        //Novo Projeto labels
        labelNomeNP = new JLabel("Nome: ");
        labelAcronimoNP = new JLabel("Acronimo: ");
        labelDataINP = new JLabel("Data de Inicio: ");
        labelDuracaoNP = new JLabel("Duracao (meses): ");
        labelInvestigadorNP = new JLabel("Investigador Principal: ");
        
        //Novo Projeto panel
        panelNovoProjeto = new JPanel();
        panelNovoProjeto.setBounds(10, 100, 360, 400);
        panelNovoProjeto.setLayout(new GridLayout(6,2));
        panelNovoProjeto.add(labelNomeNP);
        panelNovoProjeto.add(nomeFieldNP);
        panelNovoProjeto.add(labelAcronimoNP);
        panelNovoProjeto.add(acronimoFieldNP);
        panelNovoProjeto.add(labelDataINP);
        panelNovoProjeto.add(dataIFieldNP);
        panelNovoProjeto.add(labelDuracaoNP);
        panelNovoProjeto.add(duracaoFieldNP);
        panelNovoProjeto.add(labelInvestigadorNP);
        panelNovoProjeto.add(scrollInvestigadoresP);
        panelNovoProjeto.add(buttonGuardarNP);
        panelNovoProjeto.add(buttonVoltarNP); 
        
        
        //Novo Projeto listeners
        ButtonNovoProjetoListener buttonNovoProjetoL = new ButtonNovoProjetoListener();
        buttonGuardarNP.addActionListener(buttonNovoProjetoL);
        buttonVoltarNP.addActionListener(buttonNovoProjetoL);
        
        /*-------------------------------------PROJETOS----------------------------------------------*/
        //Projetos Buttons
        
        buttonSelecionaProjeto = new JButton("Selecionar");
        buttonVoltarProjeto = new JButton("Voltar");
        //Label projetos
        labelTituloProjetos = new JLabel("Projetos a decorrer");
        //Projetos Lista
        defProjeto = new DefaultListModel();
        for (Projeto p : gestor.getProjetos()){
            defProjeto.addElement(p);
        }
        listaProjeto = new JList(defProjeto);
        scrollProjeto = new JScrollPane(listaProjeto);
        //Panel Projetos
        panelProjetos = new JPanel();
        panelProjetos.setLayout(null);
        panelProjetos.setBounds(0,0,400,600);
        panelProjetos.add(labelTituloProjetos);
        labelTituloProjetos.setBounds(140,20,200,20);
        panelProjetos.add(scrollProjeto);
        scrollProjeto.setBounds(100,40,200,200);
        panelProjetos.add(buttonSelecionaProjeto);
        buttonSelecionaProjeto.setBounds(100,300,200,30);
        panelProjetos.add(buttonVoltarProjeto);
        buttonVoltarProjeto.setBounds(100,400,200,30);
        
        ButtonProjetoListener buttonProjeto = new ButtonProjetoListener();
        buttonSelecionaProjeto.addActionListener(buttonProjeto);
        buttonVoltarProjeto.addActionListener(buttonProjeto);
        
        /*---------------------------------------PROJETOS SELECIONADOS---------------------------------------*/
     
        //Projetos buttons
        buttonCustoSelecionado = new JButton("Custo");
        buttonVoltarSelecionado = new JButton("Voltar");
        buttonPessoasSelecionado = new JButton("Pessoas");
        buttonTarefasSelecionado = new JButton("Tarefas");
                            
        //Projetos labels   
        labelNomeSelecionado = new JLabel();
        labelAcronimoSelecionado = new JLabel();
        labelIniSelecionado = new JLabel();
        labelFimSelecionado = new JLabel();
        labelIpSelecionado = new JLabel();
        
        //Projetos panel
        panelProjetoSelecionado = new JPanel();
        panelProjetoSelecionado.setLayout(null);
        panelProjetoSelecionado.setBounds(0,0,400,600);
        labelNomeSelecionado.setBounds(70,100,400,20);
        panelProjetoSelecionado.add(labelNomeSelecionado);
        labelAcronimoSelecionado.setBounds(70,130,400,20);
        panelProjetoSelecionado.add(labelAcronimoSelecionado);
        labelIpSelecionado.setBounds(70,160,400,20);
        panelProjetoSelecionado.add(labelIpSelecionado);
        labelIniSelecionado.setBounds(70,190,400,20);
        panelProjetoSelecionado.add(labelIniSelecionado);
        labelFimSelecionado.setBounds(70,220,400,20);
        panelProjetoSelecionado.add(labelFimSelecionado);
  
        panelProjetoSelecionado.add(buttonCustoSelecionado);
        buttonCustoSelecionado.setBounds(100,350,200,25);
        panelProjetoSelecionado.add(buttonPessoasSelecionado);
        buttonPessoasSelecionado.setBounds(100,400,200,25);
        panelProjetoSelecionado.add(buttonTarefasSelecionado);
        buttonTarefasSelecionado.setBounds(100,450,200,25);
        panelProjetoSelecionado.add(buttonVoltarSelecionado);
        buttonVoltarSelecionado.setBounds(160,500,80,25);
        
        ButtonSelecionadoProjListener buttonSelecionadoProj = new ButtonSelecionadoProjListener();
        buttonCustoSelecionado.addActionListener(buttonSelecionadoProj);
        buttonPessoasSelecionado.addActionListener(buttonSelecionadoProj);
        buttonTarefasSelecionado.addActionListener(buttonSelecionadoProj);
        buttonVoltarSelecionado.addActionListener(buttonSelecionadoProj);
        
        /*-----------------------------------PESSOAS PROJETOS---------------------------------------*/
        //Pessoas Buttons
        buttonAssocia = new JButton("Associar Pessoa");
        buttonVoltarMenuProjeto = new JButton("Voltar");
        
        //Pessoas Labels
        labelDocenteAssociado = new JLabel("Docentes Associados");
        labelBolseiroAssociado = new JLabel("Bolseiros Associados");
        
        //Docentes Associados Lista
        defDocentesAssociados = new DefaultListModel();
        listaDocentesAssociados = new JList(defDocentesAssociados);
        scrollDocentesAssociados = new JScrollPane(listaDocentesAssociados);
        
        //Bolseiros Associados Lista
        defBolseirosAssociados = new DefaultListModel();
        listaBolseirosAssociados = new JList(defBolseirosAssociados);
        scrollBolseirosAssociados = new JScrollPane(listaBolseirosAssociados);
        
        //Panel Pessoas
        panelPessoasProjeto = new JPanel();
        panelPessoasProjeto.setLayout(null);
        panelPessoasProjeto.setBounds(0,0,400,600);
        panelPessoasProjeto.add(labelDocenteAssociado);
        labelDocenteAssociado.setBounds(140,20,200,20);
        panelPessoasProjeto.add(scrollDocentesAssociados);
        scrollDocentesAssociados.setBounds(90,50,220,120);
        panelPessoasProjeto.add(labelBolseiroAssociado);
        labelBolseiroAssociado.setBounds(140,190,200,20);
        panelPessoasProjeto.add(scrollBolseirosAssociados);
        scrollBolseirosAssociados.setBounds(90,220,220,120);
        panelPessoasProjeto.add(buttonAssocia);
        buttonAssocia.setBounds(30,400,150,40);
        panelPessoasProjeto.add(buttonVoltarMenuProjeto);
        buttonVoltarMenuProjeto.setBounds(210,400,150,40);
        
        ButtonPessoasProjetoListener buttonPessoasProjeto = new ButtonPessoasProjetoListener();
        buttonVoltarMenuProjeto.addActionListener(buttonPessoasProjeto);
        buttonAssocia.addActionListener(buttonPessoasProjeto);
        
        
        /*-----------------------------------ASSOCIAR PESSOAS-----------------------------------*/
        
        //Buttons Associa Pessoa
        buttonAssociaPessoa = new JButton("Associar");
        buttonAssociaVoltar = new JButton("Voltar");
        
        //Projetos Concluidos lista
        pessoasProjeto = new DefaultListModel();
        listaAssociaPessoas = new JList(pessoasProjeto);
        scrollAssociaPessoas = new JScrollPane(listaAssociaPessoas);
        
        //Label Associa Pessoas
        labelAssociaPessoas = new JLabel("Pessoas");
        
        //Panel Projetos concluidos
        panelAssociaPessoas = new JPanel();
        panelAssociaPessoas.setLayout(null);
        panelAssociaPessoas.setBounds(0,0,400,600);
        panelAssociaPessoas.add(labelAssociaPessoas);
        labelAssociaPessoas.setBounds(180, 40, 200, 25);
        panelAssociaPessoas.add(scrollAssociaPessoas);
        scrollAssociaPessoas.setBounds(50,100,300,150);
        panelAssociaPessoas.add(buttonAssociaPessoa);
        buttonAssociaPessoa.setBounds(100,300,200,25);
        panelAssociaPessoas.add(buttonAssociaVoltar);
        buttonAssociaVoltar.setBounds(100,500,200,25);
        
        ButtonAssociaPessoasListener buttonAssociaPessoasL = new ButtonAssociaPessoasListener();
        buttonAssociaPessoa.addActionListener(buttonAssociaPessoasL);
        buttonAssociaVoltar.addActionListener(buttonAssociaPessoasL);
        
        /*-----------------------------------MENU TAREFAS--------------------------------------------*/
        //Menu Tarefas Buttons
        buttonListarTarefas = new JButton("Listar");
        buttonCriarTarefas = new JButton("Criar");
        buttonEliminarTarefas = new JButton("Eliminar");
        buttonAtualizarTarefas = new JButton("Atualizar Taxa");
        buttonVoltarTarefas = new JButton("Voltar");
        
        panelMenuTarefas = new JPanel();
        panelMenuTarefas.setLayout(null);
        panelMenuTarefas.setBounds(0,0,400,600);
        panelMenuTarefas.add(buttonListarTarefas);
        buttonListarTarefas.setBounds(100,150,200,35);
        panelMenuTarefas.add(buttonCriarTarefas);
        buttonCriarTarefas.setBounds(100,200,200,35);
        panelMenuTarefas.add(buttonEliminarTarefas);
        buttonEliminarTarefas.setBounds(100,250,200,35);
        panelMenuTarefas.add(buttonAtualizarTarefas);
        buttonAtualizarTarefas.setBounds(100,300,200,35);
        panelMenuTarefas.add(buttonVoltarTarefas);
        buttonVoltarTarefas.setBounds(160,400,80,35);
        
        ButtonMenuTarefasListener buttonMenuTarefas = new ButtonMenuTarefasListener();
        buttonListarTarefas.addActionListener(buttonMenuTarefas);
        buttonCriarTarefas.addActionListener(buttonMenuTarefas);
        buttonEliminarTarefas.addActionListener(buttonMenuTarefas);
        buttonAtualizarTarefas.addActionListener(buttonMenuTarefas);
        buttonVoltarTarefas.addActionListener(buttonMenuTarefas);

        /*----------------------------------------LISTAR TAREFAS---------------------------------*/
        
        //Button Listar Tarefas
        buttonVoltarListarTarefas = new JButton("Voltar");
        
        //Listar Tarefas Labels
        labelTarefasEmCurso = new JLabel("Tarefas em curso");
        labelTarefasNaoIniciadas = new JLabel("Tarefas nao iniciadas");
        labelTarefasNaoConcluidasData = new JLabel("Tarefas nao concluidas na data");
        labelTarefasConcluidas = new JLabel("Tarefas Concluidas");
        
        //Tarefas Scroll
        //Tarefas Em Curso scroll
        defTarefasEmCurso = new DefaultListModel();
        listaTarefasEmCurso = new JList(defTarefasEmCurso);
        scrollTarefasEmCurso = new JScrollPane(listaTarefasEmCurso);

        //Tarefas Nao Iniciadas scroll
        defTarefasNaoIniciadas = new DefaultListModel();
        listaTarefasNaoIniciadas = new JList(defTarefasNaoIniciadas);
        scrollTarefasNaoIniciadas = new JScrollPane(listaTarefasNaoIniciadas);

        //Tarefas Nao concluidas na data
        defTarefasNaoConcluidasData = new DefaultListModel();
        listaTarefasNaoConcluidasData = new JList(defTarefasNaoConcluidasData);
        scrollTarefasNaoConcluidasData = new JScrollPane(listaTarefasNaoConcluidasData);
            
        //Tarefas Concluidas
        defTarefasConcluidas = new DefaultListModel();
        listaTarefasConcluidas = new JList(defTarefasConcluidas);
        scrollTarefasConcluidas = new JScrollPane(listaTarefasConcluidas);
            
         //Panel Listar Tarefas
         panelListarTarefas = new JPanel();
         panelListarTarefas.setLayout(null);
         panelListarTarefas.setBounds(0,0,400,600);
         panelListarTarefas.add(labelTarefasEmCurso);
         labelTarefasEmCurso.setBounds(40,20,200,20);
         panelListarTarefas.add(scrollTarefasEmCurso);
         scrollTarefasEmCurso.setBounds(20,50,160,180);
         panelListarTarefas.add(labelTarefasNaoIniciadas);
         labelTarefasNaoIniciadas.setBounds(225,20,160,20);
         panelListarTarefas.add(scrollTarefasNaoIniciadas);
         scrollTarefasNaoIniciadas.setBounds(210,50,160,180);
         panelListarTarefas.add(labelTarefasNaoConcluidasData);
         labelTarefasNaoConcluidasData.setBounds(15,250,200,20);
         panelListarTarefas.add(scrollTarefasNaoConcluidasData);
         scrollTarefasNaoConcluidasData.setBounds(20,280,160,180);
         panelListarTarefas.add(labelTarefasConcluidas);
         labelTarefasConcluidas.setBounds(230,250,180,20);
         panelListarTarefas.add(scrollTarefasConcluidas);
         scrollTarefasConcluidas.setBounds(210,280,160,180);
         panelListarTarefas.add(buttonVoltarListarTarefas);
         buttonVoltarListarTarefas.setBounds(140,500,100,25);
         
        ButtonListarTarefasListener buttonListaTarefas = new ButtonListarTarefasListener();
        buttonVoltarListarTarefas.addActionListener(buttonListaTarefas);
        
        /*---------------------------------------CRIAR TAREFAS----------------------------------*/
        
        //Button Criar Tarefas
        
        buttonVoltarCriarTarefa = new JButton("Voltar");
        buttonProximoCriaTarefa = new JButton("Escolher Responsavel");
        
        //Label Tarefas
        labelTipoTarefa = new JLabel("Tipo de Tarefa");
        labelIniData = new JLabel("Data de Inicio:");
        labelFimData = new JLabel("Duração (Dias):");
        
        //Text Fields
        CriarTarefainiData = new JTextField(20);
        CriarTarefaFimData = new JTextField(20);
        
        //JCombo Box
        String[] types = {"Desenvolvimento","Design","Documentação"};
        boxCriarTarefa = new JComboBox(types);
        
        panelCriarTarefa = new JPanel();
        panelCriarTarefa.setLayout(null);
        panelCriarTarefa.setBounds(0,0,400,600);
        panelCriarTarefa.add(labelTipoTarefa);
        labelTipoTarefa.setBounds(150,50,200,20);
        panelCriarTarefa.add(boxCriarTarefa);
        boxCriarTarefa.setBounds(100,80,200,25);
        panelCriarTarefa.add(labelIniData);
        labelIniData.setBounds(20,225,100,20);
        panelCriarTarefa.add(CriarTarefainiData);
        CriarTarefainiData.setBounds(120,225,150,20);
        panelCriarTarefa.add(labelFimData);
        labelFimData.setBounds(20,255,200,20);
        panelCriarTarefa.add(CriarTarefaFimData);
        CriarTarefaFimData.setBounds(120,255,150,20);
        panelCriarTarefa.add(buttonVoltarCriarTarefa);
        buttonVoltarCriarTarefa.setBounds(150,450,100,30);
        panelCriarTarefa.add(buttonProximoCriaTarefa);
        buttonProximoCriaTarefa.setBounds(100,300,200,30);
        
        
        ButtonCriarTarefasListener buttonCriarT = new ButtonCriarTarefasListener();
        buttonVoltarCriarTarefa.addActionListener(buttonCriarT);
        buttonProximoCriaTarefa.addActionListener(buttonCriarT);
        //BOX
        ComboBoxActionListener BoxCriarTarefaActionListener = new ComboBoxActionListener();
        boxCriarTarefa.addActionListener(BoxCriarTarefaActionListener);
        
        /*----------------------------------ESCOLHER PESSOA---------------------------------------*/
        //Button escolher pessoas
        buttonVoltarTipoTarefa = new JButton("Voltar");
        buttonCriarTarefaFinal = new JButton("Criar Tarefa");
        
        //Criar em Tarefas scroll
        defCriarTarefa = new DefaultListModel();
        listaCriarTarefa = new JList(defCriarTarefa);
        scrollCriarTarefa = new JScrollPane(listaCriarTarefa);
        
        panelSelecionaPessoa = new JPanel();
        panelSelecionaPessoa.setLayout(null);
        panelSelecionaPessoa.setBounds(0,0,400,600);
        panelSelecionaPessoa.add(scrollCriarTarefa);
        scrollCriarTarefa.setBounds(45,50,300,180);
        panelSelecionaPessoa.add(buttonCriarTarefaFinal);
        buttonCriarTarefaFinal.setBounds(130,300,150,25);
        panelSelecionaPessoa.add(buttonVoltarTipoTarefa);
        buttonVoltarTipoTarefa.setBounds(150,500,100,25);
        
        ButtonSelecionarPessoaCriarTarefasListener buttonSelecionarPessoaCriarTarefa = new ButtonSelecionarPessoaCriarTarefasListener();
        buttonCriarTarefaFinal.addActionListener(buttonSelecionarPessoaCriarTarefa);
        buttonVoltarTipoTarefa.addActionListener(buttonSelecionarPessoaCriarTarefa);
          

        /*----------------------------------------Atualizar Taxa Tarefa----------------------------*/
        //Buttons Atualizar Taxa
        buttonAtualizarTaxa = new JButton("Atualizar");
        buttonVoltarAtualizarTaxa = new JButton("Voltar");
        
        //Label atualizar taxa
        labelValorTaxa = new JLabel("Taxa (%):");
        //TextField atualizar taxa
        valorTaxa = new JTextField(3);
        //Atualizar tarefas scroll
        defAtualizarTaxa = new DefaultListModel();
        listaAtualizarTaxa = new JList(defAtualizarTaxa);
        scrollAtualizarTaxa = new JScrollPane(listaAtualizarTaxa);
        
        //Panel atualizar taxa
        panelAtualizarTaxa = new JPanel();
        panelAtualizarTaxa.setLayout(null);
        panelAtualizarTaxa.setBounds(0,0,400,600);
        panelAtualizarTaxa.add(scrollAtualizarTaxa);
        scrollAtualizarTaxa.setBounds(65,50,250,125);
        panelAtualizarTaxa.add(labelValorTaxa);
        labelValorTaxa.setBounds(110,250,60,20);
        panelAtualizarTaxa.add(valorTaxa);
        valorTaxa.setBounds(160,245,100,30);
        panelAtualizarTaxa.add(buttonAtualizarTaxa);
        buttonAtualizarTaxa.setBounds(125,350,150,30);
        panelAtualizarTaxa.add(buttonVoltarAtualizarTaxa);
        buttonVoltarAtualizarTaxa.setBounds(150,500,100,30);
        
        ButtonAtualizarTaxaListener buttonAtTaxa = new ButtonAtualizarTaxaListener();
        buttonVoltarAtualizarTaxa.addActionListener(buttonAtTaxa);
        buttonAtualizarTaxa.addActionListener(buttonAtTaxa);
        
        /*-----------------------------------ELIMINAR TAREFA----------------------------------------*/
        //Buttons Eliminar Tarefa
        buttonEliminaTarefa = new JButton("Eliminar Tarefa");
        buttonVoltarEliminaTarefa = new JButton("Voltar");
        
        //Tarefas Lista
        defEliminaTarefa = new DefaultListModel();
        listaEliminaTarefa = new JList(defEliminaTarefa);
        scrollEliminaTarefa = new JScrollPane(listaEliminaTarefa);
        
        //PANEL ELIMNAR TAREFA
        panelEliminaTarefa = new JPanel();
        panelEliminaTarefa.setLayout(null);
        panelEliminaTarefa.setBounds(0,0,400,600);
        panelEliminaTarefa.add(scrollEliminaTarefa);
        scrollEliminaTarefa.setBounds(45,50,300,180);
        panelEliminaTarefa.add(buttonEliminaTarefa);
        buttonEliminaTarefa.setBounds(125,300,150,25);
        panelEliminaTarefa.add(buttonVoltarEliminaTarefa);
        buttonVoltarEliminaTarefa.setBounds(150,500,100,25);
        
        ButtonEliminaTarefaListener buttonEliminaT = new ButtonEliminaTarefaListener();
        buttonEliminaTarefa.addActionListener(buttonEliminaT);
        buttonVoltarEliminaTarefa.addActionListener(buttonEliminaT);
        

       /*------------------------------------PROJETOS CONCLUIDOS------------------------------------*/
        
        //Projetos Concluidos buttons
        buttonDetalhesConc = new JButton("Detalhes");
        buttonVoltarConc = new JButton("Voltar");
        
        //Projetos Concluidos lista
        concProjetos = new DefaultListModel();
        listaconcProjetos = new JList(concProjetos);
        scrollconcProjetos = new JScrollPane(listaconcProjetos);
        
        //Panel Projetos concluidos
        panelConcprojetos = new JPanel();
        panelConcprojetos.setLayout(null);
        panelConcprojetos.setBounds(0,0,400,600);
        panelConcprojetos.add(scrollconcProjetos);
        scrollconcProjetos.setBounds(100,100,200,150);
        panelConcprojetos.add(buttonDetalhesConc);
        buttonDetalhesConc.setBounds(100,300,200,25);
        panelConcprojetos.add(buttonVoltarConc);
        buttonVoltarConc.setBounds(100,500,200,25);
        
        ButtonConcProjListener buttonConcProj = new ButtonConcProjListener();
        buttonDetalhesConc.addActionListener(buttonConcProj);
        buttonVoltarConc.addActionListener(buttonConcProj);
        
        /*-------------------------------DETALHES PROJETOS CONCLUIDOS-------------------------------*/
        
        //Detalhes Buttons
        buttonVoltarDetalhes = new JButton("Voltar");

        //Detalhes Labels
        labelnomeProjeto = new JLabel ();
        labelacrProjeto = new JLabel();
        labelipProjeto = new JLabel();
        labeliniProjeto = new JLabel();
        labelCusto = new JLabel("custo");
        labelfimProjeto = new JLabel("FAZER FIM DATA");
        labelpessoaslistaProjeto = new JLabel("Pessoas Envolvidas:");
        labeltarefasProjeto = new JLabel("Tarefas do Projeto: ");
           
        //Detalhes Scroll 
            //Pessoas scroll
        defpessoasProjeto = new DefaultListModel();
        listapessoasProjeto = new JList(defpessoasProjeto);
        scrollpessoasProjeto = new JScrollPane(listapessoasProjeto);
            //Tarefas scroll
        deftarefasProjeto = new DefaultListModel();
        listatarefasProjeto = new JList(deftarefasProjeto);
        scrolltarefasProjeto = new JScrollPane(listatarefasProjeto);
        //Panel Detalhes Projetos Concluidos
        
        panelDetalhesConc = new JPanel();
        panelDetalhesConc.setLayout(null);
        panelDetalhesConc.setBounds(0,0,400,600);
        panelDetalhesConc.add(labelnomeProjeto);
        labelnomeProjeto.setBounds(5,20,400,20);
        panelDetalhesConc.add(labelipProjeto);
        labelipProjeto.setBounds(5,40,400,20);
        panelDetalhesConc.add(labeliniProjeto);
        labeliniProjeto.setBounds(5,60,400,20);
        panelDetalhesConc.add(labelfimProjeto);
        labelfimProjeto.setBounds(5,80,400,20);
        panelDetalhesConc.add(labelpessoaslistaProjeto);
        labelpessoaslistaProjeto.setBounds(5,120,400,20);
        panelDetalhesConc.add(scrollpessoasProjeto);
        scrollpessoasProjeto.setBounds(0,145,380,100);
        panelDetalhesConc.add(labeltarefasProjeto);
        labeltarefasProjeto.setBounds(5,270,400,20);
        panelDetalhesConc.add(scrolltarefasProjeto);
        scrolltarefasProjeto.setBounds(0,300,380,100);
        panelDetalhesConc.add(labelCusto);
        labelCusto.setBounds(160,450,100,20);
        panelDetalhesConc.add(buttonVoltarDetalhes);
        buttonVoltarDetalhes.setBounds(100,500,200,25);
        
        ButtonDetalhesConcListener buttonDetConc = new ButtonDetalhesConcListener();
        buttonVoltarDetalhes.addActionListener(buttonDetConc);
        
        
        /*------------------------------------PROJETOS INACABADOS------------------------------------*/
        
        //Projetos INACABADOS buttons
        buttonIDetalhes = new JButton("Detalhes");
        buttonIVoltar = new JButton("Voltar");
        
        //Projetos Inacabados lista
        defIProjetos = new DefaultListModel();
        listaIProjetos = new JList(defIProjetos);
        scrollIProjetos = new JScrollPane(listaIProjetos);
        
        //Panel Projetos concluidos
        panelInacabado = new JPanel();
        panelInacabado.setLayout(null);
        panelInacabado.setBounds(0,0,400,600);
        panelInacabado.add(scrollIProjetos);
        scrollIProjetos.setBounds(100,100,200,150);
        panelInacabado.add(buttonIDetalhes);
        buttonIDetalhes.setBounds(100,300,200,25);
        panelInacabado.add(buttonIVoltar);
        buttonIVoltar.setBounds(100,500,200,25);
        
        ButtonIProjetosListener buttonIProj = new ButtonIProjetosListener();
        buttonIDetalhes.addActionListener(buttonIProj);
        buttonIVoltar.addActionListener(buttonIProj);
                
        /*-------------------------------DETALHES PROJETOS INACABADOS-------------------------------*/
        
        //Detalhes Buttons
        buttonIVoltarDetalhes = new JButton("Voltar");

        //Detalhes Labels
        labelINomeProjeto = new JLabel ();
        labelIAcrProjeto = new JLabel();
        labelIIpProjeto = new JLabel();
        labelInacabadoIniProjeto = new JLabel();
        labelICusto = new JLabel("custo");
        labelIFimProjeto = new JLabel("FAZER FIM DATA");
        labelIPessoasListaProjeto = new JLabel("Pessoas Envolvidas:");
        labelITarefasProjeto = new JLabel("Tarefas do Projeto: ");
           
        //Detalhes Scroll 
            //Pessoas scroll
        defIPessoasProjetos = new DefaultListModel();
        listaIPessoasProjetos = new JList(defIPessoasProjetos);
        scrollIPessoasProjetos = new JScrollPane(listaIPessoasProjetos);
            //Tarefas scroll
        defITarefasProjetos = new DefaultListModel();
        listaITarefasProjetos = new JList(defITarefasProjetos);
        scrollITarefasProjetos = new JScrollPane(listaITarefasProjetos);
        //Panel Detalhes Projetos Concluidos
        
        panelDetalhesInacabado = new JPanel();
        panelDetalhesInacabado.setLayout(null);
        panelDetalhesInacabado.setBounds(0,0,400,600);
        panelDetalhesInacabado.add(labelINomeProjeto);
        labelINomeProjeto.setBounds(5,20,400,20);
        panelDetalhesInacabado.add(labelIIpProjeto);
        labelIIpProjeto.setBounds(5,40,400,20);
        panelDetalhesInacabado.add(labelInacabadoIniProjeto);
        labelInacabadoIniProjeto.setBounds(5,60,400,20);
        panelDetalhesInacabado.add(labelIFimProjeto);
        labelIFimProjeto.setBounds(5,80,400,20);
        panelDetalhesInacabado.add(labelIPessoasListaProjeto);
        labelIPessoasListaProjeto.setBounds(5,120,400,20);
        panelDetalhesInacabado.add(scrollIPessoasProjetos);
        scrollIPessoasProjetos.setBounds(0,145,380,100);
        panelDetalhesInacabado.add(labelITarefasProjeto);
        labelITarefasProjeto.setBounds(5,270,400,20);
        panelDetalhesInacabado.add(scrollITarefasProjetos);
        scrollITarefasProjetos.setBounds(0,300,380,100);
        panelDetalhesInacabado.add(labelICusto);
        labelICusto.setBounds(160,450,100,20);
        panelDetalhesInacabado.add(buttonIVoltarDetalhes);
        buttonIVoltarDetalhes.setBounds(100,500,200,25);
        
        ButtonDetalhesInacabadoListener buttonDetalhesI = new ButtonDetalhesInacabadoListener();
        buttonIVoltarDetalhes.addActionListener(buttonDetalhesI);
        
        
        
        /*-----------------------------------------FRAME-----------------------------------------*/
        
        //add panels to layered
        layered.add(panelMenu);
        layered.add(panelRegisto);
        layered.add(panelLicenciado);
        layered.add(panelMestre);
        layered.add(panelDoutorado);
        layered.add(panelDocente);
        layered.add(panelNovoProjeto);
        layered.add(panelProjetos);
        layered.add(panelProjetoSelecionado);
        layered.add(panelPessoasProjeto);
        layered.add(panelAssociaPessoas);
        layered.add(panelListarTarefas);
        layered.add(panelMenuTarefas);
        layered.add(panelCriarTarefa);
        layered.add(panelSelecionaPessoa);
        layered.add(panelConcprojetos);
        layered.add(panelDetalhesConc);
        layered.add(panelAtualizarTaxa);
        layered.add(panelEliminaTarefa);
        layered.add(panelInacabado);
        layered.add(panelDetalhesInacabado);
        
        
        panelMenu.setVisible(true);
        panelRegisto.setVisible(false);
        panelLicenciado.setVisible(false);
        panelMestre.setVisible(false);
        panelDoutorado.setVisible(false);
        panelDocente.setVisible(false);
        panelProjetos.setVisible(false);
        panelNovoProjeto.setVisible(false);
        panelProjetoSelecionado.setVisible(false);
        panelPessoasProjeto.setVisible(false);
        panelAssociaPessoas.setVisible(false);
        panelMenuTarefas.setVisible(false);
        panelListarTarefas.setVisible(false);
        panelCriarTarefa.setVisible(false);
        panelSelecionaPessoa.setVisible(false);
        panelConcprojetos.setVisible(false);
        panelDetalhesConc.setVisible(false);
        panelAtualizarTaxa.setVisible(false);
        panelEliminaTarefa.setVisible(false);
        panelInacabado.setVisible(false);
        panelDetalhesInacabado.setVisible(false);
             
        //add panel to JFrame
        this.add(layered);       
    }
    
    private class ButtonMenuListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == registerButton){
                panelMenu.setVisible(false);
                panelRegisto.setVisible(true);
            }
            else if(e.getSource() == newProjectButton){
                panelMenu.setVisible(false);
                panelNovoProjeto.setVisible(true);
            }
            else if(e.getSource() == listButton){
                panelMenu.setVisible(false);
                panelProjetos.setVisible(true);
            }
            else if(e.getSource() == unfinishedButton){
                defIProjetos.removeAllElements();
                for (Projeto p : gestor.getProjetos()){
                    if(dataAtual.compareTo(p.getFinalData())>0){
                        defIProjetos.addElement(p);
                    }
                }
                panelMenu.setVisible(false);
                panelInacabado.setVisible(true);
            } 
            else if(e.getSource() == concludedButton){
                concProjetos.removeAllElements();
                if(gestor.getProjetosConcluidos().isEmpty()){
                    JOptionPane.showMessageDialog(null , "Não se encontram projetos concluídos até à data", "Projetos Concluidos", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    for (Projeto p: gestor.getProjetosConcluidos()){
                            concProjetos.addElement(p);
                    } 
                    panelMenu.setVisible(false);
                    panelConcprojetos.setVisible(true);
                }
            }
        }
    }

    private class ButtonRegistoListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonLicenciado){
                panelRegisto.setVisible(false);
                panelLicenciado.setVisible(true);
            }
            else if(e.getSource() == buttonMestre){
                panelRegisto.setVisible(false);
                panelMestre.setVisible(true);
            }
            else if(e.getSource() == buttonDoutorado){
                panelRegisto.setVisible(false);
                panelDoutorado.setVisible(true);
            }
            else if(e.getSource() == buttonDocente){
                panelRegisto.setVisible(false);
                panelDocente.setVisible(true);
            }
            else if(e.getSource() == buttonVoltar){
                panelRegisto.setVisible(false);
                panelMenu.setVisible(true);
            }
        }
    
    } 

    private class ButtonLicenciadoListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            String nome;
            String email;
            GregorianCalendar dataI = new GregorianCalendar();
            GregorianCalendar dataF = new GregorianCalendar();
            int dia, mes,ano;
            Docente orientador;
            String auxiliar[];
            
            
            if(e.getSource() == buttonGuardarL){
                try{
                    nome = nomeFieldL.getText();
                    email = emailFieldL.getText();
                    auxiliar = dataIFieldL.getText().split("[- /]+");
                    if(nome.equals("") || email.equals("") ||auxiliar.equals("")){
                        JOptionPane.showMessageDialog(null , "Dados Invalidos", "Licenciado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1])-1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataI.set(Calendar.DAY_OF_MONTH,dia);
                    dataI.set(Calendar.MONTH,mes);
                    dataI.set(Calendar.YEAR,ano);     
                    auxiliar = dataFFieldL.getText().split("[- /]+");
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1]) - 1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataF.set(Calendar.DAY_OF_MONTH,dia);
                    dataF.set(Calendar.MONTH,mes);
                    dataF.set(Calendar.YEAR,ano);
                    if(dataI.compareTo(dataF) < 0){
                        orientador = (Docente) (listaOrientadoresL.getSelectedValue());
                        ArrayList<Docente> orientadoresList = new ArrayList<>();
                        orientadoresList.add(orientador);
                        Licenciado licenciado = new Licenciado(nome, email, dataI, dataF, orientadoresList);
                        gestor.registaLicenciado(licenciado);
                        nomeFieldL.setText("");
                        emailFieldL.setText("");
                        dataIFieldL.setText("");
                        dataFFieldL.setText("");
                        JOptionPane.showMessageDialog(null , "Registado", "Licenciado", JOptionPane.INFORMATION_MESSAGE);
                        gestor.guardaFicheiro(gestor);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);    
                }
                catch(IndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(null , "Verifique se selecionou orientadar ou se as datas estão corretas!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(e.getSource() == buttonVoltarL){
                panelLicenciado.setVisible(false);
                panelRegisto.setVisible(true);
            }
        }
    }
    
    private class ButtonMestreListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            String nome;
            String email;
            GregorianCalendar dataI = new GregorianCalendar();
            GregorianCalendar dataF = new GregorianCalendar();
            int dia, mes,ano;
            Docente orientador;
            String auxiliar[];
            
            if(e.getSource() == buttonGuardarM){
                try{
                    nome = nomeFieldM.getText();
                    email = emailFieldM.getText();
                    auxiliar = dataIFieldM.getText().split("[- /]+");
                    if(nome.equals("") || email.equals("") ||auxiliar.equals("")){
                        JOptionPane.showMessageDialog(null , "Dados Invalidos", "Licenciado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1])-1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataI.set(Calendar.DAY_OF_MONTH,dia);
                    dataI.set(Calendar.MONTH,mes);
                    dataI.set(Calendar.YEAR,ano);     
                    
                    auxiliar = dataFFieldM.getText().split("[- /]+");
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1]) - 1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataF.set(Calendar.DAY_OF_MONTH,dia);
                    dataF.set(Calendar.MONTH,mes);
                    dataF.set(Calendar.YEAR,ano);
                    if(dataI.compareTo(dataF) < 0){
                        orientador = (Docente)(listaOrientadoresM.getSelectedValue());

                        ArrayList<Docente> orientadoresList = new ArrayList<>();
                        orientadoresList.add(orientador);

                        Mestre mestre = new Mestre(nome, email, dataI, dataF, orientadoresList);
                        gestor.registaMestre(mestre);

                        nomeFieldM.setText("");
                        emailFieldM.setText("");
                        dataIFieldM.setText("");
                        dataFFieldM.setText("");
                        JOptionPane.showMessageDialog(null , "Registado", "Mestre", JOptionPane.INFORMATION_MESSAGE);
                        gestor.guardaFicheiro(gestor);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);    
                }
                catch(IndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(null , "Verifique se selecionou orientadar ou se as datas estão corretas!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(e.getSource() == buttonVoltarM){
                panelMestre.setVisible(false);
                panelRegisto.setVisible(true);
            }
        }
    }
    
    private class ButtonDoutoradoListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            String nome;
            String email;
            GregorianCalendar dataI = new GregorianCalendar();
            GregorianCalendar dataF = new GregorianCalendar();
            int dia, mes,ano;
            String auxiliar[];
            
            if(e.getSource() == buttonGuardarDtr){
                try{
                    nome = nomeFieldDtr.getText();
                    email = emailFieldDtr.getText();
                    auxiliar = dataIFieldDtr.getText().split("[- /]+");
                    if(nome.equals("") || email.equals("") ||auxiliar.equals("")){
                        JOptionPane.showMessageDialog(null , "Dados Invalidos", "Doutorado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1])-1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataI.set(Calendar.DAY_OF_MONTH,dia);
                    dataI.set(Calendar.MONTH,mes);
                    dataI.set(Calendar.YEAR,ano);     
                    auxiliar = dataFFieldDtr.getText().split("[- /]+");
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1]) - 1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataF.set(Calendar.DAY_OF_MONTH,dia);
                    dataF.set(Calendar.MONTH,mes);
                    dataF.set(Calendar.YEAR,ano);
                    if(dataI.compareTo(dataF) < 0){
                        Doutorado doutor = new Doutorado(nome,email,dataI,dataF);
                        gestor.registaDoutorado(doutor);
                        nomeFieldDtr.setText("");
                        emailFieldDtr.setText("");
                        dataIFieldDtr.setText("");
                        dataFFieldDtr.setText("");
                        JOptionPane.showMessageDialog(null , "Registado", "Doutorado", JOptionPane.INFORMATION_MESSAGE);
                        gestor.guardaFicheiro(gestor);
                    }
                    else{
                        JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);    
                }
                
            }
            else if(e.getSource() == buttonVoltarDtr){
                panelDoutorado.setVisible(false);
                panelRegisto.setVisible(true);
            }
        }
    }
    
    private class ButtonDocenteListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            String nome;
            String email;
            String areaInv;
            int numero;
            
            if(e.getSource() == buttonGuardarD){
                try{
                    nome = nomeFieldD.getText();
                    email = emailFieldD.getText();
                    areaInv = areaFieldD.getText();
                    if(nome.equals("") || email.equals("") || areaInv.equals("")){
                        JOptionPane.showMessageDialog(null , "Dados Invalidos", "Doutorado", JOptionPane.ERROR_MESSAGE);
                    }
                    numero = Integer.parseInt(numeroFieldD.getText());
                    
                    Docente docente  = new Docente(nome,email, areaInv, numero);
                    gestor.registaDocente(docente);
                    nomeFieldD.setText("");
                    emailFieldD.setText("");
                    areaFieldD.setText("");
                    numeroFieldD.setText("");
                    
                    listaDocentes.addElement(docente);
                    
                    JOptionPane.showMessageDialog(null , "Registado", "Docente", JOptionPane.INFORMATION_MESSAGE);
                    gestor.guardaFicheiro(gestor);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Numero invalido", "Erro", JOptionPane.ERROR_MESSAGE);    
                }
                
            }
            else if(e.getSource() == buttonVoltarD){
                panelDocente.setVisible(false);
                panelRegisto.setVisible(true);
            }
        }
    }
    
    private class ButtonNovoProjetoListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            String nome;
            String acronimo;
            GregorianCalendar dataI = new GregorianCalendar();
            int dia, mes, ano;
            int duracao;
            Docente iP;
            String auxiliar[];
            
            
            if(e.getSource() == buttonGuardarNP){
                try{
                    nome = nomeFieldNP.getText();
                    acronimo = acronimoFieldNP.getText();
                    auxiliar = dataIFieldNP.getText().split("[- /]+");
                    if(nome.equals("") || acronimo.equals("") ||auxiliar.equals("")){
                        JOptionPane.showMessageDialog(null , "Dados Invalidos", "Novo Projeto", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    dia = Integer.parseInt(auxiliar[0]);
                    mes = Integer.parseInt(auxiliar[1])-1;
                    ano = Integer.parseInt(auxiliar[2]);
                    dataI.set(Calendar.DAY_OF_MONTH,dia);
                    dataI.set(Calendar.MONTH,mes);
                    dataI.set(Calendar.YEAR,ano);     
                    duracao = Integer.parseInt(duracaoFieldNP.getText());

                    iP = (Docente) (listaInvestigadoresP.getSelectedValue());
                    
                    Projeto p = new Projeto(nome, acronimo, dataI, duracao, iP);
                    gestor.novoProjeto(p);
                    acronimoFieldNP.setText("");
                    nomeFieldNP.setText("");
                    dataIFieldNP.setText("");
                    duracaoFieldNP.setText("");
                    defProjeto.removeAllElements();
                    for(Projeto proj: gestor.getProjetos()){
                        defProjeto.addElement(proj);
                    }
                    JOptionPane.showMessageDialog(null , "Registado", "Licenciado", JOptionPane.INFORMATION_MESSAGE);
                    gestor.guardaFicheiro(gestor);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Data Inválida", "Erro", JOptionPane.ERROR_MESSAGE);    
                }
                catch(IndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(null , "Selecione Orientador", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(e.getSource() == buttonVoltarNP){
                panelNovoProjeto.setVisible(false);
                panelMenu.setVisible(true);
            }
        }
    }
    
    private class ButtonProjetoListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonVoltarProjeto){
                panelProjetos.setVisible(false);
                panelMenu.setVisible(true);
            }
            if(e.getSource() == buttonSelecionaProjeto){
                try{
                    projetoSelecionado = (Projeto) listaProjeto.getSelectedValue();
                    labelNomeSelecionado.setText("Nome: " + projetoSelecionado.getNome());
                    labelAcronimoSelecionado.setText("Acronimo: " + projetoSelecionado.getAcronimo());
                    labelIpSelecionado.setText("Investigador Principal: " + projetoSelecionado.getIp());
                    labelIniSelecionado.setText("Data Inicial: "  + projetoSelecionado.getIniDataStr());
                    labelFimSelecionado.setText("Data Final Previsto: " + projetoSelecionado.getFimDataStr());
                    
                    panelProjetos.setVisible(false);
                    panelProjetoSelecionado.setVisible(true);
                }
                catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null , "Nenhum projeto selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private class ButtonSelecionadoProjListener implements ActionListener{
        
         @Override
            public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonVoltarSelecionado){
                panelProjetoSelecionado.setVisible(false);
                panelProjetos.setVisible(true);
            }
            else if(e.getSource() == buttonPessoasSelecionado){
                
                defDocentesAssociados.removeAllElements();
                defBolseirosAssociados.removeAllElements();
                for (Pessoa p : projetoSelecionado.getDocentes()){
                    defDocentesAssociados.addElement(p);
                }
                for (Pessoa p : projetoSelecionado.getBolseiros()){
                    defBolseirosAssociados.addElement(p);
                }
                panelProjetoSelecionado.setVisible(false);
                panelPessoasProjeto.setVisible(true);
            }
            else if(e.getSource() == buttonTarefasSelecionado){
                panelProjetoSelecionado.setVisible(false);
                panelMenuTarefas.setVisible(true);
            }
            else if(e.getSource() == buttonCustoSelecionado){
                
                 JOptionPane.showMessageDialog(null , "Custo: "+projetoSelecionado.getCusto()+ "€", "Custo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private class ButtonPessoasProjetoListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonVoltarMenuProjeto){
                panelPessoasProjeto.setVisible(false);
                panelProjetoSelecionado.setVisible(true);
            }
            else if(e.getSource() == buttonAssocia){
                
                pessoasProjeto.removeAllElements();
                //DOCENTE
                for(Pessoa pessoa: gestor.getPessoas()){
                    String email = pessoa.getEmail();
                    if(pessoa.getNumero() != -1){
                        if(projetoSelecionado.getDocentes().isEmpty() && projetoSelecionado.getIp().getEmail().equals(email) == false){                       
                            pessoasProjeto.addElement(pessoa);                           
                        }
                        else if(projetoSelecionado.verificaDocenteProjeto(email) == true){
                            pessoasProjeto.addElement(pessoa);
                        }    
                    }//Bolseiros
                    else{
                        Bolseiro bolseiro = (Bolseiro) pessoa;
                        if(bolseiro.getOrdenado() == 1200 && bolseiro.getContador() == 0){
                            pessoasProjeto.addElement(pessoa);
                        }
                        else if(bolseiro.getContador() != 1200 && bolseiro.getContador() == 0){
                            int auxiliar = 0;
                            ComOrientador a = (ComOrientador) bolseiro;
                            for(Docente orientador: a.getOrientadores()){
                                email = orientador.getEmail();
                                if(projetoSelecionado.verificaOrientadorProjeto(email) == true){
                                    if(auxiliar == 0){
                                        pessoasProjeto.addElement(pessoa);
                                        auxiliar++;
                                    }
                                } 
                            }
                    
                        }
                    }
                }
                gestor.guardaFicheiro(gestor);
                panelPessoasProjeto.setVisible(false);
                panelAssociaPessoas.setVisible(true);
            }
        }
    }
        
    private class ButtonAssociaPessoasListener implements ActionListener{
            
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonAssociaPessoa){
                try{
                    Pessoa pessoa = (Pessoa)listaAssociaPessoas.getSelectedValue();
                    
                    if(pessoa.getNumero() == -1){
                        Bolseiro bolseiro = (Bolseiro)pessoa;
                        bolseiro.setContador(1);
                        bolseiro.setEntradaProj(dataAtual);
                        projetoSelecionado.addBolseiro(bolseiro);
                    }
                    else{
                        Docente docente = (Docente)pessoa;
                        projetoSelecionado.addDocente(docente);
                        
                    }
                    gestor.guardaFicheiro(gestor);
                    panelAssociaPessoas.setVisible(false);
                    panelProjetoSelecionado.setVisible(true);
                    JOptionPane.showMessageDialog(null , "Associado", "Associar", JOptionPane.INFORMATION_MESSAGE);

                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null , "Selecione uma pessoa", "Erro", JOptionPane.ERROR_MESSAGE);    

                }
             }
             else if(e.getSource() == buttonAssociaVoltar){
                panelAssociaPessoas.setVisible(false);
                panelPessoasProjeto.setVisible(true);     
            }
        }
    }
    
    private class ButtonMenuTarefasListener implements ActionListener{
          
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonVoltarTarefas){
                defProjeto.removeAllElements();
                for(Projeto p : gestor.getProjetos()){
                    defProjeto.addElement(p);
                }
                gestor.guardaFicheiro(gestor);
                panelMenuTarefas.setVisible(false);
                panelProjetoSelecionado.setVisible(true);
            }
            else if(e.getSource() == buttonListarTarefas){
                defTarefasConcluidas.removeAllElements();
                defTarefasEmCurso.removeAllElements();
                defTarefasNaoConcluidasData.removeAllElements();
                defTarefasNaoIniciadas.removeAllElements();

                //Tarefas Concluidas
                for (Tarefa t : projetoSelecionado.getTarefas()){
                    if(t.getTaxa() == 100){
                    defTarefasConcluidas.addElement(t);
                    }
                }
                //Tarefas Em Curso
                for(Tarefa t: projetoSelecionado.getTarefas()){
                    if(0 < t.getTaxa() &&  t.getTaxa() < 100){
                        if(t.checkLegitData() == true){
                            defTarefasEmCurso.addElement(t);
                        }
                    }
                }
                //Tarefas Não Concluidas na data
                for(Tarefa t: projetoSelecionado.getTarefas()){
                    if(t.checkLegitData() == false && t.getTaxa()<100){
                        defTarefasNaoConcluidasData.addElement(t);
                    }
                }
                //Tarefas nao iniciadas
                for (Tarefa t: projetoSelecionado.getTarefas()){
                    if(t.getTaxa() == 0){
                        defTarefasNaoIniciadas.addElement(t);
                    }
                }
                panelMenuTarefas.setVisible(false);
                panelListarTarefas.setVisible(true);
            }
            else if(e.getSource() == buttonCriarTarefas){
                panelMenuTarefas.setVisible(false);
                panelCriarTarefa.setVisible(true);
            }
            else if(e.getSource() == buttonAtualizarTarefas){
                defAtualizarTaxa.removeAllElements();
                for(Tarefa t : projetoSelecionado.getTarefas()){
                    if(t.getTaxa() < 100){
                        defAtualizarTaxa.addElement(t);
                    }
                }
                panelMenuTarefas.setVisible(false);
                panelAtualizarTaxa.setVisible(true);
            }
            else if(e.getSource() == buttonEliminarTarefas){
                defEliminaTarefa.removeAllElements();
                for(Tarefa t : projetoSelecionado.getTarefas()){
                  if(t.getTaxa() <100){
                      defEliminaTarefa.addElement(t);
                  }
                }
                panelMenuTarefas.setVisible(false);
                panelEliminaTarefa.setVisible(true);
            }
        }
    }
  
    private class ButtonListarTarefasListener implements ActionListener{

        @Override
           public void actionPerformed(ActionEvent e){
               if(e.getSource() == buttonVoltarListarTarefas){
                   panelListarTarefas.setVisible(false);
                   panelMenuTarefas.setVisible(true);
               }

           }
    }
     
    private class ButtonAtualizarTaxaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            String tmp;
            int taxatmp;
            
            if(e.getSource() == buttonVoltarAtualizarTaxa){
                panelAtualizarTaxa.setVisible(false);
                panelMenuTarefas.setVisible(true);
            }
            if(e.getSource() == buttonAtualizarTaxa){
                Tarefa t = (Tarefa) listaAtualizarTaxa.getSelectedValue();
                try{
                    tmp = valorTaxa.getText();
                    taxatmp = Integer.parseInt(tmp);
                    if(taxatmp > 100 || t.getTaxa() > taxatmp){
                        JOptionPane.showMessageDialog(null , "Taxa Inválida(Máximo 100) e maior que a anterior", "Atualizar Taxa", JOptionPane.ERROR_MESSAGE);
                        valorTaxa.setText("");
                    }
                    else{
                        t.setTaxa(taxatmp);
                        JOptionPane.showMessageDialog(null , "Taxa de Tarefa Atualizada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        if(projetoSelecionado.checkProjetoConcluido() == true){
                            projetoSelecionado.atualizaDataFinal();
                            for(Bolseiro bolseiro: projetoSelecionado.getBolseiros()){
                                bolseiro.setContador(0);
                            }
                            gestor.getProjetosConcluidos().add(projetoSelecionado);
                            gestor.getProjetos().remove(projetoSelecionado);
                        }
                        gestor.guardaFicheiro(gestor);
                        panelAtualizarTaxa.setVisible(false);
                        panelMenuTarefas.setVisible(true);
                    }
                    valorTaxa.setText("");    
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Taxa Inválida(Máximo 100) e maior que a anterior", "Erro", JOptionPane.ERROR_MESSAGE); 
                }
                catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null , "Selecione uma tarefa", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }
     
    private class ButtonCriarTarefasListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){

            String auxini[], auxfim;
            int dia,mes,ano;
            iniDataTarefa = new GregorianCalendar();
            fimDataTarefa = new GregorianCalendar();
            if(e.getSource()== buttonVoltarCriarTarefa){
                panelCriarTarefa.setVisible(false);
                panelMenuTarefas.setVisible(true);
            }
            if (e.getSource() == buttonProximoCriaTarefa){
                defCriarTarefa.removeAllElements();
                try{  
                    auxini = CriarTarefainiData.getText().split("[- /]+");
                    auxfim = CriarTarefaFimData.getText();
                    duracao = Integer.parseInt(auxfim);
                    //DATA INICIO TAREFA WORK
                    dia = Integer.parseInt(auxini[0]);
                    mes = Integer.parseInt(auxini[1])-1;
                    ano = Integer.parseInt(auxini[2]);
                    iniDataTarefa.set(Calendar.DAY_OF_MONTH,dia);
                    iniDataTarefa.set(Calendar.MONTH,mes);
                    iniDataTarefa.set(Calendar.YEAR,ano);
                    fimDataTarefa.set(Calendar.DAY_OF_MONTH,dia);
                    fimDataTarefa.set(Calendar.MONTH,mes);
                    fimDataTarefa.set(Calendar.YEAR,ano);
                    
                    fimDataTarefa.add(Calendar.DAY_OF_MONTH, duracao);
                    
                    if(boxCriarTarefa.getSelectedIndex() == 0){
                        tipoTarefa = 1;
                        for(Docente d : projetoSelecionado.getDocentes()){
                             if(d.verificaEsforco(iniDataTarefa, fimDataTarefa, 1) == true){
                                 defCriarTarefa.addElement(d);
                             }
                        }
                        for(Bolseiro b : projetoSelecionado.getBolseiros()){
                            if(b.verificaEsforco(iniDataTarefa, fimDataTarefa, 1) == true){
                                defCriarTarefa.addElement(b);
                            }
                        }
                    }
                    if(boxCriarTarefa.getSelectedIndex() == 1){
                         tipoTarefa = 2;
                        for(Docente d : projetoSelecionado.getDocentes()){
                             if(d.verificaEsforco(iniDataTarefa, fimDataTarefa, (float)0.5) == true){
                                 defCriarTarefa.addElement(d);
                             }
                        }
                        for(Bolseiro b : projetoSelecionado.getBolseiros()){
                            if(b.verificaEsforco(iniDataTarefa, fimDataTarefa, (float)0.5) == true){
                                defCriarTarefa.addElement(b);
                            }
                        }
                    }
                    if(boxCriarTarefa.getSelectedIndex() == 2){
                         tipoTarefa = 3;
                        for(Docente d : projetoSelecionado.getDocentes()){
                             if(d.verificaEsforco(iniDataTarefa, fimDataTarefa, (float)0.25) == true){
                                 defCriarTarefa.addElement(d);
                             }
                        }
                        for(Bolseiro b : projetoSelecionado.getBolseiros()){
                            if(b.verificaEsforco(iniDataTarefa, fimDataTarefa, (float)0.25) == true){
                                defCriarTarefa.addElement(b);
                            }
                        }
                    }
                    panelCriarTarefa.setVisible(false);
                    panelSelecionaPessoa.setVisible(true);
                 }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null , "Indique as Datas e duração", "Erro", JOptionPane.ERROR_MESSAGE);
                 }  
            }
        }
    }
    
    private class ComboBoxActionListener implements ActionListener{
         @Override
            public void actionPerformed(ActionEvent e){
                JComboBox comboBox = (JComboBox) e.getSource();   
            }
    }
    
    private class ButtonSelecionarPessoaCriarTarefasListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() ==  buttonVoltarTipoTarefa){
                panelSelecionaPessoa.setVisible(false);
                panelCriarTarefa.setVisible(true);
            }
            else if(e.getSource() ==  buttonCriarTarefaFinal){
                
                pessoaSelecionada = (Pessoa) listaCriarTarefa.getSelectedValue();
                switch (tipoTarefa) {
                    case 1:
                        desenvolvimento = new Desenvolvimento(iniDataTarefa, duracao, pessoaSelecionada);
                        pessoaSelecionada.addTarefa(desenvolvimento);
                        projetoSelecionado.addTarefa(desenvolvimento);
                        break;
                    case 2:
                        design = new Design(iniDataTarefa, duracao, pessoaSelecionada);
                        pessoaSelecionada.addTarefa(design);
                        projetoSelecionado.addTarefa(design);
                        break;
                    case 3:     
                        documentacao = new Documentacao(iniDataTarefa, duracao, pessoaSelecionada);
                        pessoaSelecionada.addTarefa(documentacao);
                        projetoSelecionado.addTarefa(documentacao);
                        break;
                    default:
                        break;
                }
                panelSelecionaPessoa.setVisible(false);
                panelCriarTarefa.setVisible(true);
            }
        }
    }
    
    private class ButtonEliminaTarefaListener implements ActionListener{

      @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()== buttonVoltarEliminaTarefa){
                panelEliminaTarefa.setVisible(false);
                panelMenuTarefas.setVisible(true);
            }
            if(e.getSource() == buttonEliminaTarefa){
                Tarefa t = (Tarefa) listaEliminaTarefa.getSelectedValue();
                try{
                    projetoSelecionado.getTarefas().remove(t);
                    t.getResponsavel().getTarefas().remove(t);
                    JOptionPane.showMessageDialog(null , "Tarefa Eliminada", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    gestor.guardaFicheiro(gestor);
                    panelEliminaTarefa.setVisible(false);
                    panelMenuTarefas.setVisible(true);
                }
                catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null , "Selecione uma tarefa", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private class ButtonConcProjListener implements ActionListener{
        
         @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == buttonVoltarConc){
                    panelConcprojetos.setVisible(false);
                    panelMenu.setVisible(true);
                }
                else if(e.getSource() == buttonDetalhesConc){
                    //Print Detalhes
                    try{
                        defpessoasProjeto.removeAllElements();
                        deftarefasProjeto.removeAllElements();
                        Projeto proj = (Projeto) (listaconcProjetos.getSelectedValue());
                        labelnomeProjeto.setText("Nome do Projeto: " +proj.getNome()+" // "+proj.getAcronimo());
                        labelipProjeto.setText("Investigador Principal: " +proj.getIp().getNome());
                        labeliniProjeto.setText("Data de Inicio: "+proj.getIniDataStr());
                        labelfimProjeto.setText("Data de Fim: "+proj.getFimDataStr());
                        labelCusto.setText("Custo: " + proj.getCusto() +"€");
                        for (Docente d : proj.getDocentes()){
                            defpessoasProjeto.addElement("Docente: "+d.getNome());
                        }
                        for (Bolseiro b: proj.getBolseiros()){
                            if(b.getOrdenado()==800){
                                 defpessoasProjeto.addElement("Licenciado: "+b.getNome());
                            }
                            if(b.getOrdenado()==1000){
                                 defpessoasProjeto.addElement("Mestre: "+b.getNome());
                            }
                            if(b.getOrdenado()==1200){
                                 defpessoasProjeto.addElement("Doutorado: "+b.getNome());
                            }
                        }
                        for (Tarefa t : proj.getTarefas()){
                            deftarefasProjeto.addElement(t);
                        }
                        panelConcprojetos.setVisible(false);
                        panelDetalhesConc.setVisible(true);
                    }catch(NullPointerException exc){
                        JOptionPane.showMessageDialog(null , "Nenhum projeto selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
    }
    
    private class ButtonDetalhesConcListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonVoltarDetalhes){
                panelDetalhesConc.setVisible(false);
                panelConcprojetos.setVisible(true);
            }
        }
    } 

    private class ButtonIProjetosListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonIVoltar){
                panelInacabado.setVisible(false);
                panelMenu.setVisible(true);
            }
            else if(e.getSource() == buttonIDetalhes){
                //Print Detalhes
                defIPessoasProjetos.removeAllElements();
                defITarefasProjetos.removeAllElements();
                try{
                Projeto proj = (Projeto) (listaIProjetos.getSelectedValue());
                labelINomeProjeto.setText("Nome do Projeto: " +proj.getNome()+" // "+proj.getAcronimo());
                labelIIpProjeto.setText("Investigador Principal: " +proj.getIp().getNome());
                labelInacabadoIniProjeto.setText("Data de Inicio: "+proj.getIniDataStr());
                labelIFimProjeto.setText("Data de Fim Prevista: "+proj.getFimDataStr());
                labelICusto.setText("Custo: " + proj.getCusto() +"€");
                for (Docente d : proj.getDocentes()){
                    defIPessoasProjetos.addElement("Docente: "+d.getNome());
                }
                for (Bolseiro b: proj.getBolseiros()){
                    if(b.getOrdenado()==800){
                         defIPessoasProjetos.addElement("Licenciado: "+b.getNome());
                    }
                    if(b.getOrdenado()==1000){
                         defIPessoasProjetos.addElement("Mestre: "+b.getNome());
                    }
                    if(b.getOrdenado()==1200){
                         defIPessoasProjetos.addElement("Doutorado: "+b.getNome());
                    }
                }
                for (Tarefa t : proj.getTarefas()){
                    defITarefasProjetos.addElement(t);
                }
                panelInacabado.setVisible(false);
                panelDetalhesInacabado.setVisible(true);
                }catch(NullPointerException exc){
                    JOptionPane.showMessageDialog(null , "Nenhum projeto selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
     
    private class ButtonDetalhesInacabadoListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == buttonIVoltarDetalhes){
                panelDetalhesInacabado.setVisible(false);
                panelInacabado.setVisible(true);
            }
        }
    }    
    
}
