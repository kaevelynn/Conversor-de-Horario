package apirotas;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import conversor.Conversor;

public class ConverterHorarioAPI implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // Permitir CORS
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");

        // Ler corpo da requisição
        InputStream corpo = exchange.getRequestBody();
        String body = new String(corpo.readAllBytes(), StandardCharsets.UTF_8);

        // Extrair { "horario": "22:44" }
        String horario = extrairHorario(body).toUpperCase();

        // Chamar SUA lógica separada
        String resposta = Conversor.ConverterHorario(horario);

        // Enviar resposta
        byte[] resp = resposta.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, resp.length);
        exchange.getResponseBody().write(resp);
        exchange.getResponseBody().close();
    }

    private String extrairHorario(String json) {

        // remove espaços extras
        json = json.trim();

        // procura o primeiro par de aspas depois dos dois pontos
        int start = json.indexOf(":") + 1;

        // garante que pegamos a string entre aspas
        start = json.indexOf("\"", start) + 1;
        int end = json.indexOf("\"", start);

        return json.substring(start, end);
    }
}
