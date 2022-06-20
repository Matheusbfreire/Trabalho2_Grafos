package main;

import java.util.*;
import app.Grafo;

public class Main {

    public static void main(String[] args) {

    	int grafo[][] = new int[Grafo.TOTAL_VERTICES][Grafo.TOTAL_VERTICES];
    	Random gerador = new Random();
    	
    	for(int i=0; i<Grafo.TOTAL_VERTICES; i++) {
    		for(int z=0; z<Grafo.TOTAL_VERTICES; z++) {
    			if(z==0 || i==Grafo.TOTAL_VERTICES-1) {
    				grafo[i][z] = 0;
    			} else {
    				grafo[i][z] = gerador.nextInt(2);
    			}
    		}
    	}
    	
    	System.out.println("Grafo:\n");
    	for(int i=0; i<Grafo.TOTAL_VERTICES; i++) {
    		for(int z=0; z<Grafo.TOTAL_VERTICES; z++) {
				System.out.print(grafo[i][z] + ", ");
    		}
    		System.out.println("");
    	}
    	
    	Grafo g = new Grafo();
    	Map<Integer, Stack<Integer>> map = g.getMap();
        int s = 0;
        int t = Grafo.TOTAL_VERTICES - 1;
        int max_caminhos = g.encontraMaximoCaminhosDisjuntos(grafo, s, t);

        System.out.println("\nExiste um máximo de " + max_caminhos + " caminhos disjuntos em arestas.\n");
        System.out.print("Caminhos: ");
        for(int i=1; i<=max_caminhos; i++) {
        	System.out.print("[ ");
        	for(int z=((map.get(i).size())-1); z>=0; z--) {
        		System.out.print(map.get(i).get(z) + " ");
        	}
        	System.out.println("]");
        }
    }
}
