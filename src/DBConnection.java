import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

        private static final String url="jdbc:mysql://localhost:3306/employees";
        private static final String user="root";
        private static final String password="JiloRamesh26";
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }
}
