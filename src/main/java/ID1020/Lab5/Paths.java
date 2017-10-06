package ID1020.Lab5;

import se.kth.id1020.Graph;
import se.kth.id1020.Vertex;

import java.util.ArrayList;

import se.kth.id1020.DataSource;
import se.kth.id1020.Edge;

public class Paths {
 public static void main(String[] args) {
 Graph g = DataSource.load();
 // work on g
 
 ArrayList<Integer>	marked = new ArrayList<Integer>(); //Used to keep track of visited vertices
 
 System.out.println(DepthFirstSearch (g, marked, 0));
 }
 
//Depth-First Search, returns true if graph is connected, else returns false
 public static boolean DepthFirstSearch (Graph g, ArrayList<Integer> marked, int current) {
	 System.out.println(marked);
	 marked.add(current);
	 for (Edge edge : g.adj(current)) {
		 if(marked.contains(edge.to) == false) DepthFirstSearch(g, marked,edge.to);
	 }
	 if (marked.size() == g.numberOfVertices()) return true;
	 System.out.println("Marked.size = " + marked.size() + " numberOfVertices = " + g.numberOfVertices());
	 return false;
 }
}