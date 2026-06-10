/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 05/06/2026
 */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(2000  );

            GreetingService service =
                    new GreetingServiceImpl();

            Naming.rebind("GreetingService", service);

            System.out.println("Server running...");

        } catch (java.rmi.RemoteException | java.net.MalformedURLException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}