package ua.lviv.iot.searcher;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.graph.Graph;

public class Searcher {

	public List<String> findOptimalSequenceFor(Graph<String> graph) {
		int numberOfVertices = graph.numberOfVertices();
		List<String> optimalSequence = new ArrayList<String>(numberOfVertices);
		boolean[] isVisited = new boolean[numberOfVertices];
		for (int counter = 0; counter < numberOfVertices; counter++) {
			isVisited[counter] = false;
		}
		for (int i = 0; i < graph.numberOfVertices(); i++) {
			depthFirstSearch(i, graph, optimalSequence, isVisited);
		}
		return optimalSequence;
	}

	private void depthFirstSearch(int currentVertexPosition, Graph<String> graph, List<String> optimalSequence,
			boolean[] isVisited) {
		if (isVisited[currentVertexPosition]) {
			return;
		}
		isVisited[currentVertexPosition] = true;
		List<Integer> currentVertexNeighborPositions = graph.getNeighborPositionsFor(currentVertexPosition);
		for (int neighborPosition = 0; neighborPosition < currentVertexNeighborPositions.size(); neighborPosition++) {
			depthFirstSearch(currentVertexNeighborPositions.get(neighborPosition), graph, optimalSequence, isVisited);
		}
		optimalSequence.add(graph.getVertexAt(currentVertexPosition));
	}
}
