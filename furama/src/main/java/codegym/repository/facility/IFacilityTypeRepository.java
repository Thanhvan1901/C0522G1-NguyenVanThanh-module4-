package codegym.repository.facility;

import codegym.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType , Integer> {
}
