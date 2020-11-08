package ua.lviv.iot.launcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import ua.lviv.iot.graph.Graph;
import ua.lviv.iot.searcher.Searcher;

public class Launcher {
	public static void main(String[] args) throws IOException {
		String inputFileName = args[0];
		String outputFileName = args[1];
		Scanner scanner = new Scanner(new File(inputFileName));
		Graph<String> graph = new Graph<>();
		while (scanner.hasNext()) {
			String firstCertificate = scanner.next();
			String secondCertificate = scanner.next();
			graph.addVertex(firstCertificate);
			graph.addVertex(secondCertificate);
			graph.addEdge(firstCertificate, secondCertificate);
		}
		Searcher searcher = new Searcher();
		List<String> optimalSequence = searcher.findOptimalSequenceFor(graph);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
		for (String certificate : optimalSequence) {
			writer.write(certificate + "\n");
		}
		writer.close();
	}
}
