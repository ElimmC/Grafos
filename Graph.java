/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Scanner;
/**
 *
 * @author Elimm
 */
public class Graph {

    private int Vertice, numColores;
    private int[] color; 
    private int[][] grafo;
    

    public static void main (String[] args) 
    {
        Scanner scaner = new Scanner(System.in);
        Graph grafo = new Graph();
 
        System.out.println("Ingresar numero de vertices\n");
        int Ver = scaner.nextInt();

        System.out.println("\nIngresar Matriz\n");
        int[][] matriz = new int[Ver][Ver];
        for (int i = 0; i < Ver; i++)
            for (int j = 0; j < Ver; j++)
                matriz[i][j] = scaner.nextInt();
        int maxColores = Ver;
        grafo.Colores(matriz, maxColores);
    }
    
        public void Colores(int[][] matriz, int coloritos)
    {
        Vertice = matriz.length;
        numColores = coloritos;
        color = new int[Vertice];
        grafo = matriz;
 
        if(sigVertice(0)==1){
            resultados();
        }
        else{
            System.out.println("No hay solucion");
        }
        
    }
    /** funcion recursiva explosiva (creo que podria dar errores) **/
    public int sigVertice(int ver) 
    {
        int numero=1;
        if (ver == Vertice)
            return numero=1;
        for (int colorParticular = 1; colorParticular <= numColores; colorParticular++)
        {
            if (asignarColor(ver, colorParticular))
            {
                color[ver] = colorParticular;
                if(sigVertice(ver + 1)==1){
                    break;
                }
                else{
                 return numero=0;
                }
            }           
        }  
        return numero; 
    }

    public boolean asignarColor(int v, int colorParticular)
    {
        for (int arista = 0; arista < Vertice; arista++)
            if (grafo[v][arista] == 1 && colorParticular == color[arista])
                return false;
        return true;
    }

    public void resultados()
    {
        System.out.println("\nColores : ");
        for (int i = 0; i < Vertice; i++)
            System.out.print(color[i] +"");
    } 
    
}
