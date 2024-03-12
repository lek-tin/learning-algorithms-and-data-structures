# TinyURL


```java
import java.util.UUID;
public class Codec {
    public String host = "http://tinyurl.com/";
    public HashMap <String, String> map = new HashMap();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String newU = host + UUID.randomUUID().toString().replace("-", "");
        map.put(newU, longUrl);
        return newU;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
```

Reference
  - https://www.baeldung.com/java-random-string
