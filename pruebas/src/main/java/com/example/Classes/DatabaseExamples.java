package com.example.Classes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class DatabaseExamples {

     // Ejemplo 1: Uso de CallableStatement para invocar un procedimiento almacenado
    public void executeCallableStatement() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

            // Llamada al procedimiento almacenado
            String sql = "{call insert_employee(?, ?, ?)}";
            callableStatement = connection.prepareCall(sql);
            
            // Establecemos los parámetros de entrada
            callableStatement.setString(1, "John Doe");
            callableStatement.setDouble(2, 5000.0);
            
            // Registro del parámetro de salida
            callableStatement.registerOutParameter(3, Types.INTEGER);
            
            // Ejecutamos el procedimiento
            callableStatement.execute();
            
            // Recuperamos el parámetro de salida (ID generado)
            int employeeId = callableStatement.getInt(3);
            System.out.println("Generated Employee ID: " + employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


     // Ejemplo 2: Ejecución de un bloque PL/SQL anónimo
    public void executeAnonymousPLSQL() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user", "password");

            // Bloque PL/SQL anónimo
            String plsql = "BEGIN "
                         + "   DECLARE "
                         + "      myVar VARCHAR2(50); "
                         + "   BEGIN "
                         + "      myVar := 'Hello, PL/SQL!'; "
                         + "      DBMS_OUTPUT.PUT_LINE(myVar); "
                         + "   END; "
                         + "END;";
                         
            // Crear el PreparedStatement
            preparedStatement = connection.prepareStatement(plsql);
            
            // Ejecutar el bloque PL/SQL
            preparedStatement.execute();
            
            System.out.println("PL/SQL block executed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Ejemplo 3: Uso de PreparedStatement con batch para insertar registros
    public void executeBatchInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");

            // SQL para insertar en la tabla "employees"
            String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            int batchSize = 500;
            int totalRecords = 5500;
            int count = 0;

            // Loop para insertar 5500 registros
            for (int i = 1; i <= totalRecords; i++) {
                // Establecemos los valores para cada registro
                preparedStatement.setString(1, "Employee_" + i);
                preparedStatement.setDouble(2, 3000.0 + (i * 100)); // Diferente salario para cada registro

                // Añadimos el insert al batch
                preparedStatement.addBatch();
                count++;

                // Ejecutamos el batch cada 500 registros
                if (count % batchSize == 0) {
                    preparedStatement.executeBatch();
                    connection.commit(); // Confirmamos los cambios
                    System.out.println("Inserted " + count + " records.");
                }
            }

            // Ejecutamos cualquier batch restante
            if (count % batchSize != 0) {
                preparedStatement.executeBatch();
                connection.commit(); // Confirmamos los cambios
                System.out.println("Inserted remaining " + (count % batchSize) + " records.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) connection.rollback(); // Rollback en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
