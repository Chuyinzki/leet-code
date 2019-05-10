import java.util.HashMap;
import java.util.Map;

public class Codec {

    private final static String MY_BASE = "http://breh.com/";
    private final static Map<Integer, String> mappy = new HashMap<>();
    private static int id = 0;

    public static void main(String[] args) {
        decode(encode("https://yourmom.com"));
    }

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        mappy.put(++id, longUrl);
        return MY_BASE + id;

    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        String valueString = shortUrl.replace(MY_BASE, "");
        Integer value = Integer.parseInt(valueString);
        return mappy.get(value);
    }
}
