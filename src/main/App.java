package main;

import com.sun.net.httpserver.HttpServer;
import apirotas.ConverterHorarioAPI;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {

        // Inicia servidor
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);

        // Registra rota
        servidor.createContext("/", new ConverterHorarioAPI());

        // Inicia
        servidor.setExecutor(null);
        servidor.start();
        System.out.println("Servidor rodando em http://localhost:8080/");
    }
}