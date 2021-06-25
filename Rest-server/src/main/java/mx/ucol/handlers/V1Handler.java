package mx.ucol.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import mx.ucol.helpers.DBConnection;
import mx.ucol.helpers.JSON;
import mx.ucol.models.Todo;

import java.io.IOException;
import java.io.OutputStream;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class V1Handler implements HttpHandler{
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        switch(requestMethod){
            case "GET":
                getHandler(exchange);
                break;
            case "POST":
                postHandler(exchange);
                break;
            case "PUT":
                putHandler(exchange);
                break;
            case "DELETE":
                deleteHandler(exchange);
                break;
            default:
                notSupportedHandler(exchange);
                break;
        }
    }

    private void getHandler(HttpExchange exchange) throws IOException {
        OutputStream output = exchange.getResponseBody();
        Connection connection = DBConnection.getInstance();
        String sql = "SELECT * from todos;";
        List<Todo> todoList = new ArrayList<Todo>();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                Todo todo = new Todo();
                todo.setId(result.getInt("id"));
                todo.setTitle(result.getString("title"));
                todo.setCompleted(result.getInt("completed") == 1 ? true : false);

                todoList.add(todo);
            }
        } catch (SQLException e){
            System.err.println("Error at V1Handler: " + e.getMessage());
        }


        String jsonResponse = JSON.objectToJson(todoList);
        byte[] response = jsonResponse.getBytes();

        exchange.sendResponseHeaders(200, response.length);
        output.write(response);
        output.close();
    }

    private void postHandler(HttpExchange exchange) throws IOException {
        OutputStream output = exchange.getResponseBody();
        byte[] response = "post Handler".getBytes();

        exchange.sendResponseHeaders(200, response.length);
        output.write(response);
        output.close();
    }

    private void putHandler(HttpExchange exchange)throws IOException {
        OutputStream output = exchange.getResponseBody();
        byte[] response = "put Handler".getBytes();

        exchange.sendResponseHeaders(200, response.length);
        output.write(response);
        output.close();
    }

    private void deleteHandler(HttpExchange exchange) throws IOException {
        OutputStream output = exchange.getResponseBody();
        byte[] response = "delete Handler".getBytes();

        exchange.sendResponseHeaders(200, response.length);
        output.write(response);
        output.close();
    }
    private void notSupportedHandler(HttpExchange exchange) throws IOException {
        OutputStream output = exchange.getResponseBody();
        byte[] response = "not Supported Handler".getBytes();

        exchange.sendResponseHeaders(200, response.length);
        output.write(response);
        output.close();
    }
}
