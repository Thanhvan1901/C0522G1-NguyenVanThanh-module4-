package codegym.repository;

import codegym.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
