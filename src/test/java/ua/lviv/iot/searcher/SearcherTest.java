package ua.lviv.iot.searcher;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.lviv.iot.graph.OrientedGraph;

public class SearcherTest {
	private OrientedGraph<String> orientedGraph;
	private OptimalSequenceSearcher optimalSequenceSearcher = new OptimalSequenceSearcher();

	@Before
	public void initializeGraph() {
		orientedGraph = new OrientedGraph<>();
	}

	@Test
	public void findOptimalSequenceTestWithOneEdge() {
		orientedGraph.addEdge("visa", "foreignpassport");
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "foreignpassport", "visa" };
		assertArrayEquals(expectedResult, result.toArray());
	}

	@Test
	public void findOptimalSequenceTestWithSeveralEdges() {
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
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "birthcertificate", "nationalpassport", "militarycertificate", "foreignpassport",
				"creditcard", "hotel", "bankstatement", "visa" };
		assertArrayEquals(expectedResult, result.toArray());
	}

	@Test
	public void findOptimalSequenceTestWithTwoEdges() {
		orientedGraph.addEdge("visa", "foreignpassport");
		orientedGraph.addEdge("foreignpassport", "birthcertificate");
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "birthcertificate", "foreignpassport", "visa" };
		assertArrayEquals(expectedResult, result.toArray());
	}

	@Test
	public void findOptimalSequenceTestWithThreeEdges() {
		orientedGraph.addEdge("visa", "foreignpassport");
		orientedGraph.addEdge("foreignpassport", "birthcertificate");
		orientedGraph.addEdge("visa", "birthcertificate");
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "birthcertificate", "foreignpassport", "visa" };
		assertArrayEquals(expectedResult, result.toArray());
	}

	@Test
	public void findOptimalSequenceTestWithRootNodeInTheMiddle() {
		orientedGraph.addEdge("a", "b");
		orientedGraph.addEdge("c", "a");
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "b", "a", "c" };
		assertArrayEquals(expectedResult, result.toArray());
	}

	@Test
	public void findOptimalSequenceTestWithTwoRootNodes() {
		orientedGraph.addEdge("a", "b");
		orientedGraph.addEdge("c", "d");
		List<String> result = optimalSequenceSearcher.findOptimalSequenceFor(orientedGraph);
		String[] expectedResult = { "b", "a", "d", "c" };
		assertArrayEquals(expectedResult, result.toArray());
	}
}
