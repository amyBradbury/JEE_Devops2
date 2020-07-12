/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import modele.PurchaseOrder;

/**
 *
 * @author jorda
 */
public class resultatRequetePurchaseOrder implements Serializable {
    
 public List result;
    private List purchaseOrders;
    private PurchaseOrder purchaseOrder;
    
   public resultatRequetePurchaseOrder() {}
    
    public List getResult() {
        return result;
    }
    public List getPurchaseOrders(){
        return purchaseOrders;
    }
     public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
     public void setResult (List value)throws SQLException {
        result=value;
    }
    public void setPurchaseOrders (List value)throws SQLException {
        purchaseOrders=value;
    }
    public void setPurchaseOrder (Object value)throws SQLException {
        purchaseOrder=(PurchaseOrder)value;
    }
    
}
