package bio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        try {
            while (true){
                ServerSocket serverSocket = new ServerSocket(6789);
                while (true){
                    System.out.println("waiting conn");
                    //阻塞
                    Socket accept = serverSocket.accept();
                    System.out.println("conn succ");
                    //read阻塞
                    System.out.println("wait data");
                    accept.getInputStream().read(bytes);
                    System.out.println("data ed");
                    System.out.println(new String(bytes));
                    accept.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
