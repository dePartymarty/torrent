import java.net.*;
import java.io.*;
import java.util.*;

public class ClientRequestThread extends Thread
{
    private Socket s; 

    public ClientRequestThread(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
       try 
       {
           System.out.println("Client Request Thread Started");
           Scanner input = new Scanner(this.s.getInputStream());
           PrintStream output = new PrintStream(this.s.getOutputStream());

           while(true)
           {
               // send request 
               int byteNumber = 5;
               output.println(byteNumber);

               String userInput = input.nextLine();
               if(userInput.equals("Si"))
               {
                   System.out.println("Si");
               }
               else
               {
                   System.out.println("No mas");
               }
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

        
    }
}