/******************************************************************************/
/*  Programmer Name:  Andrew Haeger, Ryan Gillet                              */
/*  Course Title: CS446                 Section No: 01                        */
/*  Assignment Number: 1                Due Date: 02/19/13                    */
/*  Instructor:  Dr. Farid Hallouche                                          */
/******************************************************************************/
/*  Programm Definition:  Client connects to port 6017 to retrieve the quote  */
/*    of the day and display it to the user.                                  */
/******************************************************************************/
/*  sock:  ServerSocket definition.                                           */
/*  in:  InputStream definition.                                              */
/*  bin:  BufferedReader definition.                                          */
/*  line:  Holds the quote of the day.                                        */
/******************************************************************************/
/*  Development History                                                       */
/*  02/13/13 - Version 1.0                                                    */
/*           - Copied example code.  Modified code to watch port 6017         */
/*             instead of port 6013.                                          */
/******************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class QuoteClient {
    public static void main(String[] args) {
        try {
            // This could be changed to an IP name of address 
            // other than the localhost
            Socket sock = new Socket("127.0.0.1", 6017);
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            
            String line;
            while ( (line = bin.readLine()) != null ) {
                System.out.println(line);
            }
            
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
