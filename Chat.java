/*public class Bank
{
    private BankAccount[] accounts;

    public Bank(int size)
    {
        accounts = new BankAccount[size];
        for (int i = 0; i < accounts.length; i++)
        {
            accounts[i] = new BankAccount();
        }
    }

    public void deposit(int accountNumber, double amount)
    {
        BankAccount account = accounts[accountNumber];
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount)
    {
        BankAccount account = accounts[accountNumber];
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber)
    {
        BankAccount account = accounts[accountNumber];
        return account.getBalance();
    }
}*/

import java.util.ArrayList;
import java.util.HashMap;

public class Chat
{
    HashMap<Integer, Channel> channels;

    public Chat()
    {
        channels = new HashMap<>();
        channels.put(0, new Channel(0));
    }

    public ArrayList<String> log(Integer chanNumber)
    {
        Channel chan = channels.get(chanNumber);
        return chan.log();
    }

    public void send(String uName, String message, Integer chanNum)
    {
        Channel chan = channels.get(chanNum);
        chan.send(uName, message);
    }

    public void channel(Integer n)
    {
        if(!channels.containsKey(n))
        {
            channels.put(n, new Channel(n));
        }
    }
}