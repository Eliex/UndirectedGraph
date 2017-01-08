// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program implements the queue data structure
// 
// ======================================================

package datastructures;

public class Queue<QueueDataType> {
    private SNode<QueueDataType> m_head;
    private SNode<QueueDataType> m_tail;
    
    // ==================================================
    // Constructor
    
    public Queue(){
        m_head = m_tail = null;
    }
    
    // ==================================================
    // Queue Functions
    
    public void Enqueue(QueueDataType p_data){
        if(m_head == null)
            m_head = m_tail = new SNode(p_data);
        else{
            m_tail.SetNextNode(new SNode(p_data));
            m_tail = m_tail.GetNextNode();
        }
    }
    
    public void Dequeue(){
        if(m_tail != null){
            if(m_head.GetNextNode() == null)
                m_head = m_tail = null;
            else
                m_head = m_head.GetNextNode();
        }  
    }
    
    public QueueDataType Front(){
        return m_head.GetData();
    }
    
    public boolean IsEmpty(){
        return (m_tail == null);
    }
   
}
