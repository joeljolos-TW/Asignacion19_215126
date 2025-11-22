package DAO.Mongo;

import Config.MongoClientProvider;
import DAO.IProductDAO;
import Model.Product;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;
import Exception.DAOException;
import Exception.ProductNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements IProductDAO {

    private final MongoCollection<Product> collection;

    public ProductDAO() {
        this.collection = MongoClientProvider.INSTANCE.getCollection("Products", Product.class);
    }
    @Override
    public boolean create(Product product) throws DAOException{
        try{
            if(product.getId() == null){
                product.setCreatedIn(Instant.now());
                collection.insertOne(product);
                return true;
            }
        }catch (MongoException e){
            throw new DAOException("Creation error: ",e);
        }
        return false;
    }

    @Override
    public Optional<Product> findById(ObjectId id) throws DAOException {

        try{
            return Optional.ofNullable(collection.find(Filters.eq("_id", id)).first());
        }catch (MongoException e){
            throw new DAOException("Product found error: ",e);
        }
    }

    @Override
    public List<Product> findAll() throws DAOException {
        try{
            return collection.find().into(new ArrayList<>());
        } catch (MongoException e){
            throw new DAOException("Product found error: ",e);
        }
    }

    @Override
    public boolean update(Product product) throws DAOException, ProductNotFoundException {
        try{
            product.setUpdatedIn(Instant.now());
            var result = collection.updateOne(
                    Filters.eq("_id",product.getId()),
                    Updates.combine(
                            Updates.set("name", product.getName()),
                            Updates.set("price", product.getPrice()),
                            Updates.set("stock",product.getStock()),
                            Updates.set("provider", product.getProvider()),
                            Updates.set("categories", product.getCategories()),
                            Updates.set("updated_In", product.getUpdatedIn())
                    )
            );
            if(result.getMatchedCount() == 0) throw new ProductNotFoundException ("Product not founded: "+ product.getId());
        }catch (MongoException e){
            throw new DAOException("Update error: ",e);
        }
        return false;
    }

    @Override
    public boolean deleteById(ObjectId id) throws DAOException, ProductNotFoundException{
        try{
            var result = collection.deleteOne(Filters.eq("_id", id));
            if(result.getDeletedCount() == 0)throw new ProductNotFoundException ("Product not founded: "+ id);
            return true;
        } catch (MongoException e) {
            throw new DAOException("Delete error: ",e);
        }
    }

    @Override
    public boolean deleteAll() throws DAOException, ProductNotFoundException{
        try {
            var result = collection.deleteMany(Filters.exists("_id")).getDeletedCount();
            if(result > 0) return true;
        }catch (MongoException e) {
            throw new DAOException("Delete error: ",e);
        }
        return false;
    }
}
