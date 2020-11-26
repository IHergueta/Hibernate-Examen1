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
public class ModificarContrasena {
    
     public static void main(String[] args) {
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        
        Scanner sc = new Scanner(System.in);
        
         Usuario usuario;
         
         System.out.println("Dime el usuario");
         String nombre = sc.nextLine();
         
                 
         System.out.println("Dime la contraseña del usuario");
         String pass = sc.nextLine();
         
                
         System.out.println("Dime la nueva contraseña del usuario");
         String newpass = sc.nextLine();
         
         Query query = session.createQuery("Select u from Usuario u");
         
         List<Usuario> usuarios = query.list();
         
         for(Usuario u : usuarios){
             
             if(u.getUsuario().equals(nombre) && u.getClave().equals(pass)){
                 
                 usuario=u;
                 usuario.setClave(newpass);
                 session.update(usuario);
                 
                 trans.commit();
                 
                 System.out.println("La contraseña de " + usuario.getUsuario() + " ha sido cambiada a " + usuario.getClave());
                 
                 
             }
             
             
         }
         
     
        
        
     }
    
}
