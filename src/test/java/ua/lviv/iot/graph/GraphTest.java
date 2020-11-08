package ua.lviv.iot.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {
	private Graph<String> graph;

	public GraphTest() {
		graph = new Graph<>();
	}

	public void testVertexAdding() {
		graph.addVertex("visa");
		graph.addVertex("foreignpassport");
		graph.addVertex("visa");
		graph.addVertex("hotel");
		graph.addVertex("visa");
		graph.addVertex("bankstatement");
		graph.addVertex("bankstatement");
		graph.addVertex("nationalpassport");
		graph.addVertex("hotel");
		graph.addVertex("creditcard");
		graph.addVertex("creditcard");
		graph.addVertex("nationalpassport");
		graph.addVertex("nationalpassport");
		graph.addVertex("birthcertificate");
		graph.addVertex("foreignpassport");
		graph.addVertex("nationalpassport");
		graph.addVertex("foreignpassport");
		graph.addVertex("militarycertificate");
		graph.addVertex("militarycertificate");
		graph.addVertex("nationalpassport");
		assertEquals(graph.numberOfVertices(), 8);
	}

	@Test
	public void testEdgeAdding() {
		testVertexAdding();
		graph.addEdge("visa", "foreignpassport");
		graph.addEdge("nationalpassport", "birthcertificate");
		graph.addEdge("visa", "hotel");
		graph.addEdge("foreignpassport", "militarycertificate");
		graph.addEdge("visa", "bankstatement");
		graph.addEdge("bankstatement", "nationalpassport");
		graph.addEdge("hotel", "creditcard");
		graph.addEdge("militarycertificate", "nationalpassport");
		graph.addEdge("foreignpassport", "nationalpassport");
		graph.addEdge("creditcard", "nationalpassport");
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("visa")).size(), 3);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("foreignpassport")).size(), 2);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("hotel")).size(), 1);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("bankstatement")).size(), 1);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("militarycertificate")).size(), 1);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("creditcard")).size(), 1);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("nationalpassport")).size(), 1);
		assertEquals(graph.getNeighborPositionsFor(graph.getPositionOf("birthcertificate")).size(), 0);
	}
}
