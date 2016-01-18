/* This is simple detailed program where we implement 
 * all the abstract methods of the remote interface.
 */


import java.rmi.*;      // for remote exception
import java.rmi.server.*; // this one for the Unicast Remote Object
import java.io.*;

// here we define the implementation that extends the UnicastRemote object and implement the interface
public class Impl extends UnicastRemoteObject implements Interface  {

    public String link; // the link provided by the user
    
    // WE DON"T need to invoke a superclass contructor as it is done by JVM
    // we define a constructor that invokes the superclass constructor
    public Impl() throws RemoteException
    {
        super(); // super class constructor of the Object class
    }

    // we define getting the video function
    public String getvid(String link) throws RemoteException 
    {
        String L="Enter a valid link";
        
        // as it needs to call an external function 
        try {
        Process p = Runtime.getRuntime().exec("python pridown.py "+link);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        // print the std output
        while ( stdInput.readLine() != null) 
        { 
            L=stdInput.readLine(); 
        }

        // Print the std error
        while ( stdError.readLine() != null) 
        {
            L=stdError.readLine();
        }

             }
        catch (IOException e) 
        {
            L="Something went terribly wrong, blame Canada 0.0\n";
            e.printStackTrace();
            System.exit(-1);
        }
        // it returns a String
        return L;
    }
     public void streamvid(String msg) throws RemoteException
     {try {

        Runtime.getRuntime().exec("smplayer " +msg);     }
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
      }
public void downvid(String msg) throws RemoteException
     {try {
        Runtime.getRuntime().exec("wget -c " +msg);     }
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }
     }
     public void qrvid(String msg) throws RemoteException
     {try {
        Runtime.getRuntime().exec("qrencode "+msg + " -o temp.png");
        Runtime.getRuntime().exec("display temp.png");     }
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(-1);
        }

     }
}
