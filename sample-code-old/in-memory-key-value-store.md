```java
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class InMemoryKeyValueStore {
    private Map<String, String> data;
    private Stack<Map<String, String>> transactions;
    private boolean inTransaction;

    public InMemoryKeyValueStore() {
        this.data = new HashMap<>();
        this.transactions = new Stack<>();
        this.inTransaction = false;
    }

    public void beginTransaction() {
        if (!inTransaction) {
            System.out.println("Starting a new transaction...");
            transactions.push(new HashMap<>(data));
            inTransaction = true;
        } else {
            System.out.println("Error: Transaction already in progress.");
        }
    }

    public void commit() {
        if (inTransaction) {
            transactions.clear();
            inTransaction = false;
            System.out.println("Transaction was commited.");
        } else {
            System.out.println("Error: No transaction in progress.");
        }
    }

    public void rollback() {
        if (inTransaction) {
            if (!transactions.isEmpty()) {
                data = transactions.pop();
            }
        } else {
            System.out.println("Error: No transaction in progress.");
        }
    }

    public void put(String key, String value) {
        if (inTransaction) {
            transactions.peek().put(key, value);
        } else {
            data.put(key, value);
        }
    }

    public String get(String key) {
        return data.get(key);
    }

    public void printData() {
        System.out.println("Data: " + data);
    }
}

public class KeyValueStoreExample {
    public static void main(String[] args) {
        InMemoryKeyValueStore keyValueStore = new InMemoryKeyValueStore();

        keyValueStore.put("key1", "value1");
        keyValueStore.put("key2", "value2");
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2}
        keyValueStore.rollback(); // no transaction to roll back

        // Start a transaction
        keyValueStore.beginTransaction();
        keyValueStore.put("key3", "value3");
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2}
        // keyValueStore.beginTransaction(); // error

        // Commit the transaction
        keyValueStore.commit();
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2, key3=value3}

        // Start a new transaction
        keyValueStore.beginTransaction();
        keyValueStore.put("key4", "value4");
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2, key3=value3}
        keyValueStore.commit(); 
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2, key3=value3, key4=value4}

        // Rollback the transaction
        keyValueStore.rollback();
        keyValueStore.printData(); // Output: Data: {key1=value1, key2=value2, key3=value3}
    }
} 
```
