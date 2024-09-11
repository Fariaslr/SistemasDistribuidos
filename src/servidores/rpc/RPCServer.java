package servidores.rpc;

import java.io.*;
import java.net.*;

public class RPCServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor RPC iniciado e aguardando conexões...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String request = in.readLine();
                    if (request != null) {
                        System.out.println("Recebido: " + request);
                        String[] parts = request.split(",");
                        String operation = parts[0];
                        int a = Integer.parseInt(parts[1]);
                        int b = Integer.parseInt(parts[2]);

                        int result = 0;
                        switch (operation) {
                            case "add":
                                result = a + b;
                                break;
                            case "subtract":
                                result = a - b;
                                break;
                            // Outras operações podem ser adicionadas aqui
                        }

                        out.println("Resultado: " + result);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
