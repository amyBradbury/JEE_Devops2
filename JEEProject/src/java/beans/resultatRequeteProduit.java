/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import modele.Product;

/**
 *
 * @author jorda
 */
public class resultatRequeteProduit implements Serializable {
    
    public List result;
    private List produits;
    private Product produit;
    
   public resultatRequeteProduit() {}
    
    public List getResult() {
        return result;
    }
    public List getProducts(){
        return produits;
    }
     public Product getClient() {
        return produit;
    }
     public void setResult (List value)throws SQLException {
        result=value;
    }
    public void setProducts (List value)throws SQLException {
        produits=value;
    }
    public void setProduct (Object value)throws SQLException {
        produit=(Product)value;
    }
}
