package codegym.repository.facility;

import codegym.model.customer.Customer;
import codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where name like %:keyword% and is_delete =0", nativeQuery = true)
    Page<Facility> searchByName(@Param("keyword") String name, Pageable pageable);


    @Modifying
    @Query(value = "update facility set is_delete= 1 where id = :keywordId", nativeQuery = true)
    void deleteId(@Param("keywordId") int id);

}
