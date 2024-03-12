import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Channel
{
    private ArrayList<String> log;
    private Lock logChangeLock;

    public Channel(Integer n)
    {
        log = new ArrayList<String>();
        logChangeLock = new ReentrantLock();
        log.add("Welcome to channel " + n +".");
    }

    public ArrayList<String> log()
    {
        return log;
    }

    public void send(String uName, String message)
    {

        logChangeLock.lock();
        try
        {
            log.add(uName + ": " + message);
        }
        finally
        {
            logChangeLock.unlock();
        }
    }
}