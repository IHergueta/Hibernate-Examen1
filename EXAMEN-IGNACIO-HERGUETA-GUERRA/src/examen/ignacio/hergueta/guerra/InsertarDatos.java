/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.ignacio.hergueta.guerra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Ignacio
 */
public class InsertarDatos {
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
    
     
                String url = "jdbc:mysql://localhost:3307/ignacio-herguetaguerra" + "?useUnicode=true" + "&serverTimezone=UTC";
		
		//guardamos el nombre de nuestro driver
		String nombreDriver = "com.mysql.cj.jdbc.Driver";
		
		//creamos la conexion
		Connection con = null; 
		
		//inizializamos la contraseña y usuario de nuestra base de datos
		String user = "ignacio";
		
		String pass = "examen1";
                
                try {
			
			//cargar driver
			Class.forName(nombreDriver);
			
			//cargar conexion pasandole la url el usuario y la contraseña
			con = DriverManager.getConnection(url,user,pass);
			
			//creamos un statemnet con la conexion anterior
			con.createStatement();	
                        
                        Scanner sc = new Scanner(System.in);
                        
                        System.out.println("Dime el nombre del cargo");
                        String nombre=sc.nextLine();
                        
                        System.out.println("Dime el sueldo minimo");
                        
                        int min=sc.nextInt();
                        
                        System.out.println("Dime el sueldo maximo");
                         
                        int max=sc.nextInt();
                        
                      
                        
                        PreparedStatement rs = con.prepareStatement("Select count(idcargo) from cargo ");
                        PreparedStatement ps = con.prepareStatement("Insert into cargo values(?,?,?,?)");
					
                        ResultSet ss = rs.executeQuery();
					
					
                        int id_cargo=0;	
			while(ss.next()){
						
                            id_cargo=ss.getInt(1) +1;
                            
						
			}
                        
                        String id;
                        id="C"+id_cargo;
                        
                        ps.setString(1, id);
                        ps.setString(2, nombre);
                        ps.setInt(3, min);
                        ps.setInt(4, max);
                        
                        int result = ps.executeUpdate();
                        if(result== 0) {
			
			System.out.println("Algo ha ido mal");
			
		}else {
			
			System.out.println("Insertado correctamente");
			
		}
		
		ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
                               
                           
                
		
		con.close();
		
}
          
    
}
