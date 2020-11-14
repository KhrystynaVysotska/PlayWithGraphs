package ua.lviv.iot.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An oriented graph build as adjacency list with parameterized vertices.
 * 
 * @author Khrystyna Vysotska
 */
public class OrientedGraph<T> {
	Map<T, List<T>> orientedGraph;

	public OrientedGraph() {
		orientedGraph = new HashMap<>();
	}

	/**
	 * <p>
	 * Checks if vertex is in graph.
	 * </p>
	 *
	 * @param <T> vertex to check
	 * @return true if vertex is in graph; false otherwise
	 */
	public boolean exists(T vertex) {
		return orientedGraph.containsKey(vertex);
	}

	/**
	 * Adds new vertex to the graph.
	 * <p>
	 * <ul>
	 * <li>If vertex is already in graph - nothing is done.</li>
	 * </ul>
	 * </p>
	 *
	 * @param <T> vertex to add
	 * @return nothing
	 */
	public void addVertex(T vertex) {
		if (!exists(vertex)) {
			orientedGraph.put(vertex, new ArrayList<T>());
		}
	}

	/**
	 * <p>
	 * Creates an edge between two vertices.
	 * </p>
	 *
	 * @param <T> vertex to draw edge from
	 * @param <T> vertex to draw edge to
	 * @return nothing
	 */
	public void addEdge(T vertexFrom, T vertexTo) {
		addVertex(vertexFrom);
		addVertex(vertexTo);
		orientedGraph.get(vertexFrom).add(vertexTo);
	}

	/**
	 * <p>
	 * Finds adjacent vertices for this vertex.
	 * </p>
	 *
	 * @param vertex vertex to get adjacent vertices for
	 * @return List with adjacent vertices for this vertex if this vertex exists;
	 *         null otherwise
	 */
	public List<T> getNeighborsFor(T vertex) {
		return orientedGraph.get(vertex);
	}

	/**
	 * <p>
	 * Gets the number of vertices in graph.
	 * </p>
	 *
	 * @return the number of vertices in graph
	 */
	public int numberOfVertices() {
		return orientedGraph.size();
	}

	/**
	 * <p>
	 * Checks whether graph is empty.
	 * </p>
	 *
	 * @return true if there is no vertices in graph; false otherwise
	 */
	public boolean isEmpty() {
		return orientedGraph.size() == 0;
	}
}
