import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;

///**
// Executes Simple Bank Access Protocol commands
// from a socket.
// */
//public class BankService implements Runnable
//{
//    private Socket s;
//    private Scanner in;
//    private PrintWriter out;
//    private Bank bank;
//
//    /**
//     Constructs a service object that processes commands
//     from a socket for a bank.
//     @param aSocket the socket
//     @param aBank the bank
//     */
//    public BankService(Socket aSocket, Bank aBank)
//    {
//        s = aSocket;
//        bank = aBank;
//    }
//
//    public void run()
//    {
//        try
//        {
//            try
//            {
//                in = new Scanner(s.getInputStream());
//                out = new PrintWriter(s.getOutputStream());
//                doService();
//            }
//            finally
//            {
//                s.close();
//            }
//        }
//        catch (IOException exception)
//        {
//            exception.printStackTrace();
//        }
//    }
//
//    /**
//     Executes all commands until the QUIT command or the
//     end of input.
//     */
//    public void doService() throws IOException
//    {
//        while (true)
//        {
//            if (!in.hasNext()) { return; }
//            String command = in.next();
//            if (command.equals("QUIT")) { return; }
//            else { executeCommand(command); }
//        }
//    }
//
//    /**
//     Executes a single command.
//     @param command the command to execute
//     */
//    public void executeCommand(String command)
//    {
//        int account = in.nextInt();
//        if (command.equals("DEPOSIT"))
//        {
//            double amount = in.nextDouble();
//            bank.deposit(account, amount);
//        }
//        else if (command.equals("WITHDRAW"))
//        {
//            double amount = in.nextDouble();
//            bank.withdraw(account, amount);
//        }
//        else if (!command.equals("BALANCE"))
//        {
//            out.println("Invalid command");
//            out.flush();
//            return;
//        }
//        out.println(account + " " + bank.getBalance(account));
//        out.flush();
//    }


public class ChatService implements Runnable
{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Chat chat;

    private String uName;
    private Integer channelNumber;

    public ChatService(Socket aSocket, Chat aChat)
    {
        uName = "Guest";
        channelNumber = 0;
        s = aSocket;
        chat = aChat;
    }
    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

    public void executeCommand(String command)
    {
        switch(command) {
            case "NAME": {
                uName = in.nextLine();
                break;
            }
            case "CHANNEL": {
                channelNumber = in.nextInt();
                chat.channel(channelNumber);
                break;
            }
            case "SEND": {
                String message = in.nextLine();
                chat.send(message, channelNumber);
            }
            case "LOG": {
                out.println(chat.log(channelNumber));
                out.flush();
                break;
            }
            default: {
                out.println("Invalid command");
                out.flush();
            }
        }
    }
}