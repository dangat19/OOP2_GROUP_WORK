/*
 * Lab 3.2 – Java RMI
 * Group Members:
 * Daniel Muriithi - 190017
 * James Kingola - 221747
 * Date: 05/06/2026
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GreetingServiceImpl extends UnicastRemoteObject
        implements GreetingService {

    protected GreetingServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String greet() throws RemoteException {
        return "Daniel Muriithi, how are you doing today?";
    }
}