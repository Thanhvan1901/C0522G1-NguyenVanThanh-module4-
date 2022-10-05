package codegym.repository.facility;

import codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IFacilityRepository extends JpaRepository<Facility , Integer> {

    Page<Facility> findAllByNameContaining(String name , Pageable pageable);

    void deleteById(int id);

    Facility findAllById(int id) ;
}
