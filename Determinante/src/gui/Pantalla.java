/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.Determinante;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author j4v13
 */
public class Pantalla extends JFrame{
    
    Determinante determinante;
    JTextField[][] valores;
    JButton btnCalcular;
    JButton btnNuevo;
    int size;

    public Pantalla() {
        super("Determinante");
        super.setSize(250, 250);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String aux = JOptionPane.showInputDialog(this,"Tamaño de la matriz",JOptionPane.QUESTION_MESSAGE);  
        try {
            size = Integer.valueOf(aux);
            determinante = new Determinante();
            super.add(pnlMatriz(), BorderLayout.CENTER);
            super.add(pnlBoton(), BorderLayout.SOUTH);
            super.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Adios!");
            this.dispose();
        }        
    }
    
    private JPanel pnlMatriz() {
        JPanel pnlMatriz = new JPanel();
        pnlMatriz.setLayout(new GridLayout(size,size));
        valores = new JTextField[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                valores[i][j] = new JTextField();
                pnlMatriz.add(valores[i][j]);
            }
        }
        return pnlMatriz;
    }
    
    private JPanel pnlBoton() {
        JPanel pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        btnCalcular = new JButton("Calcular");
        btnNuevo = new JButton("Nuevo");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    int[][]matriz= new int[size][size];
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            matriz[i][j] = Integer.valueOf(valores[i][j].getText());
                        }
                    }
                    JOptionPane.showMessageDialog(Pantalla.this, "Determinante: "+determinante.determinante(matriz, size));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Pantalla.this, "Entrada incorrecta");                    
                }
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                determinante.nuevo(Pantalla.this);
            }
        });
        pnlBoton.add(btnCalcular);
        pnlBoton.add(btnNuevo);
        return pnlBoton;
    }
}
