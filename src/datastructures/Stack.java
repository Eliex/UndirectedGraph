// Developer:
// ======================================================
// 
// Date Created: December 28,2013
// 
// Program Description:
//      This program implements the stack data structure
//
// ======================================================

package datastructures;

public class Stack<StackDataType> {
   private DNode<StackDataType> m_head;
   private DNode<StackDataType> m_tail;
   
   // ===================================================
   // Constructor
   
   public Stack(){
       m_head = m_tail = null;
   }
   
   // ===================================================
   // Stack Functions
   
   // Adds an element into the stack
   public void Push(StackDataType p_data){
       if(m_tail == null)
           m_head = m_tail = new DNode(p_data);
       else{
           m_tail.SetNextNode(new DNode(p_data));
           m_tail.GetNextNode().SetPrevNode(m_tail);
           m_tail = m_tail.GetNextNode();
       }
   }
   
   // Removes an element from the stack
   public void Pop(){
       if(m_head != null){
           if(m_tail.GetPrevNode() == null)
               m_head = m_tail = null;
           else{
               m_tail = m_tail.GetPrevNode();
               m_tail.SetNextNode(null);
           }
       }
   }
   
   // Returns the top element of the stack
   public StackDataType Top(){
       return m_tail.GetData();
   }
   
   public boolean IsEmpty(){
       return (m_head == null);
   }
   
}
