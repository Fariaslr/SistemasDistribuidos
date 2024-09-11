package servidores.rpc;

import java.io.*;
import java.net.*;

public class RPCClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request = "add,5,3";  // Exemplo de operação "add" com os valores 5 e 3
            out.println(request);

            String response = in.readLine();
            System.out.println("Resposta do servidor: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
