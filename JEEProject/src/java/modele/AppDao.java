/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import Utils.HibernateSession;
import org.hibernate.*;
import java.util.*;
/**
 *
 * @author jorda
 */
public class AppDao {
    
    private Session _session = null;
    
    public AppDao(){
     this._session = HibernateSession.GetSession().openSession();
    }
    public List GetCustomers()
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush(); //Vider la session
            Query requete = _session.createQuery("from Customer");
            resultat = requete.list();
            for(Object item : requete.list())
            {
                resultat.add((Customer) item);
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
    
     public List DeleteCustomer(String idToDelete)
    {
        List resultat=null;
        Transaction transact =null;
        
        try
        {
            if(!_session.isOpen())_session=HibernateSession.GetSession().openSession();
            _session.flush();
            transact = _session.beginTransaction();
            Query requete = _session.createQuery("delete PurchaseOrder where customer_id="+idToDelete);
            requete.executeUpdate();    
            requete = _session.createQuery("delete Customer where customer_id="+idToDelete);
            requete.executeUpdate();
//            resultat = requete.list();
            
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
    
}
