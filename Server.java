import java.io.*;
import java.net.*;

class Server
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("Server of Marvellous Chat Messenger is Running");
        
        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is in the listening mode at port no 2100");

        Socket sobj = ssobj.accept();
        System.out.println("Client and Server Connection is Successfull");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Marvellous Chat Messenger is Started...");

        String str1,str2;

        while((str1 = br1.readLine())!= null)
        {
            System.out.println("Client Says :"+str1);
            System.out.println("Enter Messege For Client:");
            str2 = br2.readLine();
            ps.println(str2);
        }
        System.out.println("Thank you For using chat messenger..");

        sobj.close();
        ps.close();
        br1.close();
        br2.close();
    }
}