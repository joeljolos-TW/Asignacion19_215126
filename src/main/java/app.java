import Config.MongoClientProvider;
import DAO.IProductDAO;
import DAO.Mongo.ProductDAO;
import Model.Product;
import Model.Provider;
import org.bson.types.ObjectId;
import Exception.DAOException;
import Exception.ProductNotFoundException;
import java.util.List;

public class app {

    static void main() {
        MongoClientProvider.INSTANCE.init();

        IProductDAO dao = new ProductDAO();

        try {
            Product p1 = new Product(
                    null,
                    "Laptop Lenovo IdeaPad 3",
                    12500,
                    15,
                    new Provider(
                            new ObjectId(),
                            "Lenovo México",
                            "contacto@lenovo.com",
                            "México"
                    ),
                    List.of("Electrónica", "Computadoras", "Laptops")
            );

            boolean id = dao.create(p1);
            System.out.println("result of creation:" + id);


            Product p2 = new Product(
                    null,
                    "Teclado Mecánico Redragon K552",
                    850,
                    40,
                    new Provider(
                            new ObjectId(),
                            "Redragon LATAM",
                            "support@redragonlatam.com",
                            "China"
                    ),
                    List.of("Electrónica", "Accesorios", "Periféricos")
            );
            boolean id2 = dao.create(p2);
            System.out.println("result of creation:" + id2);

            Product p3 = new Product(
                    null,
                    "Mouse Logitech G203",
                    450,
                    60,
                    new Provider(
                            new ObjectId(),
                            "Logitech",
                            "sales@logitech.com",
                            "Estados Unidos"
                    ),
                    List.of("Electrónica", "Accesorios", "Periféricos")
            );
            boolean id3 = dao.create(p3);
            System.out.println("result of creation:" + id3);

            dao.findById(p1.getId()).ifPresent(
                    u-> System.out.println("Founded: "+ u.getName())
            );

            p1.setStock(169);

            dao.update(p1);
            System.out.println("result of update:" + p1.getStock());

            var all = dao.findAll();
            System.out.println("result of findAll:" + all);

            dao.deleteById(p1.getId());
            System.out.println("product eliminated");
        }catch (ProductNotFoundException e){
            System.err.println("Not Found: "+e.getMessage());
        }catch (DAOException e){
            System.err.println("DAO Error: "+e.getMessage());
        }
    }

}
