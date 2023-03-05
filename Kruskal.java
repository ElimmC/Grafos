/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.Scanner;

/**
 *
 * @author Elimm
 */
public class Kruskal {

 int V; 
 int[] grafoInicial ;
 int muyGrande = Integer.MAX_VALUE; 
 
     public static void main(String[] args) {
    Scanner scaner = new Scanner(System.in);
    
    System.out.println("Ingresar numero de vertices\n");
        int Ver = scaner.nextInt();
        
    System.out.println("\nIngresar Matriz de costos (para infinito, escribir 9999)\n");
        int[][] matriz = new int[Ver][Ver];
        for (int i = 0; i < Ver; i++)
            for (int j = 0; j < Ver; j++){
                matriz[i][j] = scaner.nextInt();
                if(matriz[i][j]==9999){
                    matriz[i][j]=Integer.MAX_VALUE;
                }    
            }
  
    Kruskal clase = new Kruskal();
    clase.kruskal1(matriz, Ver); 
    }
  
 
 void kruskal1(int costos[][],int vertices) 
{ 
    V=vertices;  
    grafoInicial = new int[V]; 
    int costoMinimo = 0;
   
    for (int i = 0; i < V; i++){
        grafoInicial[i] = i; 
    }
  
    int bordeMenor = 0; 
    while (bordeMenor < V - 1) 
    { 
        int minimo = muyGrande;
        int a = -1;
        int b = -1;        
        for (int i = 0; i < V; i++){ 
            for (int j = 0; j < V; j++){ 
                if (encontrarUnion(i)!=encontrarUnion(j) && costos[i][j] < minimo){ 
                    minimo = costos[i][j]; 
                    a = i; 
                    b = j; 
                } 
            } 
        } 
        unirVert(a, b); 
        System.out.printf("borde"+(bordeMenor++)+" :("+a+", "+b+") cost:"+minimo+" \n"); 
        costoMinimo += minimo; 
    } 
    System.out.printf("\n Costo = "+costoMinimo+" \n"); 
}
int encontrarUnion(int vertice) 
{ 
    while(grafoInicial[vertice] != vertice){ 
        vertice = grafoInicial[vertice]; 
    }
    return vertice; 
} 
  
void unirVert(int i, int j) 
{ 
    int a = encontrarUnion(i); 
    int b = encontrarUnion(j); 
    grafoInicial[a] = b; 
}  
    
}
