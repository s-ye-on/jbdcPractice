package jdbcjava;

import java.sql.SQLException;

public class Main {
    public static void main(String [] args){
        ConnectionJdbc jdbcConnection = new ConnectionJdbc();
        jdbcConnection.connect();

        UserDAO userDAO = new UserDAO();
        userDAO.setConnection(jdbcConnection.getConnection());

        try{
            User newUser = new User(0,"Alice","alice@naver.com");
            userDAO.insert(newUser);

            User user = userDAO.findById(1);
            System.out.println("User 존재:" + user.getName());
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            jdbcConnection.disconnect();
        }
    }
}
