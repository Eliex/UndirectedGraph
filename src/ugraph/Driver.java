// Developer:
// ======================================================
// 
// Date Created: December 28,2013
// 
// Program Description:
//      This is where testing of the graph happens
//
// ======================================================

package ugraph;

public class Driver {
    
    public static void main(String args[]){
        UGraph<Character,Integer> graph = new UGraph();
        
        graph.ConnectVertices('A','B',2);
        graph.ConnectVertices('B','C',1);
        graph.ConnectVertices('A','D',4);
        graph.ConnectVertices('B','E',1);
        graph.ConnectVertices('A','E',3);
        graph.ConnectVertices('C','D',1);
        graph.ConnectVertices('C','E',2);
        graph.ConnectVertices('D','F',2);
        graph.ConnectVertices('C','G',4);
        graph.ConnectVertices('G','H',3);
        graph.ConnectVertices('B','H',5);
        
        System.out.println("Adjacency Matrix:");
        System.out.println();
        graph.PrintAdjacencyMatrix();
        
        graph.RemoveVertex('C');
        graph.RemoveVertex('E');
        
        System.out.println();
        System.out.println("Adjacency Matrix:");
        System.out.println();
        graph.PrintAdjacencyMatrix();
    }
}
