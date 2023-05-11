/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.db.clases;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;



/**
 *
 * @author marcosfa
 */
public class Conexion {
  private Connection conexion = null;
    String usuario="postgres";
    String contrasenha="postgres";
    String db="basedatos"; 
    String host="localhost";
    String puerto="5434";
    
    
    public Connection getConexion(){
        //procedemos a intentar la conexión con un try catch
        try {
            /*haremos referencia a un archivo de tipo class
            Este archivo se encuentra en el driver de Postgres que hemos importado (.jar) estará en la carpeta org.postgres
            puesto que esta es la ultima versión, y buscaremso el archivo Driver.class
            Asía indicaremos la ruta
            
            */
            String rutaDriver =  "org.postgresql.Driver";
            Class.forName(rutaDriver);
            //ahora procederemos a crear la url completa
            String cabecera = "jdbc:postgresql://";
            //la cabecera deberá llevar este orden: Cabecera +host : puerto/db sería como una url basica
           String url = cabecera + host + ":" + puerto + "/" + db + "?currentSchema=schemaUser1";
            //tras hacer esto debemos importar el driver manager que será el encargado de hacer la conexión
            //a este le indicaremos la url, el usuario y la contraseña
            conexion = DriverManager.getConnection(url,usuario,contrasenha);
            //lanzamos mensaje ok
            System.out.println("SE HA CONECTADO CORRECTAMENTE");
        } catch (Exception e) {
            MyException.conexionFallida();
        }
        return conexion;
    }
    
    public boolean tablaExiste(Connection conexion, String nombreTabla) {
    try {
        // Creamos un objeto DatabaseMetaData a partir de la conexión
        DatabaseMetaData metadata = conexion.getMetaData();
        
         // Obtener el esquema actual
        String currentSchema = conexion.getSchema();

            System.out.println("Esquema actual en metodo tabla existe: " + currentSchema);

        
        // Obtenemos la lista de tablas de la base de datos
        ResultSet rs = metadata.getTables(null, currentSchema, nombreTabla, null);
        
        // Si la tabla existe, rs.next() devolverá true
        
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public  void comprobarEstadoActual() throws SQLException{
    String query = "SELECT current_schema()";
Statement statement = conexion.createStatement();

ResultSet resultSet = statement.executeQuery(query);
resultSet.next();
String currentSchema = resultSet.getString(1);
System.out.println("Esquema actual: " + currentSchema);

}
    
    
    
    /**
     * Este metodo comprueba si hay una tabla ya creada, y si no la crea
     */
    public void crearTabla(){
        try {
            //primero creamos un objeto de tipo Statement, este tipo de Variables nos permitiran modificar o enviar codigo a nuestra base de datos.
            //en este objeto guardamos un statement que vamos a crear y obtenemos de conexion, nuestra variable de tipo Connection
            Statement statement = conexion.createStatement();
          
            comprobarEstadoActual();
            //si la tabla no existe la creamos
            if(!tablaExiste(conexion,"alumnosDAM")){
                System.out.println("Entré en el if");
               String query = "CREATE TABLE schemaUser1.alumnosDAM ("
        + "dni VARCHAR(10) PRIMARY KEY,"
        + "nombre VARCHAR(50),"
        + "primer_apellido VARCHAR(50),"
        + "segundo_apellido VARCHAR(50),"
        + "nota1 FLOAT,"
        + "nota2 FLOAT,"
        + "nota3 FLOAT,"
        + "MEDIA FLOAT"
        + ")";

                
                
                //una vez creada la tabla con todos los campos debemos mandarla a la base de datos con update
                
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "LA TABLA SE HA CREADO CORRECTAMENTE");
            }else{
                JOptionPane.showMessageDialog(null, "LA TABLA EXISTE");
            }
            
        } catch (SQLException e) {
             e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR AL CREAR LA TABLA");
            
        }
        
    }
    
    
    
    public void mostrarDatosTabla(String nombreTabla, javax.swing.JTable tabla) {
    try {
      

        // Obtener los datos de la tabla
        String query = "SELECT * FROM " + nombreTabla;
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Crear el modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel();

        // Obtener metadatos de la consulta
        int columnCount = resultSet.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(resultSet.getMetaData().getColumnLabel(i));
        }

        // Agregar filas a la tabla con los datos de la consulta
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(row);
        }

        // Asignar el modelo a la tabla
        tabla.setModel(tableModel);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la tabla");
    }
    
   
}

    
    
    
    
    public void insertarDatosTabla(String dni, String nombre, String primerApellido, String segundoApellido, float nota1, float nota2, float nota3, float media) {
    try {
        // Creamos un objeto de tipo PreparedStatement para construir la consulta parametrizada
        String query = "INSERT INTO schemaUser1.alumnosDAM (dni, nombre, primer_apellido, segundo_apellido, nota1, nota2, nota3, media) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        
        // Establecemos los valores de los parámetros en la consulta
        preparedStatement.setString(1, dni);
        preparedStatement.setString(2, nombre);
        preparedStatement.setString(3, primerApellido);
        preparedStatement.setString(4, segundoApellido);
        preparedStatement.setFloat(5, nota1);
        preparedStatement.setFloat(6, nota2);
        preparedStatement.setFloat(7, nota3);
        preparedStatement.setFloat(8, media);
        
        // Ejecutamos la consulta
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al insertar los datos");
    }
}
    
    
    public void eliminarFila(String dni) {
    try {
        // Creamos la consulta SQL para eliminar la fila
        String query = "DELETE FROM schemaUser1.alumnosDAM WHERE dni = ?";
        
        // Preparamos la sentencia SQL
        PreparedStatement statement = conexion.prepareStatement(query);
        
        // Establecemos los valores de los parámetros
        statement.setString(1, dni);
        
        // Ejecutamos la sentencia SQL
        int filasAfectadas = statement.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("La fila ha sido eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna fila con el DNI especificado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al eliminar la fila: " + e.getMessage());
    }
}

    
    
    public void modificarFila(String dni, String nombre, String apellido1, String apellido2, float nota1, float nota2, float nota3, float media) {
    try {
        // Creamos la consulta SQL para modificar la fila
        String query = "UPDATE schemaUser1.alumnosDAM SET nombre = ?, primer_apellido = ?, segundo_apellido = ?, nota1 = ?, nota2 = ?, nota3 = ?, media = ? WHERE dni = ?";
        
        // Preparamos la sentencia SQL
        PreparedStatement statement = conexion.prepareStatement(query);
        
        // Establecemos los valores de los parámetros
        statement.setString(1, nombre);
        statement.setString(2, apellido1);
        statement.setString(3, apellido2);
        statement.setFloat(4, nota1);
        statement.setFloat(5, nota2);
        statement.setFloat(6, nota3);
        statement.setFloat(7, media);
        statement.setString(8, dni);
        
        // Ejecutamos la sentencia SQL
        int filasAfectadas = statement.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("La fila ha sido modificada correctamente.");
        } else {
            System.out.println("No se encontró ninguna fila con el DNI especificado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al modificar la fila: " + e.getMessage());
    }
}


    
  
    
    
    
    
    
    
    
}
