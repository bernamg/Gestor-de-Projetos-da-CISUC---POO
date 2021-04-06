/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.IOException;
import javax.swing.JFrame;



/**
 * Main Classe
 * @author Márcio Ribeiro
 * @author Bernardo Graça
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        Gestor gestor = new Gestor();
        gestor = gestor.leFicheiro();
        Interface frame = new Interface(gestor);
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        gestor.guardaFicheiro(gestor);
        
    }
    
}