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