package DAO;

import Model.Product;
import org.bson.types.ObjectId;
import Exception.DAOException;
import Exception.ProductNotFoundException;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    boolean create(Product product) throws DAOException;
    Optional<Product> findById(ObjectId id) throws DAOException;
    List<Product> findAll() throws DAOException;
    boolean update(Product product) throws DAOException, ProductNotFoundException;
    boolean deleteById(ObjectId id) throws DAOException, ProductNotFoundException;
    boolean deleteAll() throws DAOException, ProductNotFoundException;
}
