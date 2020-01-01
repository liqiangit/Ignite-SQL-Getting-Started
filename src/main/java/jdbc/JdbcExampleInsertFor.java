package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcExampleInsertFor {
	// 100000ºÄÊ±35719

    public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

        System.out.println("JDBC example started.");

        // Register JDBC driver
        Class.forName("org.apache.ignite.IgniteJdbcDriver");

        // Open JDBC connection
        Connection conn = DriverManager.getConnection(
                "jdbc:ignite:thin://127.0.0.1/");
        // Populate city table
        try (PreparedStatement stmt =
                     conn.prepareStatement("INSERT INTO city (id, name) VALUES (?, ?)")) {
        	for (long i = 0; i < 100000; i++) {
            stmt.setLong(1, i);
            stmt.setString(2, "Forest Hill");
            stmt.executeUpdate();
        	}
        }

        System.out.println("Populated data.");
		System.out.println(System.currentTimeMillis() - start);
		Thread.sleep(Integer.MAX_VALUE);
    }
}
