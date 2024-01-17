
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class LogansServer {
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    public static void main(String args[]) throws IOException, ClassNotFoundException {
//create the socket server object
        server = new ServerSocket(port);
//variables used for the manipulation of the string we get, like converting it to an integer and back to a string when needed
        String message;
        int num;
        Random rand= new Random();

        //System.out.println("Server Started");
//creating socket that is in idle till the client tries to connect
        Socket socket = server.accept();
//read and write from and to the socket
        PrintWriter oos = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader ois =  new BufferedReader(new InputStreamReader(socket.getInputStream()));

        ois.readLine();
        //System.out.println("Hello");
        oos.println("Hello");
        ois.readLine();
        num = rand.nextInt(10) + 1;

        message = Integer.toString(num);
        //System.out.println(message);

        oos.println(message);
        ois.readLine();

        num = rand.nextInt(10) + 1;
        message = Integer.toString(num);
        oos.println(message);
        //System.out.println(message);
        message = (String) ois.readLine();
        //System.out.println(message);
//close resources
        ois.close();
        oos.close();
        socket.close();
//close the ServerSocket object
                server.close();
    }
}
