import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class HtmlService {
    public List<String> getLineOfHtml(String webpage) {
        try{
            List<String> list = new ArrayList<>();
            URL url = new URL(webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Download.html"));
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
                String []splitArray = line.split("[^а-яА-Я]+");
                for (int i = 0; i < splitArray.length; i++) {
                    if (splitArray[i].length()>0) {
                        list.add(splitArray[i].toLowerCase());
                    }
                }
            }
            readr.close();
            writer.close();
            Collections.sort(list);
            return list;
        }
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
            return null;
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
            return null;
        }
    }

    public HashMap<String, Integer> getMapOfList(List<String> list) {
        HashMap<String, Integer> wordAndNum = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            wordAndNum.put(list.get(i), 0);
        }
        for (int i = 0; i < list.size(); i++) {
            int z = wordAndNum.get(list.get(i));
            z++;
            wordAndNum.put(list.get(i), z);
        }
        return wordAndNum;
    }

    public void sortByKey(HashMap<String, Integer> wordAndNum) {
        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(wordAndNum);
        for (Map.Entry<String, Integer> entry : sorted.entrySet())

            System.out.println(entry.getKey() +
                    " - " + entry.getValue());
    }

}
