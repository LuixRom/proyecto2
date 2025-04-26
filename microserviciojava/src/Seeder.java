import java.sql.Connection;
import java.sql.PreparedStatement;

public class Seeder {
    public static void main(String[] args) {
        Connection conn = DBconnection.connect();
        if (conn == null) return;

        try {
            String sql = "INSERT INTO product (name, category_id, supplier_id) VALUES (?, ?, ?)";
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
