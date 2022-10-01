package codegym.repository.facility;

import  codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    Page<Facility> findAllByNameContaining(String nameFacility,Pageable pageable);

}
