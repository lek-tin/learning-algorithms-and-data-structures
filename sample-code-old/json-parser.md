
It support arrays, nested objects
```java
import org.json.JSONArray;
import org.json.JSONObject;

public class SimpleJsonParser {

    public static void main(String[] args) {
        // Your JSON string
        String jsonString = "{\"name\":\"John\",\"age\":30,\"address\":{\"city\":\"New York\",\"zip\":\"10001\"},\"grades\":[90,85,95]}";

        try {
            // Parse JSON string
            JSONObject jsonObject = parseJson(jsonString);

            // Access individual values
            String name = getString(jsonObject, "name");
            int age = getInt(jsonObject, "age");

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

            // Access nested object
            JSONObject addressObject = getObject(jsonObject, "address");
            String city = getString(addressObject, "city");
            String zip = getString(addressObject, "zip");

            System.out.println("City: " + city);
            System.out.println("Zip: " + zip);

            // Access values in a JSON array
            JSONArray gradesArray = getArray(jsonObject, "grades");

            System.out.print("Grades: ");
            for (int i = 0; i < gradesArray.length(); i++) {
                int grade = gradesArray.getInt(i);
                System.out.print(grade + " ");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject parseJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        parseJson(json, jsonObject);

        return jsonObject;
    }

    private static void parseJson(String json, JSONObject jsonObject) throws JSONException {
        // Remove leading and trailing curly braces
        json = json.substring(1, json.length() - 1);

        String[] keyValuePairs = json.split(",");
        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":", 2);
            String key = entry[0].trim().replace("\"", "");
            String value = entry[1].trim();

            if (value.startsWith("{")) {
                JSONObject nestedObject = new JSONObject();
                parseJson(value, nestedObject);
                jsonObject.put(key, nestedObject);
            } else if (value.startsWith("[")) {
                JSONArray nestedArray = new JSONArray();
                parseArray(value, nestedArray);
                jsonObject.put(key, nestedArray);
            } else {
                jsonObject.put(key, parseValue(value));
            }
        }
    }

    private static void parseArray(String json, JSONArray jsonArray) throws JSONException {
        // Remove leading and trailing square brackets
        json = json.substring(1, json.length() - 1);

        String[] elements = json.split(",");
        for (String element : elements) {
            element = element.trim();
            if (element.startsWith("{")) {
                JSONObject nestedObject = new JSONObject();
                parseJson(element, nestedObject);
                jsonArray.put(nestedObject);
            } else if (element.startsWith("[")) {
                JSONArray nestedArray = new JSONArray();
                parseArray(element, nestedArray);
                jsonArray.put(nestedArray);
            } else {
                jsonArray.put(parseValue(element));
            }
        }
    }

    private static Object parseValue(String value) {
        // Check if the value is a string, integer, or boolean
        if (value.startsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        } else {
            return Integer.parseInt(value);
        }
    }

    private static String getString(JSONObject jsonObject, String key) throws JSONException {
        return (String) jsonObject.get(key);
    }

    private static int getInt(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getInt(key);
    }

    private static JSONObject getObject(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getJSONObject(key);
    }

    private static JSONArray getArray(JSONObject jsonObject, String key) throws JSONException {
        return jsonObject.getJSONArray(key);
    }
}
```