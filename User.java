import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class User
{
    public static void main(String[] args) throws IOException
    {
        final int PORT = 8888;
        try (Socket s = new Socket("localhost", PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);

            String command = "NAME Steve";
            System.out.println("Sending: " + command);
            out.print(command + "\n");


            command = "SEND Hello World";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            String response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "LOG";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "CHANNEL 1";
            System.out.println("Sending: " + command);
            out.print(command + "\n");

            command = "LOG";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "QUIT";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
        }
    }
}