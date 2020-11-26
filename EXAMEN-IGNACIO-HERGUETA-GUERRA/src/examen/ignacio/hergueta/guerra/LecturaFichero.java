/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.ignacio.hergueta.guerra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ignacio
 */
public class LecturaFichero {
      public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
        // TODO code application logic here
          
          //instancio la direccion
		String dir="./src/resource/RecursosHumanos.sql";
		
		//Creo el archivo de lectura
		FileReader f2 = new FileReader(dir);
		//creo el buffer de lectura
		BufferedReader lector = new BufferedReader(f2);
                
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
                        String linea;
                        while((linea = lector.readLine()) != null) {
                            if(linea.charAt(0)=='-'){
                                 
                            }else{
                                
                                if(linea.endsWith(";")){
                                    
                                    //System.out.println(linea);
                                    con.createStatement().execute(linea);
                                    System.out.println("Insertado correctamente");
                                    
                                }else{
                                            
                                        String linea2;
                                        linea2=linea;
                                        if((linea=lector.readLine())!=null){
                                            String exec;
                                            exec=linea2+linea;
                                           // System.out.println(exec);
                                            con.createStatement().execute(exec);
                                            System.out.println("Insertado correctamente");
                                     }
                                }
                            }
                                    
                        }
                        System.out.print("Filas introducidas -> " + con.createStatement().getUpdateCount());
                       
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
                               
                
		f2.close();
		lector.close();
		con.close();
		
		
                }



    
}
