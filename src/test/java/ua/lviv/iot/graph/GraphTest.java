package ua.lviv.iot.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private OrientedGraph<String> orientedGraph;

	@Before
	public void initializeGraph() {
		orientedGraph = new OrientedGraph<>();
	}

	@Test
	public void testVertexAdding() {
		orientedGraph.addVertex("visa");
		orientedGraph.addVertex("foreignpassport");
		orientedGraph.addVertex("visa");
		orientedGraph.addVertex("hotel");
		orientedGraph.addVertex("visa");
		orientedGraph.addVertex("bankstatement");
		orientedGraph.addVertex("bankstatement");
		orientedGraph.addVertex("nationalpassport");
		orientedGraph.addVertex("hotel");
		orientedGraph.addVertex("creditcard");
		orientedGraph.addVertex("creditcard");
		orientedGraph.addVertex("nationalpassport");
		orientedGraph.addVertex("nationalpassport");
		orientedGraph.addVertex("birthcertificate");
		orientedGraph.addVertex("foreignpassport");
		orientedGraph.addVertex("nationalpassport");
		orientedGraph.addVertex("foreignpassport");
		orientedGraph.addVertex("militarycertificate");
		orientedGraph.addVertex("militarycertificate");
		orientedGraph.addVertex("nationalpassport");
		assertEquals(8, orientedGraph.numberOfVertices());
	}

	@Test
	public void testEdgeAdding() {
		orientedGraph.addEdge("visa", "foreignpassport");
		orientedGraph.addEdge("nationalpassport", "birthcertificate");
		orientedGraph.addEdge("visa", "hotel");
		orientedGraph.addEdge("foreignpassport", "militarycertificate");
		orientedGraph.addEdge("visa", "bankstatement");
		orientedGraph.addEdge("bankstatement", "nationalpassport");
		orientedGraph.addEdge("hotel", "creditcard");
		orientedGraph.addEdge("militarycertificate", "nationalpassport");
		orientedGraph.addEdge("foreignpassport", "nationalpassport");
		orientedGraph.addEdge("creditcard", "nationalpassport");
		assertEquals(3, orientedGraph.getNeighborsFor("visa").size());
		assertEquals(2, orientedGraph.getNeighborsFor("foreignpassport").size());
		assertEquals(1, orientedGraph.getNeighborsFor("hotel").size());
		assertEquals(1, orientedGraph.getNeighborsFor("bankstatement").size());
		assertEquals(1, orientedGraph.getNeighborsFor("militarycertificate").size());
		assertEquals(1, orientedGraph.getNeighborsFor("creditcard").size());
		assertEquals(1, orientedGraph.getNeighborsFor("nationalpassport").size());
		assertEquals(0, orientedGraph.getNeighborsFor("birthcertificate").size());
	}
}
