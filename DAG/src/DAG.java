//topological sort method taken from https://www.geeksforgeeks.org/topological-sorting/

import java.util.*;

class DAG {
    static final int MAX_INT = Integer.MAX_VALUE;

    class AdjListNode {
        private int v;
        private int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }

    class Graph {
        private int V;
        private LinkedList<AdjListNode> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<AdjListNode>();
        }

        void addEdge(int u, int v, int weight) {
            AdjListNode node = new AdjListNode(v, weight);
            adj[u].add(node);
        }

        void topologicalSortUtil(int v, Boolean visited[], Stack stack) {

            visited[v] = true;
            Integer i;

            Iterator<AdjListNode> it = adj[v].iterator();
            while (it.hasNext()) {
                AdjListNode node = it.next();
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }

            stack.push(new Integer(v));
        }

        String shortestPath(int s) {
        	try {
            Stack stack = new Stack();
            int dist[] = new int[V];

            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            for (int i = 0; i < V; i++)
                dist[i] = MAX_INT;
            dist[s] = 0;

            while (stack.empty() == false) {

                int u = (int) stack.pop();

                Iterator<AdjListNode> it;
                if (dist[u] != MAX_INT) {
                    it = adj[u].iterator();
                    while (it.hasNext()) {
                        AdjListNode i = it.next();
                        if (dist[i.getV()] > dist[u] + i.getWeight())
                            dist[i.getV()] = dist[u] + i.getWeight();
                    }
                }
            }

            String outputString = "";
            for (int i = 0; i < V; i++) {
                if (dist[i] == MAX_INT)
                    System.out.print("");
                else
                    outputString += (dist[i] + " ");
            }
            return outputString;
        	}
            catch(ArrayIndexOutOfBoundsException exception){
            	return "no path found";
            }
        }

    }

    Graph newGraph(int number) {
        return new Graph(number);
    }
}