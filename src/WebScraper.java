import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        String[] webPage = urlToString("http://erdani.com/tdpl/hamlet.txt").split("\\W+");
        ArrayList<String> uniqueWords = new ArrayList<>();
        int uniqueWordCount = 0;
        for (String word: webPage) {
            System.out.println(word);
            if (uniqueWords.indexOf(word) < 0){
                uniqueWordCount++;
                uniqueWords.add(word);
            }
        }
        System.out.println(uniqueWordCount);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    private static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
