package jdbcjava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/database";
    private static final String USER = "host";
    private static final String PASSWORD = "1234";

    private Connection connection = null;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("데이터베이스 연결");
        }catch(ClassNotFoundException e){
            System.out.println("JDBC Driver를 찾을 수 없음");
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("데이터베이스 연결 실패");
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("데이터베이스 연결해제 성공");
            }
        } catch(SQLException e){
            System.out.println("데이터베이스 연결해제 실패");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }

}
