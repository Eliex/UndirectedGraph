// Developer:
// ======================================================
// 
// Date Created: December 28,2013
// 
// Program Description:
//      This is where the testing of each data structure happens
//
// ======================================================

package datastructures;

public class Driver {
    
    public static void main(String args[]){
        DLinkedList<Integer> dlist = new DLinkedList();
        DIterator<Integer> iterator = dlist.GetLinkedIterator();
        DIterator<Integer> i2 = dlist.GetLinkedIterator();
        
        dlist.Append(1);
        dlist.Append(2);
        dlist.Append(3);
        dlist.Append(4);
        dlist.Prepend(5);
        dlist.Prepend(6);
        
        iterator.Start();
        i2.Start();
        while(iterator.Valid()){
            System.out.print(iterator.GetItem()+" ");
            iterator.Forth();
        }
        System.out.println();
        
        i2.Forth();
        while(i2.Valid()){
            System.out.print(i2.GetItem()+" ");
            i2.Forth();
        }
        
        System.out.println();
        dlist.RemoveHead();
        dlist.RemoveTail();

        iterator.Start();
        while(iterator.Valid()){
            System.out.print(iterator.GetItem()+" ");
            iterator.Forth();
        }
        System.out.println();
        iterator.Start();
        iterator.Forth();
        iterator.Forth();
        iterator.Forth();
        dlist.Remove(iterator);
        dlist.Remove(iterator);
        dlist.Remove(iterator);
     
        while(iterator.Valid()){
            System.out.print(iterator.GetItem()+" ");
            iterator.Forth();
        }
        
        while(i2.Valid()){
            System.out.print(i2.GetItem()+" ");
            i2.Forth();
        }
                
    }
    
}
