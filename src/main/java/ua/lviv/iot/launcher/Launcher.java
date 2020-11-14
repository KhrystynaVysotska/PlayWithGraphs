package ua.lviv.iot.launcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import ua.lviv.iot.graph.OrientedGraph;
import ua.lviv.iot.searcher.OptimalSequenceSearcher;

public class Launcher {
	public static void main(String[] args) throws IOException {
		String inputFileName = args[0];
		String outputFileName = args[1];
		Scanner scanner = new Scanner(new File(inputFileName));
		OrientedGraph<String> graph = new OrientedGraph<>();

		while (scanner.hasNext()) {
			graph.addEdge(scanner.next(), scanner.next());
		}

		OptimalSequenceSearcher optimalSequenceSearcher = new OptimalSequenceSearcher();
		List<String> optimalSequence = optimalSequenceSearcher.findOptimalSequenceFor(graph);

		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
		for (String document : optimalSequence) {
			writer.write(document + "\n");
		}
		writer.close();
	}
}
