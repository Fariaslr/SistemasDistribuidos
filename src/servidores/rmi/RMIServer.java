package servidores.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import servidores.resources.CalculatorImpl;

public class RMIServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CalculatorImpl calc = new CalculatorImpl();
            Naming.rebind("rmi://localhost/CalculatorService", calc);
            System.out.println("Servidor RMI está pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
