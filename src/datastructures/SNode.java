// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Desciprtion:
//      This program is an implementation of a node object 
// that holds a data and points to a next node object
// 
// ======================================================

package datastructures;

public class SNode<SNodeDataType> extends DataHolder<SNodeDataType> {
    private SNode<SNodeDataType> m_next_node;
    
    // ==================================================
    // Constructors
    
    public SNode(){
        super();
        m_next_node = null;
    }
    
    public SNode(SNodeDataType p_data){
        super(p_data);
        m_next_node = null;
    } 
    
    public SNode(SNode<SNodeDataType> p_node){
        super(p_node.GetData());
        m_next_node = p_node.GetNextNode();
    }
    
    // ==================================================
    // Accessors
    
    public void SetNextNode(SNode<SNodeDataType> p_next_node){
        m_next_node = p_next_node;
    }
    
    public SNode<SNodeDataType> GetNextNode(){
        return m_next_node;
    }
}
