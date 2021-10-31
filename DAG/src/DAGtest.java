import static org.junit.Assert.*;

import org.junit.Test;

public class DAGtest {

	@Test
	public void testBasic() {

        DAG newDAG = new DAG();
        DAG.Graph graph = newDAG.newGraph(6);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, -2);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 5, -3);
        graph.addEdge(4, 5, 3);
 
        assertEquals("DAG(1): ","0 1 -1 2 ",graph.shortestPath(1));
        assertEquals("DAG(3): ","0 -2 1 ",graph.shortestPath(3));

        
	}
	
	@Test
	public void testEmpty() {

        DAG newDAG1 = new DAG();
        DAG.Graph graph1 = newDAG1.newGraph(0);

        assertEquals("DAG(1): ","no path found",graph1.shortestPath(0));      
	}
	
	@Test	
	public void testNull() {

        DAG newDAG2 = new DAG();
        DAG.Graph graph2 = newDAG2.newGraph(6);
        graph2.addEdge(0, 1, 1);
        graph2.addEdge(0, 2, 2);
        graph2.addEdge(0, 3, 4);
        graph2.addEdge(1, 3, 1);
        graph2.addEdge(2, 4, 5);
        graph2.addEdge(3, 4, -2);
        graph2.addEdge(2, 4, 6);
        graph2.addEdge(2, 5, -3);
        graph2.addEdge(4, 5, 3);
 
        assertEquals("DAG(1): ","no path found",graph2.shortestPath(6));

        
	}
}
