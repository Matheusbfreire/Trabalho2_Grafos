package app;

import java.util.*;

public class Grafo {
    
    static int TOTAL_VERTICES = 8;
    private Map<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>>();
    
    public Map<Integer, Stack<Integer>> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Stack<Integer>> map) {
		this.map = map;
	}

	private static boolean bfs(int rGrafo[][], int s, int t, int pai[]) {

        boolean[] visitado = new boolean[TOTAL_VERTICES];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visitado[s] = true;
        pai[s] = -1;
        
        while (!q.isEmpty()) {
            int u = q.peek();
            q.remove();

            for (int v = 0; v < TOTAL_VERTICES; v++) {
                if (visitado[v] == false &&
                        rGrafo[u][v] > 0) {
                    q.add(v);
                    pai[v] = u;
                    visitado[v] = true;
                }
            }
        }
        
        return (visitado[t] == true);
    }

    public int encontraMaximoCaminhosDisjuntos(int grafo[][], int s, int t) {
        int u, v;

        int[][] rGrafo = new int[TOTAL_VERTICES][TOTAL_VERTICES];
        for (u = 0; u < TOTAL_VERTICES; u++) {
            for (v = 0; v < TOTAL_VERTICES; v++) {
                rGrafo[u][v] = grafo[u][v];
            }
        }
        int[] pai = new int[TOTAL_VERTICES];

        int max_flow = 0;
        
        while (bfs(rGrafo, s, t, pai)) {
            int caminho_flow = Integer.MAX_VALUE;

            for (v = t; v != s; v = pai[v]) {
                u = pai[v];
                caminho_flow = Math.min(caminho_flow, rGrafo[u][v]);
            }
            
            for (v = t; v != s; v = pai[v]) {
                u = pai[v];
                rGrafo[u][v] -= caminho_flow;
                rGrafo[v][u] += caminho_flow;
            }
            
            max_flow += caminho_flow;
            map.put(max_flow, geraCaminho(pai));
        }
        
        return max_flow;
    }
    
    public Stack<Integer> geraCaminho(int pai[]) {
    	Stack<Integer> resp = new Stack<Integer>();
    	int pos = 7;
    	
    	while(pai[pos] != -1) {
    		resp.push(pos);
    		pos = pai[pos];
    	}
		resp.push(pos);
    	
    	return resp;
    }
}