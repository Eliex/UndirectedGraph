// Developer:
// ======================================================
// 
// Date Created: December 28,2013
//
// Program Description:
//      This program is an implementation of a data holder
// objects that just holds a data
//
// ======================================================

package datastructures;

public class DataHolder<DataType> {
    private DataType m_data;
    
    // ==================================================
    // Constructors 
    
    public DataHolder(){}
    
    public DataHolder(DataType p_data){
        m_data = p_data;
    }
    
    public DataHolder(DataHolder p_data_holder){
        m_data = (DataType) p_data_holder.GetData();
    }
    
    // ==================================================
    // Accessors 
    
    public void SetData(DataType p_data){
        m_data = p_data;
    }
    
    public DataType GetData(){
        return m_data;
    }
    
}
