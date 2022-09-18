package codegym.repository;

import codegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductManagerRepository extends JpaRepository<Product ,Integer> {
    List<Product> findByName (String name);
}
