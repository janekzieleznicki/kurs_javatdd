import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.sql.DataSource;

public class OsobaDAO {

    private DataSource ds;

    public OsobaDAO(DataSource ds) {
        this.ds = ds;

    }

    public void create(Osoba osoba) {
        Objects.requireNonNull(osoba);
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("INSERT INTO osoba (id, imie, nazwisko) values (?, ?, ?)");
            stmt.setInt(1, osoba.getId());
            stmt.setString(2, osoba.getImie());
            stmt.setString(3, osoba.getNazwisko());
            stmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }

    }

    public Osoba retrieve(int id) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("SELECT id, imie, nazwisko FROM osoby WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }
            Osoba o = new Osoba();
            o.setId(rs.getInt(1));
            o.setImie(rs.getString(2));
            o.setNazwisko(rs.getString(3));
            c.close();
            return o;
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return null;
    }

    public void update(Osoba osoba) {
        Objects.requireNonNull(osoba);

        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("UPDATE osoba SET imie=?, nazwisko=? WHERE id=?");
            stmt.setString(1, osoba.getImie());
            stmt.setString(2, osoba.getNazwisko());
            stmt.setInt(3, osoba.getId());
            stmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void delete(int id) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("DELETE FROM osoby WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}