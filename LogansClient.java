
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
public class LogansClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
//get the localhost IP address
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host);
        String message;
        int numberGiven;
        int num1;
        int num2;
        int operation;
        double powered;
        int finalNum = 0;
        Random rand = new Random();
//establish socket connection to server
        Socket socket = new Socket(host.getHostName(), 9876);
//read and write to socket using ObjectOutputStream
        PrintWriter oos = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader ois =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //System.out.println("Client started");

        oos.println("Hello");
        //System.out.println("Hello");
        ois.readLine();
        oos.println("Give me a number 1 through 10");
        //System.out.println("Give me a number 1 through 10");
        message = (String) ois.readLine();
        //System.out.println(message);
        num1 = Integer.parseInt(message);


        oos.println("Give me another number 1 through 10");
        //System.out.println("Give me another number 1 through 10");
        message = (String) ois.readLine();
        num2 = Integer.parseInt(message);
        //System.out.println(message);
        powered = Math.pow(num1, num2);
        finalNum = (int) powered;

        message = Integer.toString(finalNum);
        oos.println(message);
//close everything
        ois.close();
        oos.close();
        socket.close();
        Thread.sleep(100);
    }
}
