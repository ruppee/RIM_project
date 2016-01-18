/* This program creates a remote object, links with an 
 * alias name (ip address and some identifier) and binds 
 * with the RMI registry, linked to RMI runtime mechanism.
 */

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 
public class Server {
public static void main (String[] argv) {
    try {
        // it's importand to define the security manager as it handles the policies over the network,
        // and specify a security policy file so that the code is granted the security permissions it needs to run.
	    	if (System.getSecurityManager()== null)
            {
                System.setSecurityManager(new SecurityManager());
            }
           

        // We define the remote interface object "server" by using the implementation program constructor Impl()
            Interface server = new Impl();	

        // RMI uses a naming service where an alias name is maintained and show be used by the client to invoke the remote method
        
        //The rebind() method of Naming class binds the object "server" along alias name "getvid" with the RMI registry.
	    	Naming.rebind("rmi://localhost/getvid", server); 
            //Alias name "getvid" refers the object "server" on server side. Object "server" RMI registry is connected internally with the Remote reference layer.

	    	System.out.println("Server is ready:");// we print a message to clarify the binding

    	}
    
    catch (Exception e) {
    		System.out.println("[System] Server failed: " + e);
    	}
	}
}
