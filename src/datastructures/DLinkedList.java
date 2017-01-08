// Developer:
// ======================================================
// 
// Date Created: December 28,2013
// 
// Program Description:
//      This program implements the doubly linkedlist data
// structure
//
// ======================================================

package datastructures;

public class DLinkedList<DataType> {
    private DNode<DataType> m_head;
    private DNode<DataType> m_tail;
    private DLinkedList<DIterator<DataType>> m_iterators;
    private int m_size;
    
    // ==================================================
    // Constructor
    
    public DLinkedList(){
        m_head = m_tail = null;
        m_iterators = null;
        m_size = 0;
    }
    
    // ==================================================
    // Doubly LinkedList Functions
    
    public DIterator<DataType> GetLinkedIterator(){
        DIterator<DataType> iterator = new DIterator(m_head);
        if(m_iterators == null)
            m_iterators = new DLinkedList();
        m_iterators.Append(iterator);
        return iterator;
    }
    
    public DIterator<DataType> GetUnLinkedIterator(){
        return new DIterator(m_head);
    }
    
    public void UnlinkIterator(DIterator<DataType> iterator){
        DIterator<DIterator<DataType>> iterators_iterator = m_iterators.GetUnLinkedIterator();
        
        while(iterators_iterator.Valid()){
            if(iterators_iterator.GetItem() == iterator){
                m_iterators.Remove(iterators_iterator);
                break;
            }
           iterators_iterator.Forth();
        }
    }
    
    public int GetListSize(){
        return m_size;
    }
    
    public void Append(DataType p_data){
        if(m_tail == null){
            m_head = m_tail = new DNode(p_data);
            UpdateIterators();
        }
        else{
            m_tail.SetNextNode(new DNode(p_data));
            m_tail.GetNextNode().SetPrevNode(m_tail);
            m_tail = m_tail.GetNextNode();
        }
        m_size++;
    }
    
    public void Prepend(DataType p_data){
        if(m_head == null)
            m_head = m_tail = new DNode(p_data);
        else{
            m_head.SetPrevNode(new DNode(p_data));
            m_head.GetPrevNode().SetNextNode(m_head);
            m_head = m_head.GetPrevNode();
        }
        UpdateIterators();
        m_size++;
    }
    
    public void Insert(DataType p_data, DIterator<DataType> p_current_iterator_state){
        if(!p_current_iterator_state.Valid())
            return;
        if(p_current_iterator_state.GetNode() == m_head){
            Prepend(p_data);
            return;
        }
        
        DNode<DataType> node = new DNode(p_data);
        DNode<DataType> iterator_node = p_current_iterator_state.GetNode();
        
        node.SetNextNode(iterator_node);
        node.SetPrevNode(iterator_node.GetPrevNode());
        node.GetPrevNode().SetNextNode(node);
        iterator_node.SetPrevNode(node);
        
        m_size++;
    }
    
    public void RemoveHead(){
        if(m_head == null)
            return;
        m_size--;
        if(m_head == m_tail)
            m_head = m_tail = null;
        else{
            m_head = m_head.GetNextNode();
            m_head.SetPrevNode(null);
        }
        UpdateIterators();
    }
    
    public void RemoveTail(){
        if(m_tail == null)
            return;
        m_size--;
        if(m_head == m_tail){
            m_head = m_tail = null;
            UpdateIterators();
            return;
        }
        m_tail = m_tail.GetPrevNode();
        m_tail.SetNextNode(null);
    }
    
    public void Remove(DataType p_element){
        if(m_head == null)
            return;
        DIterator<DataType> iterator = GetUnLinkedIterator();
        while(iterator.GetItem() != p_element)
            iterator.Forth();
        Remove(iterator);
    }
    
    public void Remove(DIterator<DataType> p_current_iterator_state){
        if(!p_current_iterator_state.Valid())
            return;
        if(p_current_iterator_state.GetNode() == m_head){
            RemoveHead();
            return;
        }
        if(p_current_iterator_state.GetNode() == m_tail){
            RemoveTail();
            if(m_tail != null)
                p_current_iterator_state.Back();
            return;
        }
        
        DNode<DataType> iterator_node = p_current_iterator_state.GetNode();
        
        iterator_node.GetPrevNode().SetNextNode(iterator_node.GetNextNode());
        iterator_node.GetNextNode().SetPrevNode(iterator_node.GetPrevNode());
        
        p_current_iterator_state.Forth();
        m_size--;
    }
    
    private void UpdateIterators(){
        if(m_iterators == null)
            return;
        DIterator<DIterator<DataType>> iterator = m_iterators.GetUnLinkedIterator();
        
        while(iterator.Valid()){
            iterator.GetItem().Reset(m_head);
            iterator.GetItem().Start();
            iterator.Forth();
        }
    }
}
