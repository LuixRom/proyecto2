import java.sql.Connection;
import java.sql.PreparedStatement;

public class Seeder {

    public static Connection waitForConnection() {
        int tries = 0;
        while (tries < 10) {
            try {
                Connection conn = DBconnection.connect();
                if (conn != null) return conn;
                Thread.sleep(3000);
            } catch (Exception ignored) {}
            tries++;
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = waitForConnection();
        if (conn == null) return;

        waitForTable(conn);

        try {
            String sql = "INSERT INTO products (name, category_id, supplier_id) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 20000; i++) {
                ps.setString(1, "Product " + i);
                ps.setInt(2, (i % 100) + 1);
                ps.setInt(3, (i % 100) + 1);
                ps.executeUpdate();
            }

            System.out.println("Se insertaron 20000 productos correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

