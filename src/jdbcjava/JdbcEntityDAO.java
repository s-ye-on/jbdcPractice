package jdbcjava;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface JdbcEntityDAO<T> {

    //엔티티 삽입 메서드
    void insert(T entity) throws SQLException;
    //엔티티 업데이트 메서드
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void setConnection(Connection connection);

}
