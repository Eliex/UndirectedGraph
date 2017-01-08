// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements the doubly iterator object.
// It iterates over a doubly linkedlist.
//
// ======================================================

package datastructures;

public class DIterator<DataType>{
    private DNode<DataType> m_starting_node;
    private DNode<DataType> m_iterator;
    
    // ==================================================
    // Constructor
    
    public DIterator(DNode<DataType> p_start_node){
        m_starting_node = m_iterator = p_start_node;
    }
    
    public DIterator(DIterator<DataType> p_iterator){
        m_starting_node = p_iterator.GetStartNode();
        m_iterator = p_iterator.GetNode();
    }
    
    // ==================================================
    // Doubly Iterator Functions
    
    public void Start(){
        m_iterator = m_starting_node;
    }
    
    public void Reset(DNode<DataType> p_start_node){
        m_starting_node = p_start_node;
    }
    
    public void Forth(){
        m_iterator = m_iterator.GetNextNode();
    }
    
    public void Back(){
        m_iterator = m_iterator.GetPrevNode();
    }
    
    public DNode<DataType> GetStartNode(){
        return m_starting_node;
    }
    
    public DataType GetItem(){
        return m_iterator.GetData();
    }
    
    public DNode<DataType> GetNode(){
        return m_iterator;
    }
    
    public boolean Valid(){
        return (m_iterator != null);
    }
}
