/*This program obtains a reference of the remote 
 * object of server and invokes remote methods.
 */

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 

public class Client {
	public static void main (String[] argv) {
	    try { // again we try to define the security manager
                    System.setSecurityManager(new SecurityManager());
	    
                /* The "client" on client side is a reference object that refers "server" on server side.
                 * which means that "server" on the server is known as remote object. Now "client" refers the remote object
                 * So basically every method we call with "client" like client.getvid(blablabla), 
                 * becomes server.getvid(blablabla) on the server. 
                 * The remote object "server" invokes the remote method getvid(blablabla) on the server and 
                 * returns the return value to local variable msg.
                 * And every method we do on "client" on the client side will be executed on the server side with object "server"
                 * "client" and "server" communicates each other and it is known as object communication. 
                 * This is how remote method invocation and object communication works.
                 */
                Interface client = (Interface)Naming.lookup("rmi://localhost/getvid");
        while(true) //as long as the client is running our code runs
        {
                System.out.println("Enter Your link and press Enter:");
                Scanner s=new Scanner(System.in);
                
                String link=s.nextLine().trim();
		    	
                String msg = client.getvid(link);
                System.out.println(msg);
        }
	    	}catch (Exception e) {
	    		System.out.println("[System] Server failed: " + e);
	    	}
		}
}
