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
import modele.ProductCode;

/**
 *
 * @author jorda
 */
public class resultatRequeteProductCode implements Serializable {
    
    public List result;
    private List productCodes;
    private ProductCode productCode;
    
   public resultatRequeteProductCode() {}
    
    public List getResult() {
        return result;
    }
    public List getProductCodes(){
        return productCodes;
    }
     public ProductCode getProductCode() {
        return productCode;
    }
     public void setResult (List value)throws SQLException {
        result=value;
    }
    public void setProductCodes (List value)throws SQLException {
        productCodes=value;
    }
    public void setProductCode (Object value)throws SQLException {
        productCode=(ProductCode)value;
    }
    
}
