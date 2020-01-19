package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }

//        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
//            connection.send();
//        }

    }

    public static void sendBroadcastMessage(Message message){
        try{
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
                pair.getValue().send(message);
        }catch(IOException e){
            System.out.println("Сообщение не отправлено");
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {

                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (IOException e){
            System.out.println(" произошла ошибка.");
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
