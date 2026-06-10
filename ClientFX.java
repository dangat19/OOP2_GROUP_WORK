/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 09/06/2026
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class ClientFX {

    public static void main(String[] args) {
        GreetingService service;

        try {
            service = (GreetingService) Naming.lookup("rmi://localhost/GreetingService");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            System.err.println("Failed to locate GreetingService: " + e.getMessage());
            e.printStackTrace(System.err);
            return;
        }

        try {
            String students = service.getStudents();
            System.out.println("Students:\n" + students);
        } catch (RemoteException ex) {
            System.err.println("Failed to retrieve students: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }
}
