package bio1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 6789);
            Scanner scanner = new Scanner(System.in);
            while (true){
                String next = scanner.next();
                socket.getOutputStream().write(next.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
