// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements an undirected graph object
//
// ======================================================

package ugraph;
import datastructures.DLinkedList;
import datastructures.DIterator;
import datastructures.Stack;
import datastructures.Queue;

public class UGraph<VertexDataType,EdgeDataType> {
    private DLinkedList<Vertex<VertexDataType,EdgeDataType>> m_vertices;
    private DLinkedList<Edge<VertexDataType,EdgeDataType>> m_edges;
    private DIterator<Vertex<VertexDataType,EdgeDataType>> m_vertices_iterator;
    private DIterator<Edge<VertexDataType,EdgeDataType>> m_edges_iterator;
    private Vertex<VertexDataType,EdgeDataType> m_vertex_one;
    private Vertex<VertexDataType,EdgeDataType> m_vertex_two;
    private int m_number_of_vertices;
    
    // ==================================================
    // Constructors
    
    public UGraph(){
        m_vertices = null;
        m_edges = null;
        m_vertices_iterator = null;
        m_edges_iterator = null;
        m_number_of_vertices = 0;
        m_vertex_one = m_vertex_two = null;
    }
    
    public UGraph(UGraph<VertexDataType,EdgeDataType> p_graph){
        m_vertices = p_graph.GetVertices();
        m_edges = p_graph.GetEdges();
        m_vertices_iterator = m_vertices.GetLinkedIterator();
        m_edges_iterator = m_edges.GetLinkedIterator();
        m_number_of_vertices = p_graph.GetNumberOfVertices();
        m_vertex_one = m_vertex_two = null;
    }
    
    // ==================================================
    // Accessors
    
    public int GetNumberOfVertices(){
        return m_number_of_vertices;
    }
    
    public DLinkedList<Vertex<VertexDataType,EdgeDataType>> GetVertices(){
        return m_vertices;
    }
    
    public DLinkedList<Edge<VertexDataType,EdgeDataType>> GetEdges(){
        return m_edges;
    }
    
    // ==================================================
    // Graph Functions
    
    public void ConnectVertices(VertexDataType p_vertex_one, VertexDataType p_vertex_two, EdgeDataType p_edge_weight){
        Edge<VertexDataType,EdgeDataType> edge = new Edge(p_edge_weight);
        
        VerticesExist(p_vertex_one,p_vertex_two);
        
        if(m_vertices == null){
                m_vertices = new DLinkedList();
                m_edges = new DLinkedList();
                m_vertices_iterator = m_vertices.GetLinkedIterator();
                m_edges_iterator = m_edges.GetLinkedIterator();
        }
        
        m_edges.Append(edge);
        
        if(m_vertex_one == null){
            m_vertex_one = new Vertex(p_vertex_one);
            m_vertices.Append(m_vertex_one);
            m_number_of_vertices++;
        }
        if(m_vertex_two == null){
            m_vertex_two = new Vertex(p_vertex_two);
            m_vertices.Append(m_vertex_two);
            m_number_of_vertices++;
        }
        
        m_vertex_one.ConnectTo(m_vertex_two, edge);
        m_vertex_two.ConnectTo(m_vertex_one, edge);
        edge.AddEndpoints(m_vertex_one, m_vertex_two);
        
        m_vertex_one = m_vertex_two = null;
    }
    
    public void RemoveVertex(VertexDataType p_vertex){
        m_vertex_one = VertexExists(p_vertex);
        
        if(m_vertex_one == null)
            return;
        
        Queue<Vertex<VertexDataType,EdgeDataType>> neighbors = new Queue();
        Queue<Edge<VertexDataType,EdgeDataType>> edges = new Queue();
        
        // Collect neighbors
        m_vertex_one.StartingNeighbor();
        while(m_vertex_one.ValidNeighbor()){
            neighbors.Enqueue(m_vertex_one.GetCurrentNeighborVertex());
            m_vertex_one.NextNeighbor();
        }
        
        // Remove the target vertex from each neigbor's list
        while(!neighbors.IsEmpty()){
            edges.Enqueue(neighbors.Front().RemoveVertex(m_vertex_one));
            neighbors.Dequeue();
        }
        
        // Remove the vertex from the main list
        m_vertices.Remove(m_vertices_iterator);
        
        // Remove the edges involved with the target vertex
        while(!edges.IsEmpty()){
            m_edges.Remove(edges.Front());
            edges.Dequeue();
        }
        
        m_number_of_vertices--;
        m_vertex_one = null;
    }
    
    // This function uses DFS to print the Adjacency Matrix instead of using the list above
    // This function doesn't save the matrix
    public void PrintAdjacencyMatrix(){
        if(m_number_of_vertices == 0)
            return;
        
        m_vertices_iterator.Start();
        Vertex<VertexDataType,EdgeDataType> current_vertex = m_vertices_iterator.GetItem();
        DLinkedList<Vertex<VertexDataType,EdgeDataType>> visited_vertices = new DLinkedList();
        DIterator<Vertex<VertexDataType,EdgeDataType>> iterator = visited_vertices.GetLinkedIterator();
        Stack<Vertex<VertexDataType,EdgeDataType>> stack_of_vertices = new Stack();
        char[][] matrix = new char[m_number_of_vertices][m_number_of_vertices];
        int current_column,current_row;
        
        do{
            if(current_vertex != null ){
                stack_of_vertices.Push(current_vertex);
                visited_vertices.Append(current_vertex);
                iterator.Start();
                
                // update matrix table
                for(current_column = visited_vertices.GetListSize()-1,current_row = 0; current_row < visited_vertices.GetListSize(); current_row++, iterator.Forth()){
                    if(stack_of_vertices.Top() == iterator.GetItem()){
                        matrix[current_row][current_column] = '0';
                        matrix[current_column][current_row] = '0';
                    }
                    else if(stack_of_vertices.Top().IsConnectedTo(iterator.GetItem())){
                        matrix[current_row][current_column] = '1';
                        matrix[current_column][current_row] = '1';
                    }
                    else{
                        matrix[current_row][current_column] = ' ';
                        matrix[current_column][current_row] = ' ';
                    }
                }
            }
            else{
                stack_of_vertices.Pop();
                if(stack_of_vertices.IsEmpty())
                    break;
                else
                    current_vertex = stack_of_vertices.Top();
            }
            
           // Assign new value for current_vertex
            iterator.Start();
            current_vertex.StartingNeighbor();
            while(iterator.Valid()){ 
                if(current_vertex.ValidNeighbor()){
                    if(current_vertex.GetCurrentNeighborVertex() == iterator.GetItem()){
                        current_vertex.NextNeighbor();
                        if(current_vertex.ValidNeighbor()){
                            iterator.Start();
                            continue;
                        }
                        else{
                            current_vertex = null;
                            break;
                        }
                    }
                }
                else{
                    current_vertex = null;
                    break;
                }
               iterator.Forth();
            }
            
            if(current_vertex != null)
                current_vertex = current_vertex.GetCurrentNeighborVertex();
        }while(!stack_of_vertices.IsEmpty());
        
        // Print the matrix
       System.out.print("  ");
        for(iterator.Start(); iterator.Valid(); iterator.Forth())
            System.out.print(iterator.GetItem().GetData()+" ");
        System.out.println();
        
        iterator.Start();
        for(current_row = 0; current_row < m_number_of_vertices; current_row++, iterator.Forth()){
            System.out.print(iterator.GetItem().GetData()+" ");
            for(current_column = 0; current_column < m_number_of_vertices; current_column++)
                System.out.print(matrix[current_row][current_column] + " ");
            System.out.println();
        }
    }
    
    // ==================================================
    // Helper Functions
    
    private void VerticesExist(VertexDataType p_vertex_one, VertexDataType p_vertex_two){
        if(m_vertices == null)
            return;
        boolean vertex_one_set = false;
        boolean vertex_two_set = false;
        m_vertices_iterator.Start();
 
        while(m_vertices_iterator.Valid()){
            if(!vertex_one_set)
                if(m_vertices_iterator.GetItem().GetData() == p_vertex_one){
                    m_vertex_one = m_vertices_iterator.GetItem();
                    vertex_one_set = true;
                }
            if(!vertex_two_set)
                if(m_vertices_iterator.GetItem().GetData() == p_vertex_two){
                    m_vertex_two = m_vertices_iterator.GetItem();
                    vertex_two_set = true;
                }
            if(vertex_one_set && vertex_two_set)
                break;
            m_vertices_iterator.Forth();
        }
    }
    
    private Vertex<VertexDataType,EdgeDataType> VertexExists(VertexDataType p_vertex){
        if(m_vertices == null)
            return null;
        
        m_vertices_iterator.Start();
        m_edges_iterator.Start();
        
        while(m_vertices_iterator.Valid()){
            if(m_vertices_iterator.GetItem().GetData() == p_vertex)
                return m_vertices_iterator.GetItem();
            m_vertices_iterator.Forth();
            m_edges_iterator.Forth();
        }
        
        return null;
    }
}
