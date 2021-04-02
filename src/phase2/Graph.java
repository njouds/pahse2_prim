
package phase2;

import java.util.LinkedList;



public class Graph {
    
    
    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge(int source,int destination,int weight) {
            this.source = source;
            this.weight = weight;
            this.destination = destination;
        }

        @Override
       public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    }
   
int vertices;
LinkedList<Edge> adjacencyList[];
    
    Graph(int vertices) {//take the number of vertices in graph
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices]; //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }
    
    public boolean existEdge(int u, int v){
        
        for (int i = 0; i < this.adjacencyList[u].size(); i++)
    {
        if (this.adjacencyList[u].get(i).destination == v)
        {
            return true;
            
        }
        
    }
        return false;
    }
    public void addEgde(int source, int destination, int weight) {//adding edges to vertices 
            Edge edge = new Edge(source, destination, weight);//create new edge object
            adjacencyList[source].add(edge); //add the edge to the source
            adjacencyList[destination].add(new Edge(destination,source , weight));//and since its an undirected graph add the edge to the destination also
        }
    
    
     public void printGraph(){//printing the graph
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencyList[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex " + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    
}