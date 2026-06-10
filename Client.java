/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 05/06/2026
 */
import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {

        try {

            GreetingService service =
                (GreetingService) Naming.lookup(
                    "rmi://localhost/GreetingService");

            System.out.println(
                service.echo("Hello")
            );

        } catch(java.rmi.NotBoundException | java.rmi.RemoteException | java.net.MalformedURLException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}