/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 09/06/2026
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GreetingService extends Remote {

    String echo(String text) throws RemoteException;

    String getStudents() throws RemoteException;
}