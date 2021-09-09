import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class File {

    public static void DownloadWebPage(String webpage) {
        try {
            URL url = new URL(webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
            String line;

            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }
            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        }
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

    public static void main(String args[]) throws IOException {
        String url = "https://www.google.com/";
        DownloadWebPage(url);
    }
}