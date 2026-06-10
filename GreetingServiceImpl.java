/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 09/06/2026
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GreetingServiceImpl extends UnicastRemoteObject
        implements GreetingService {

    protected GreetingServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String echo(String text)
            throws RemoteException {

        return "You entered: " + text;
    }

    @Override
    public String getStudents()
            throws RemoteException {

        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "Fabrizi0@21"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student_data")) {

            while (rs.next()) {

                result.append(rs.getInt("id"))
                      .append(" | ")
                      .append(rs.getString("name"))
                      .append(" | ")
                      .append(rs.getString("course"))
                      .append(" | ")
                      .append(rs.getDouble("marks"))
                      .append("\n");
            }

        } catch (Exception e) {
            return "Database Error: " + e.getMessage();
        }

        return result.toString();
    }
}
