package codegym.repository.customer;

import codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where name like %:keyword% and is_delete =0", nativeQuery = true)
    Page<Customer> searchByName(@Param("keyword") String name, Pageable pageable);

    @Modifying
    @Query(value = "update customer set is_delete= 1 where id = :keywordId", nativeQuery = true)
    void deleteId(@Param("keywordId") int id);


}