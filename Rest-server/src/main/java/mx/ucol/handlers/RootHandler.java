package mx.ucol.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        byte[] response = "Not Found.".getBytes();
        exchange.sendResponseHeaders(404, response.length);

        System.out.println(exchange.getRequestMethod());
        System.out.println(exchange.getRequestURI());

        OutputStream output = exchange.getResponseBody();
        output.write(response);
        output.close();
    }
}
