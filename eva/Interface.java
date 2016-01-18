/*This is a simple interface with some abstract 
 * methods and extending Remote interface.
 */

import java.rmi.*;
//defining the remote interface 
public interface Interface extends Remote{
   
    // get the vid link
    public String getvid(String msg) throws RemoteException;

    // stream the video
    public void streamvid(String msg) throws RemoteException;

   // qr code
    public void qrvid(String msg) throws RemoteException;

    // download vid 
    public void downvid(String msg) throws RemoteException;
}
