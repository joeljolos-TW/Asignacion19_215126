package Model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.List;

public class Product {

    private ObjectId id;

    private String name;
    private Integer price;
    private Integer stock;

    private Provider provider;

    private List<String> categories;

    @BsonProperty("created_In")
    private Instant createdIn;

    @BsonProperty("updated_In")
    private Instant updatedIn;

    public Product() {
    }

    public Product(ObjectId id,
                   String name,
                   Integer price,
                   Integer stock,
                   Provider provider,
                   List<String> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.provider = provider;
        this.categories = categories;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Instant getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Instant createdIn) {
        this.createdIn = createdIn;
    }

    public Instant getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Instant updatedIn) {
        this.updatedIn = updatedIn;
    }
}
