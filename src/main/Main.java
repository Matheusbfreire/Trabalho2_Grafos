package main;

import app.Grafo;

public class Main {
    // Driver Code
    public static void main(String[] args) {
        // Let us create a graph shown in the above example
        int grafo[][] = { { 0, 1, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 } };

        int s = 0;
        int t = 7;
        System.out.println("There can be maximum " + Grafo.encontraMaximoCaminhosDisjuntos(grafo, s, t) + " edge-disjoint paths from " + s + " to " + t);
    }
}
