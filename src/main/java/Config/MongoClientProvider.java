package Config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public enum MongoClientProvider {
    INSTANCE;

    private MongoClient client;
    private String NAME="Products";
    private String URI="mongodb://localhost:27017/";

    public synchronized void init() {
        if (client == null) {
            client = MongoClients.create(MongoConfig.buildSettings(URI));
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    client.close();
                } catch (Exception e) {
                }
            }));
        }
    }

    public MongoClient client() {
        if (client == null)throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init(uri) antes.");
        return client;
    }

    public MongoDatabase database() {
        return client().getDatabase(this.NAME);
    }

    public <T> MongoCollection<T> getCollection(String collectionName, Class<T> clazz) {
        if (client == null)
            throw new IllegalStateException("MongoClientProvider no inicializado. Llama a init(uri) antes.");

        MongoDatabase db = client.getDatabase(this.NAME);
        return db.getCollection(collectionName, clazz);
    }
}