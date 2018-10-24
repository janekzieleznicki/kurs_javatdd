import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@Test
public class OsobaDAOTest {
    @Mock
    DataSource dataSource;
    @Mock
    Connection connection;

    @Mock
    PreparedStatement statement;

    @BeforeMethod
    void injectMocks() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(dataSource.getConnection()).thenReturn(connection);

        when(connection.prepareStatement("INSERT INTO osoba (id, imie, nazwisko) values (?, ?, ?)")).thenReturn(statement);
        doNothing().when(connection).close();

        when(statement.executeUpdate()).thenReturn(0);
        doNothing().when(statement).setInt(anyInt(),anyInt());
        doNothing().when(statement).setString(anyInt(),anyString());
    }
//    @BeforeClass
//    public void setUp() throws SQLException {
//        when(dataSource.getConnection()).thenReturn(connection);
//
//        when(connection.prepareStatement("INSERT INTO osoba (id, imie, nazwisko) values (?, ?, ?)")).thenReturn(statement);
//
//        when(statement.execute());
//    }

    @Test
    public void createShouldConnect() throws SQLException {
    //given
        final String imie = "IMIE";
        final String nazwisko = "NAZWISKO";
        final int id = 123;
        final Osoba osoba = new Osoba(id, imie, nazwisko);
        final OsobaDAO osobaDAO = new OsobaDAO(dataSource);
        //when
        osobaDAO.create(osoba);
        //then
        InOrder inOrder = Mockito.inOrder(dataSource,connection,statement);
        inOrder.verify(dataSource).getConnection();
        inOrder.verify(connection).prepareStatement("INSERT INTO osoba (id, imie, nazwisko) values (?, ?, ?)");
        inOrder.verify(statement).setInt(1,id);
        inOrder.verify(statement).setString(2,imie);
        inOrder.verify(statement).setString(3,nazwisko);
        inOrder.verify(statement).executeUpdate();
        inOrder.verify(connection).close();
    }
}
