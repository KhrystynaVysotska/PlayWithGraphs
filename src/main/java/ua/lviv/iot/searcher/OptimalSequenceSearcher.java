package ua.lviv.iot.searcher;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.graph.OrientedGraph;

public class OptimalSequenceSearcher {

	public List<String> findOptimalSequenceFor(OrientedGraph<String> graph) {
		int numberOfVertices = graph.numberOfVertices();
		BitSet isVisited = new BitSet(numberOfVertices);
		ArrayList<String> vertices = new ArrayList<>(graph.getVertices());
		return depthFirstSearch(vertices, graph, isVisited);
	}

	public List<String> depthFirstSearch(ArrayList<String> vertices, OrientedGraph<String> graph, BitSet isVisited) {
		List<String> optimalSequence = new LinkedList<>();
		int numberOfVertices = graph.numberOfVertices();
		for (int vertexPosition = 0; vertexPosition < numberOfVertices; vertexPosition++) {
			depthFirstSearch(vertexPosition, vertices, graph, isVisited, optimalSequence);
		}
		return optimalSequence;
	}

	protected void depthFirstSearch(int startVertexPosition, ArrayList<String> vertices, OrientedGraph<String> graph,
			BitSet isVisited, List<String> optimalSequence) {
		if (isVisited.get(startVertexPosition)) {
			return;
		}
		isVisited.set(startVertexPosition);
		String currentVertex = vertices.get(startVertexPosition);
		ArrayList<String> currentVertexNeighbors = graph.getNeighborsFor(currentVertex);
		for (String neighbor : currentVertexNeighbors) {
			depthFirstSearch(vertices.indexOf(neighbor), vertices, graph, isVisited, optimalSequence);
		}
		optimalSequence.add(currentVertex);
	}
}
