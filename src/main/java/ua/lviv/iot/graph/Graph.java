package ua.lviv.iot.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An oriented graph build as adjacency list with parameterized vertices.
 * 
 * @author Khrystyna Vysotska
 */
public class Graph<T> {
	private int numberOfVertices;
	private List<T> vertices;
	private List<List<Integer>> neighborPositions;

	public Graph() {
		vertices = new LinkedList<>();
		neighborPositions = new LinkedList<>();
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
		return vertices.contains(vertex);
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
			vertices.add(vertex);
			neighborPositions.add(new LinkedList<Integer>());
			numberOfVertices++;
		}
	}

	/**
	 * <p>
	 * Creates an edge between two vertices.
	 * </p>
	 *
	 * @param <T> vertex to draw edge from
	 * @param <T> vertex to draw edge to
	 * @throws NoSuchElementException if there is no such vertices in graph
	 * @return nothing
	 */
	public void addEdge(T vertexFrom, T vertexTo) {
		if (!exists(vertexFrom) || !exists(vertexTo)) {
			throw new NoSuchElementException();
		}
		int vertexFromPosition = getPositionOf(vertexFrom);
		int vertexToPosition = getPositionOf(vertexTo);
		neighborPositions.get(vertexFromPosition).add(vertexToPosition);
	}

	/**
	 * <p>
	 * Finds positions of neighbors for this vertex position.
	 * </p>
	 *
	 * @param vertexPosition the position of vertex to get neighbors positions for
	 * @throws NoSuchElementException    if there is no such vertex in the graph
	 * @throws IndexOutOfBoundsException if the position is out of range
	 * @return List<Integer> with positions of neighbors for this vertex position
	 */
	public List<Integer> getNeighborPositionsFor(int vertexPosition) {
		if (exists(vertices.get(vertexPosition))) {
			return neighborPositions.get(vertexPosition);
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * <p>
	 * Finds vertex by its position.
	 * </p>
	 *
	 * @param vertexPosition the position of vertex to find
	 * @throws NoSuchElementException    if there is no such vertex in the graph
	 * @throws IndexOutOfBoundsException if the position is out of range
	 * @return vertex value for this vertex position
	 */
	public T getVertexAt(int vertexPosition) {
		if (exists(vertices.get(vertexPosition))) {
			return vertices.get(vertexPosition);
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * <p>
	 * Finds position of vertex.
	 * </p>
	 *
	 * @param vertex the vertex to find position for
	 * @return  vertex position for this vertex value;
	 *         -1 if there is no such vertex in graph
	 */
	public int getPositionOf(T vertex) {
		return vertices.indexOf(vertex);
	}

	/**
	 * <p>
	 * Gets the number of vertices in graph.
	 * </p>
	 *
	 * @return the number of vertices in graph
	 */
	public int numberOfVertices() {
		return numberOfVertices;
	}

	/**
	 * <p>
	 * Checks whether graph is empty.
	 * </p>
	 *
	 * @return true if there is no vertices in graph; false otherwise
	 */
	public boolean isEmpty() {
		return numberOfVertices == 0;
	}
}
