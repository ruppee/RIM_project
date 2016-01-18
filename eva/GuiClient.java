import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
 
// A GUI program inherits from the top-level container java.awt.Frame

public class GuiClient extends Frame implements ActionListener {
   private Label lblInput;     // Declare input Label
   private Label lblOutput;    // Declare output Label
   private Button Butqr;       // Declare a button for qr
   private Button Butdow;      // Declare a button for download
   private Button Butstr;      // Declare a buttong for streaming
   private TextField tfInput;  // Declare input TextField
   private TextField tfOutput; // Declare output TextField
   private String link;        // Input link
   private String vlink;       // Output link 

     
   /** Constructor to setup the UI components and event handling */
   public GuiClient() {
      setLayout(new FlowLayout());
         // "super" Frame sets layout to FlowLayout, which arranges the components
         //  from left-to-right, and flow to next row from top-to-bottom.
 
      lblInput = new Label("Enter a link: "); // Construct Label
      add(lblInput);               // "super" Frame adds Label
 
      tfInput = new TextField(200); // Construct TextField
      add(tfInput);                // "super" Frame adds TextField
 
      tfInput.addActionListener(this);
         // Hitting Enter on TextField fires ActionEvent
         // tfInput (TextField) registers this instance as ActionEvent listener
 
      lblOutput = new Label("The download link is below: ");  // allocate Label
      add(lblOutput);               // "super" Frame adds Label
 
      tfOutput = new TextField(200); // allocate TextField
      tfOutput.setEditable(false);  // read-only
      add(tfOutput);                // "super" Frame adds TextField
 

      Butqr = new Button("Qr Code");   // construct Button
      add(Butqr);                    // "super" Frame adds Button

      Butstr = new Button("Stream");   // construct Button
      add(Butstr);                    // "super" Frame adds Button

      Butdow = new Button("Download");   // construct Button
      add(Butdow);                    // "super" Frame adds Button



      setTitle("Client");  // "super" Frame sets title
      setSize(900, 300);  // "super" Frame sets initial window size
      setVisible(true);   // "super" Frame shows
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an anonymous instance
      new GuiClient();
      		}

   /** ActionEvent handler - Called back upon hitting enter key on TextField */
   @Override
   public void actionPerformed(ActionEvent evt) {

        try {
                System.setSecurityManager(new SecurityManager());
	    	
                Interface client = (Interface)Naming.lookup("rmi://localhost/getvid");
             	    	
                // Get the String entered into the TextField tfInput, convert to int
                link = tfInput.getText();
                vlink = client.getvid(link);
                tfOutput.setText(vlink);
            
            }catch (Exception e) {
	    		System.out.println("[System] Server failed: " + e);
	    	} 

}
} 
