import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

/*public class BankServer
{
    public static void main(String[] args) throws IOException
    {
        final int ACCOUNTS_LENGTH = 10;
        Bank bank = new Bank(ACCOUNTS_LENGTH);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            BankService service = new BankService(s, bank);
            Thread t = new Thread(service);
            t.start();
        }
    }
}*/

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
