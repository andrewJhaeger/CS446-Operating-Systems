/******************************************************************************/
/*  Programmer Name:  Andrew Haeger, Ryan Gillet                              */
/*  Course Title: CS446                 Section No: 01                        */
/*  Assignment Number: 1                Due Date: 02/19/13                    */
/*  Instructor:  Dr. Farid Hallouche                                          */
/******************************************************************************/
/*  Programm Definition:  Server watching over the 6017 port.  When this port */
/*    is accessed, it checks the current day of the week and outputs the      */
/*    quote associated with it.                                               */
/******************************************************************************/
/*  sock:  ServerSocket definition.                                           */
/*  client:  Socket definition.                                               */
/*  pout:  PrintWriter definition.                                            */
/*  calendar:  Calendar definition.                                           */
/*  quote:  Holds the quote of the day.                                       */
/******************************************************************************/
/*  Development History                                                       */
/*  02/13/13 - Version 1.0                                                    */
/*           - Copied example code.  Modified code to return quote and        */
/*             not date.                                                      */
/******************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class QuoteServer {
    public static void main (String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6017);
            
            // Now listen for connections
            while (true) {
                Socket client = sock.accept();
                // We have a connection
                
                PrintWriter pout = new PrintWriter(client.getOutputStream(), 
                        true);
                
                // Write the quote to the socket
                Calendar calendar = new GregorianCalendar();
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                String quote = "";
                
                switch (dayOfWeek) {
                    case 1:     // Sunday
                        quote = "A life spent making mistakes is not only " + 
                                "more honorable, but more useful than a life " + 
                                "spent doing nothing. " + 
                                "\n  - George Bernard Shaw";
                    break;
                        
                    case 2:     // Monday
                        quote = "Do not dwell in the past, do not dream of " + 
                                "the future, concentrate the mind on the " + 
                                "present moment. \n  - Buddha";
                    break;
                        
                    case 3:     // Tuesday
                        quote = "Don't go around saying the world owes you " + 
                                "a living.  The world owes you nothing.  " + 
                                "It was here first. \n  - Mark Twain";
                    break;
                        
                    case 4:     // Wednesday
                        quote = "In three words I can sum up everything " + 
                                "I've learned about life: it goes on. " + 
                                "\n  - Robert Frost";
                    break;
                        
                    case 5:     // Thursday
                        quote = "Change is the law of life.  And those who " + 
                                "look only to the past or present are " + 
                                "certain to miss the future. " + 
                                "\n  - John F. Kennedy";
                    break;
                        
                    case 6:     // Friday
                        quote = "Never be bullied into silence.  Never " + 
                                "allow yourself to be made a victim.  Accept " + 
                                "no one's definition of your life; define " + 
                                "yourself. \n  - Harvey Fierstein";
                    break;
                        
                    case 7:     // Saturday
                        quote = "A man who dares to waste one hour of time " + 
                                "has not discovered the value of life. " + 
                                "\n  - Charles Darwin";
                    break;
                }
                pout.println(quote);
                
                // Close the socket and resume listening for more connections
                client.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
