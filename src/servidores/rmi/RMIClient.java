package servidores.rmi;

import java.rmi.Naming;
import servidores.resources.Calculator;

public class RMIClient {

    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            System.out.println("Resultado da soma: " + calc.add(5, 3));
            System.out.println("Resultado da subtração: " + calc.subtract(10, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
