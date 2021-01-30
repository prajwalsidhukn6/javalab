import java.net.*;
import java.io.*;

public class CircleClient{
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket( "127.0.0.1", 4000);
        System.out.print("Enter the radius : ");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String radius = keyRead.readLine();

        OutputStream ostream = sock.getOutputStream( );
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(radius);
        InputStream istream = sock.getInputStream();

        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        String str;
        str = socketRead.readLine();
        System.out.println(str);
        
        pwrite.close();
        socketRead.close();
        keyRead.close();
    }
}
