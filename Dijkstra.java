/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Scanner;

/**
 *
 * @author Elimm
 */
public class Dijkstra {

    public int V = 0; 
    
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        System.out.println("Ingresar numero de vertices\n");

        int Ver = scaner.nextInt();

        System.out.println("\nIngresar Matriz\n");

        int[][] matriz = new int[Ver][Ver];
        
        for (int i = 0; i < Ver; i++)
            for (int j = 0; j < Ver; j++)
                matriz[i][j] = scaner.nextInt();
        
        Dijkstra inicio = new Dijkstra(); 
        inicio.dijkstraAlgoritmo(matriz, 0, Ver); 
    }

    void dijkstraAlgoritmo(int grafo[][], int raiz, int vertice) 
    { 
        V=vertice;
        int distancia[] = new int[V]; 
        
        Boolean unido[] = new Boolean[V]; 

        for (int i = 0; i < V; i++) { 
            distancia[i] = Integer.MAX_VALUE; 
            unido[i] = false; 
        }
        distancia[raiz] = 0; 
        for (int i = 0; i < V - 1; i++) { 
            int nodoMin = buscarMinima(distancia, unido); 
            unido[nodoMin] = true; 
            for (int verti = 0; verti < V; verti++) 

                if ((unido[verti]==false) && (distancia[nodoMin] != Integer.MAX_VALUE) && (grafo[nodoMin][verti] != distancia[raiz]) &&
                        (distancia[nodoMin]+grafo[nodoMin][verti] < distancia[verti])) 
                    distancia[verti] = (distancia[nodoMin] + grafo[nodoMin][verti]); 
        } 
  
        System.out.println("Vertice    Distancia de la raiz"); 
        for (int i = 0; i < V; i++){ 
            System.out.println(i + " --------- " + distancia[i]);
        }
    } 
    
     int buscarMinima(int dist[], Boolean unido[]) 
    { 
        int minimo = Integer.MAX_VALUE, nodoMin = -1;  
        for (int v = 0; v < V; v++) 
            if (dist[v] <= minimo && unido[v] == false ) { 
                minimo = dist[v]; 
                nodoMin = v; 
            } 
        return nodoMin; 
    }
    
}
