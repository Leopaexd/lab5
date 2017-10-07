package ID1020.Lab5;

import se.kth.id1020.Graph;
import se.kth.id1020.Vertex;

import java.util.ArrayList;

import se.kth.id1020.DataSource;
import se.kth.id1020.Edge;

public class ShortPaths {
 public static void main(String[] args) {
 Graph g = DataSource.load();
 // work on g
 
 int vertex1 = 0;
 int vertex2 = 32;
 
 for (Vertex v : g.vertices()) { 
	 if (v.label.equalsIgnoreCase("Parses")) vertex1 = v.id;
	 if (v.label.equalsIgnoreCase("Renyn")) vertex2 = v.id;
 }
 System.out.println(vertex1 + " " + vertex2);
 
 ArrayList<Integer> shortestPath = shortestPath(g,vertex1,vertex2, false);
 System.out.println("Shortest path: \n" + shortestPath +"\nNumber of components: " + shortestPath.size());

}
 
 //Implementation of Dijsktra's algorithm to find the shortest path between two nodes
 public static ArrayList<Integer> shortestPath (Graph g, int source, int target, boolean weight){
	 int size = g.numberOfVertices();
	 Vertex[] vertices = new Vertex[size];
	 double[] distance = new double[size] ;
	 int[] previous = new int[size] ;
	 double infinity = Double.POSITIVE_INFINITY;
	 int undefined = 9999999;
	 
	 for (Vertex v : g.vertices()) {
		 vertices[v.id] = v;
		 distance[v.id] = infinity;
		 previous[v.id] = undefined;
	 }
	 	 
	 distance[source] = 0;
	 
	 
	 while (size > 0) {
		 //loop that finds the vertex with the smallest distance
		 int smallest = 0;
		 for (int i = 0; i < distance.length; i++) {
			 if (vertices[smallest] == null) smallest++;
			 if ((distance[i] <= distance[smallest]) && vertices[i] != null ) {
				 smallest = i;
			 }
		 }
		
		 for (Edge edge : g.adj(smallest)) {
			 double alt = distance[smallest] + 1;
			 if (weight) alt = distance[smallest] + edge.weight;
			 if (alt <= distance[edge.to]) {
				 distance[edge.to] = alt;
				 previous[edge.to] = smallest;
			 } 
		 }
		 
		 
		 if (vertices[smallest] != null) {
			 if (vertices[smallest].id == target) break;
		 }
		 
		 vertices[smallest] = null;
		 size--;
	 }
	 
	 ArrayList<Integer> path = new ArrayList<Integer>();
	 int u = target;
	 while (previous[u] != undefined) {
		 path.add(0, u);
		 u = previous[u];
	 }
	 return path;
 }
}