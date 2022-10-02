package codegym.repository;

import codegym.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Phone, Long> {
}
