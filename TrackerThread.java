import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.net.InetAddress;



public class TrackerThread extends Thread
{
    private Socket theClient;
    private String ipAdd;

    public TrackerThread(Socket theClient)
    {
        this.theClient = theClient;
    }

    public void run()
    {
        System.out.println("Tracker Thread Started....");
        try
        {
            InetAddress ipAdresses = InetAddress.getLocalHost();
            ipAdd = ipAdresses.getHostAddress();
            //System.out.println("Your IP: " + ipAdd);

            CORE.addIP(ipAdd);


            ArrayList<String> cIPs = CORE.getList();

            System.out.println("All Clients: " + cIPs);
            System.out.println("Done");


        }
        catch (UnknownHostException e)
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        

        //get the IP address of our connect client
        //add it to our list of peers, then broadcast
        //the current list of peers to this connected client
        //as well as all previous clients
    }
}