/*This is a simple interface with some abstract 
 * methods and extending Remote interface.
 */

import java.rmi.*;
//defining the remote interface 
public interface Interface extends Remote{
   
    // get the vid link
    public String getvid(String msg) throws RemoteException;
}
