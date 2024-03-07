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

import java.util.HashMap;

public class Chat
{
    HashMap<Integer, Channel> channels;

    public Chat()
    {
        channels = new HashMap<>();
        channels.put(0, new Channel());
    }

    public void join(Integer chanNumber)
    {
        Channel chan = channels.get(chanNumber);
        chan.join();
    }

    public void name(Integer chanNumber)
    {
        Channel chan = channels.get(chanNumber);
        chan.join();
    }

    public void channel(Integer chanNumber)
    {
        Channel chan = channels.get(chanNumber);
        chan.join();
    }

    public String send()
    {
        return "";
    }

    public void quite()
    {

    }
}