// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements the edge object that connects
// two vertices in a graph
//
// ======================================================

package ugraph;
import datastructures.DataHolder;

public class Edge<VertexDataType,EdgeDataType> extends DataHolder<EdgeDataType>{
    private Vertex<VertexDataType,EdgeDataType> m_endpoint_one;
    private Vertex<VertexDataType,EdgeDataType> m_endpoint_two;
    
    // ==================================================
    // Constructors
    
    public Edge(){
        super();
        m_endpoint_one = m_endpoint_two = null;
    }
    
    public Edge(EdgeDataType p_edge_weight){
        super(p_edge_weight);
        m_endpoint_one = m_endpoint_two = null;
    }
    
    public Edge(Edge<VertexDataType,EdgeDataType> p_edge){
        super(p_edge.GetData());
        m_endpoint_one = m_endpoint_two = null;
    }
    
    // ==================================================
    // Other Functions
    
    public void AddEndpoints(Vertex<VertexDataType,EdgeDataType> p_vertex_one, Vertex<VertexDataType,EdgeDataType> p_vertex_two){
        m_endpoint_one = p_vertex_one;
        m_endpoint_two = p_vertex_two;
    }
    
    public Vertex<VertexDataType,EdgeDataType> GetEndPointOne(){
        return m_endpoint_one;
    }
    
    public Vertex<VertexDataType,EdgeDataType> GetEndPointTwo(){
        return m_endpoint_two;
    }
    
}
