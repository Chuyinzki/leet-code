import java.util.HashMap;
import java.util.Map;

public class Codec {

    private final static String MY_BASE = "http://breh.com/";
    private final static Map<String, Integer> mappy = new HashMap<>();

    public static void main(String[] args) {
        decode(encode("https://yourmom.com"));
    }

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        if(mappy.get(longUrl) != null)
            return MY_BASE + mappy.get(longUrl);
        else {
            int value = mappy.size() + 1;
            mappy.put(longUrl, value);
            return MY_BASE + value;
        }
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        String valueString = shortUrl.replace(MY_BASE, "");
        Integer value = Integer.parseInt(valueString);
        for (Map.Entry<String, Integer> entry : mappy.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
