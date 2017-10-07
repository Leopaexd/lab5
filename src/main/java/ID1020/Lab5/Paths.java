package ID1020.Lab5;

import se.kth.id1020.Graph;

import java.util.ArrayList;

import se.kth.id1020.DataSource;
import se.kth.id1020.Edge;

public class Paths {
 public static void main(String[] args) {
 Graph g = DataSource.load();
 // work on g
 
 ArrayList<Integer>	marked = new ArrayList<Integer>(); //Used to keep track of visited vertices
 ArrayList<ArrayList<Integer>>	subGraphs = new ArrayList<ArrayList<Integer>>(); //Used to keep track of subgraphs
 
 for (int j = 0; j < g.numberOfVertices()-1; j++) { //Check if there are any vertices missing
	if (marked.contains(j) == false) {
		subGraphs.add(new ArrayList<Integer>());
		DepthFirstSearch(g, marked, j,subGraphs.get(subGraphs.size()-1)); 
	}
}
 
 for (int i = 0; i < subGraphs.size(); i++) {
	System.out.println("Subgraph: " + i + " " +subGraphs.get(i));
}
 
 System.out.println("Marked.size = " + marked.size() + " numberOfVertices = " + g.numberOfVertices());
 System.out.println("Number of subgraphs: " + subGraphs.size());
 }
 
 
//Depth-First Search, returns ArrayList of all vertices connected to input vertex
 public static void DepthFirstSearch (Graph g, ArrayList<Integer> marked, int current, ArrayList<Integer> subGraph) {
	 marked.add(current);
	 subGraph.add(current);
	 for (Edge edge : g.adj(current)) {
		 if(marked.contains(edge.to) == false) DepthFirstSearch(g, marked,edge.to, subGraph);
	 }
 }
}