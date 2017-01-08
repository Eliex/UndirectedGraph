// Developer:
// ======================================================
// 
// Date Created: December 28,2013
// 
// Program Description:
//      This program implements the vertex object.
//
// ======================================================

package ugraph;
import datastructures.DLinkedList;
import datastructures.DIterator;
import datastructures.DataHolder;

public class Vertex<VertexDataType,EdgeDataType> extends DataHolder<VertexDataType>{
    private DLinkedList<Vertex<VertexDataType,EdgeDataType>> m_adjacent_vertices;
    private DLinkedList<Edge<VertexDataType,EdgeDataType>> m_adjacent_edges;
    private DIterator<Vertex<VertexDataType,EdgeDataType>> m_adjacent_vertices_iterator;
    private DIterator<Edge<VertexDataType,EdgeDataType>> m_adjacent_edges_iterator;
   
    // ==================================================
    // Constructor
    
    public Vertex(){
        super();
        m_adjacent_vertices = null;
        m_adjacent_edges = null;
    }
    
    public Vertex(VertexDataType p_vertex_name){
        super(p_vertex_name);
        m_adjacent_vertices = null;
        m_adjacent_edges = null;
    }
    
    public Vertex(Vertex<VertexDataType,EdgeDataType> p_vertex){
        super(p_vertex.GetData());
        m_adjacent_vertices = null;
        m_adjacent_edges = null;
    }
    
    // ==================================================
    // Other Functions
    
    public void ConnectTo(Vertex<VertexDataType,EdgeDataType> p_vertex, Edge<VertexDataType,EdgeDataType> p_edge){
        if(m_adjacent_vertices == null){
            m_adjacent_vertices = new DLinkedList();
            m_adjacent_edges = new DLinkedList();
            m_adjacent_vertices_iterator = m_adjacent_vertices.GetLinkedIterator();
            m_adjacent_edges_iterator = m_adjacent_edges.GetLinkedIterator();
        }
        m_adjacent_vertices.Append(p_vertex);
        m_adjacent_edges.Append(p_edge);
    }
    
    public Edge<VertexDataType,EdgeDataType> RemoveVertex(Vertex<VertexDataType,EdgeDataType> p_vertex){
        DIterator<Vertex<VertexDataType,EdgeDataType>> vertex_iterator = m_adjacent_vertices.GetUnLinkedIterator();
        DIterator<Edge<VertexDataType,EdgeDataType>> edge_iterator = m_adjacent_edges.GetUnLinkedIterator();
        
        vertex_iterator.Start();
        edge_iterator.Start();
        while(vertex_iterator.GetItem() != p_vertex){
            vertex_iterator.Forth();
            edge_iterator.Forth();
        }
        
        m_adjacent_vertices.Remove(vertex_iterator);
        m_adjacent_edges.Remove(edge_iterator);
        
        return edge_iterator.GetItem();
    }
    
    public Vertex<VertexDataType,EdgeDataType> GetCurrentNeighborVertex(){
        return m_adjacent_vertices_iterator.GetItem();
    }
    
    public Edge<VertexDataType,EdgeDataType> GetCurrentNeighborEdge(){
        return m_adjacent_edges_iterator.GetItem();
    }
    
    public void NextNeighbor(){
        m_adjacent_vertices_iterator.Forth();
        m_adjacent_edges_iterator.Forth();
    }
    
    public void StartingNeighbor(){
        m_adjacent_vertices_iterator.Start();
        m_adjacent_edges_iterator.Start();
    }
    
    public boolean ValidNeighbor(){
        return m_adjacent_vertices_iterator.Valid();
    }
    
    public boolean IsConnectedTo(Vertex<VertexDataType,EdgeDataType> p_vertex){
        DIterator<Vertex<VertexDataType,EdgeDataType>> iterator = m_adjacent_vertices.GetUnLinkedIterator();
        
        while(iterator.Valid()){
            if(iterator.GetItem() == p_vertex)
                return true;
            iterator.Forth();
        }
        return false;
    }
}
