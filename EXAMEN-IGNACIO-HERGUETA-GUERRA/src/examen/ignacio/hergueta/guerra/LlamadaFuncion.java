/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.ignacio.hergueta.guerra;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author Ignacio
 */
public class LlamadaFuncion {
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
                
                String call = "{ ?=call salario_maximo() }";
                
                try {
			
			//cargar driver
			Class.forName(nombreDriver);
			
			//cargar conexion pasandole la url el usuario y la contraseña
			con = DriverManager.getConnection(url,user,pass);
			
			//creamos un statemnet con la conexion anterior
			con.createStatement();	
                      
                        
                        CallableStatement cs = con.prepareCall(call);
			
			//meto los ?
			cs.registerOutParameter(1,Types.VARCHAR);
			
			
			
			//la ejecuto
			ResultSet rs= cs.executeQuery();
			
			while(rs.next()){
				
                                System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
                               
}
}
