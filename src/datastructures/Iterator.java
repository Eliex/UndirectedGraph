// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements the iterator object. It
// iterates over the singly linkedlist.
//
// ======================================================

package datastructures;

public class Iterator<DataType> {
    private SNode<DataType> m_starting_node;
    private SNode<DataType> m_iterator;
    
    // ==================================================
    // Constructor
    
    public Iterator(SNode<DataType> p_start_node){
        m_starting_node = m_iterator = p_start_node;
    }
    
    // ==================================================
    // Iterator Functions
    
    public void Start(){
        m_iterator = m_starting_node;
    }
    
    public void Reset(DNode<DataType> p_start_node){
        m_starting_node = p_start_node;
    }
    
    public void Forth(){
        m_iterator = m_iterator.GetNextNode();
    }
    
    public DataType GetItem(){
        return m_iterator.GetData();
    }
    
    public SNode<DataType> GetNode(){
        return m_iterator;
    }
    
    public boolean Valid(){
        return (m_iterator != null);
    }
}
