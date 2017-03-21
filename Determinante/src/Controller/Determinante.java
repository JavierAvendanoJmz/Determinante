/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import gui.Pantalla;

/**
 *
 * @author j4v13
 */
public class Determinante {
    
    public void nuevo(Pantalla pantalla) {
        pantalla.dispose();
        pantalla = new Pantalla();
    }
    
    public int determinante(int[][] det,int size) {
        int determinante = 0;
        if(size == 1) {
            return det[0][0];
        } else {
            int signo = 1;
            for (int i = 0; i < size; i++) {
                determinante += signo*(det[0][i]*determinante(submatriz(det, 0, i, size),size-1));
                signo*=-1;
            }
        }
        return determinante;
    }
    
    public int[][] submatriz(int[][] matriz,int f, int c,int size) {
        int[][] sub = new int[size-1][size-1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i != f && j != c) {
                    sub[x][y]=matriz[i][j];
                    y++;
                }
            }
            if(i != f){
                x++;
                y = 0;
            }
        }
        return sub;
    }
    
}
