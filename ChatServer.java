import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class ChatServer
{
    public static void main(String[] args) throws IOException
    {
        Chat c = new Chat();
        final int PORT = 8888;
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            ChatService service = new ChatService(s, c);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
