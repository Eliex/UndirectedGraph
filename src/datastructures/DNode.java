// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements a node object that holds
// a data and points to a next node object and previous
// node object
//
// ======================================================

package datastructures;

public class DNode<DNodeDataType> extends SNode<DNodeDataType> {
    private DNode<DNodeDataType> m_prev_node;
    
    // ==================================================
    // Constructors
    
    public DNode(){
        super();
        m_prev_node = null;
    }
    
    public DNode(DNodeDataType p_data){
        super(p_data);
        m_prev_node = null;
    }
    
    public DNode(DNode<DNodeDataType> p_node){
        super(p_node.GetData());
        m_prev_node = null;
    }
    
    // ==================================================
    // Accessors
    
    public void SetPrevNode(DNode<DNodeDataType> p_prev_node){
        m_prev_node = p_prev_node;
    }
    
    public DNode<DNodeDataType> GetPrevNode(){
        return m_prev_node;
    }
    
    @Override
    public DNode<DNodeDataType> GetNextNode(){
        return (DNode<DNodeDataType>) super.GetNextNode();
    }
}
