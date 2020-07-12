/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import Utils.HibernateSession;
import java.math.BigDecimal;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
import java.sql.*;
/*
 *
 * @author jorda
 */
public class AppDao {
    
    Session _session = null;
    
    public AppDao(){
     this._session = HibernateSession.GetSession().openSession();
    }
    public List GetCustomers()
    {
        List resultat= null;
        List customerResult = new ArrayList<Customer>();
        try{
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
                Query q=_session.createQuery("from Customer");
           resultat=q.list();
           for(Object o :q.list())customerResult.add((Customer)o);
        }
        catch (Exception e) {
        e.printStackTrace();
        }
       finally{
          if (_session.isOpen())_session.close();
        }
    return resultat;
    }
    
     public List GetPurchaseOrders()
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Query requete = _session.createQuery("SELECT * FROM PURCHASE_ORDER");
            resultat = requete.list();
            for(Object item : requete.list())
            {
                resultat.add((PurchaseOrder) item);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return resultat;
    }
     
     public List GetProductCodes()
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Query requete = _session.createQuery("SELECT * FROM PRODUCT_CODE");
            resultat = requete.list();
            for(Object item : requete.list())
            {
                resultat.add((ProductCode) item);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return resultat;
    }
     
    public List GetProducts()
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Query requete = _session.createQuery("SELECT * FROM PRODUCT");
            resultat = requete.list();
            for(Object item : requete.list())
            {
                resultat.add((Product) item);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return resultat;
    }
    public List<PurchaseOrder> GetProductsOfCustomer(int id)
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Query requete = _session.createQuery("SELECT * FROM PURCHAS_ORDER as achats JOIN achats.customer a  WHERE a.customerId =:_id");
            requete.setInteger("_id", id);
            resultat =(List<PurchaseOrder>) requete.list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return resultat;
    }
    public boolean UpdateClient(String name,char discountCode,String addressLine1,String addressLine2,String city, String zip,String phone,String state,String email,String fax, int creditLimit,int id)
    {
        boolean isOk=false;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Customer customer = new Customer(id,discountCode,zip, name, addressLine1, addressLine2,city,state, phone, fax, email, creditLimit);
            _session.update(customer);
            transact.commit();
            isOk = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isOk = false;
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return isOk;
    }
    
    public boolean UpdateProduct(int productId, int manufacturerId, String productCode, BigDecimal purchaseCost, Integer quantityOnHand, BigDecimal markup, String available, String description)
    {
        boolean isOk=false;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Product product = new Product( productId,  manufacturerId,  productCode,  purchaseCost,  quantityOnHand,  markup,  available,  description);
            _session.update(product);
            transact.commit();
            isOk = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isOk = false;
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return isOk;
    }
    
    public boolean UpdatePurchaseOrder(int orderNum, int customerId, int productId, Short quantity, BigDecimal shippingCost, java.util.Date salesDate, java.util.Date shippingDate, String freightCompany)
    {
        boolean isOk=false;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            PurchaseOrder purchaseOrder = new PurchaseOrder( orderNum,  customerId,  productId,  quantity,  shippingCost,  salesDate,  shippingDate,  freightCompany);
            _session.update(purchaseOrder);
            transact.commit();
            isOk = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isOk = false;
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return isOk;
    }
     public boolean UpdateProductCode(String prodCode, char discountCode, String description)
    {
        boolean isOk=false;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            ProductCode productCode = new ProductCode( prodCode,  discountCode,  description);
            _session.update(productCode);
            transact.commit();
            isOk = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isOk = false;
        }
        finally
        {
            if(_session.isOpen()) _session.close();
        }
        return isOk;
    }
    
    
    
    
     public Customer DeleteCustomer(int id)
    {
        Customer client=null;
        
        try{
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            
            client = (Customer) _session.load(Customer.class, id);
            System.out.println("client :"+client.getName());
            _session.delete(client);
           
      }
       catch (Exception e) {
        
        e.printStackTrace();
        }
       finally{
          if (_session.isOpen())_session.close();
        }
      
    return client;
    }
     
     
    
}
