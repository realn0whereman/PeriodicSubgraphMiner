package com.pseminer.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.pseminer.containers.Graph;

public class Driver {
	private static final String delimiter = "=====";
	
	public static void main(String[] args){
		Driver d = new Driver();
		Graph[] timesteps = null;
		try {
			timesteps = d.loadInput("./inputGraphs");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Graph g:timesteps){
			System.out.println(g.toString());
		}
	}
	
	public Graph[] loadInput(String filename) throws FileNotFoundException{
		ArrayList<Graph> parseInput = new ArrayList<Graph>();
		File inputFile = new File(filename);
		Scanner scanner = new Scanner(new FileReader(inputFile));
		Graph parsedGraph = new Graph();
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			if(line.equals(delimiter)){
				parseInput.add(parsedGraph);
				parsedGraph = new Graph();
			} else {
				String[] splitParts = line.split(",");
				parsedGraph.addEdge(splitParts[0], splitParts[1]);
			}
			
		}
		
		return parseInput.toArray(new Graph[2]);
	}
}
