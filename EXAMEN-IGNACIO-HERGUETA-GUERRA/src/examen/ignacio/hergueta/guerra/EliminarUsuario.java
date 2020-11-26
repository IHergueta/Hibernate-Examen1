/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.ignacio.hergueta.guerra;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import singleton.HibernateUtil;

/**
 *
 * @author Ignacio
 */
public class EliminarUsuario {
    
     public static void main(String[] args) {
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
      
        Scanner sc = new Scanner(System.in);
        
         Query query = session.createQuery("Select u from Usuario u");
         
         List<Usuario> usuarios = query.list();

         Usuario usuario= new Usuario();
         
         System.out.println("Dime el usuario");
         String nombre = sc.nextLine();
         
         for(Usuario u : usuarios){
             
             if(u.getUsuario().equals(nombre)){
                 usuario=u;
                
             }
             
         }
         
         session.delete(usuario);
         
         trans.commit();
         
         trans = session.beginTransaction();
         
         session.delete(usuario.getEmpleado());
         
         trans.commit();
         
         trans = session.beginTransaction();
         
         session.delete(usuario.getEmpleado().getCargo());
         
         trans.commit();
        
         
     }
    
}
