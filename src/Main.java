import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String args[]) throws IOException {
        String url = "https://yandex.ru/";
        List<String> list = new HtmlService().getLineOfHtml(url);
        HashMap<String, Integer> wordAndNum = new HtmlService().getMapOfList(list);
        new HtmlService().sortByKey(wordAndNum);
    }
}