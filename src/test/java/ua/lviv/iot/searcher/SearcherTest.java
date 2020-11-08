package ua.lviv.iot.searcher;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ua.lviv.iot.graph.Graph;

public class SearcherTest {

	@Test
	public void findOptimalSequenceFirstTest() {
		Graph<String> graph = new Graph<>();
		graph.addVertex("visa");
		graph.addVertex("foreignpassport");
		graph.addEdge("visa", "foreignpassport");
		Searcher searcher = new Searcher();
		List<String> result = searcher.findOptimalSequenceFor(graph);
		assertEquals(result.get(0), "foreignpassport");
		assertEquals(result.get(1), "visa");
	}

	@Test
	public void findOptimalSequenceSecondTest() {
		Graph<String> graph = new Graph<>();
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
		Searcher searcher = new Searcher();
		List<String> result = searcher.findOptimalSequenceFor(graph);
		assertEquals(result.get(0), "birthcertificate");
		assertEquals(result.get(1), "nationalpassport");
		assertEquals(result.get(2), "militarycertificate");
		assertEquals(result.get(3), "foreignpassport");
		assertEquals(result.get(4), "creditcard");
		assertEquals(result.get(5), "hotel");
		assertEquals(result.get(6), "bankstatement");
		assertEquals(result.get(7), "visa");
	}

	@Test
	public void findOptimalSequenceThirdTest() {
		Graph<String> graph = new Graph<>();
		graph.addVertex("visa");
		graph.addVertex("foreignpassport");
		graph.addVertex("foreignpassport");
		graph.addVertex("birthcertificate");
		graph.addEdge("visa", "foreignpassport");
		graph.addEdge("foreignpassport", "birthcertificate");
		Searcher searcher = new Searcher();
		List<String> result = searcher.findOptimalSequenceFor(graph);
		assertEquals(result.get(0), "birthcertificate");
		assertEquals(result.get(1), "foreignpassport");
		assertEquals(result.get(2), "visa");
	}
	@Test
	public void findOptimalSequenceForthTest() {
		Graph<String> graph = new Graph<>();
		graph.addVertex("visa");
		graph.addVertex("foreignpassport");
		graph.addVertex("visa");
		graph.addVertex("birthcertificate");
		graph.addVertex("foreignpassport");
		graph.addVertex("birthcertificate");
		graph.addEdge("visa", "foreignpassport");
		graph.addEdge("foreignpassport", "birthcertificate");
		graph.addEdge("visa", "birthcertificate");
		Searcher searcher = new Searcher();
		List<String> result = searcher.findOptimalSequenceFor(graph);
		assertEquals(result.get(0), "birthcertificate");
		assertEquals(result.get(1), "foreignpassport");
		assertEquals(result.get(2), "visa");
	}
}
