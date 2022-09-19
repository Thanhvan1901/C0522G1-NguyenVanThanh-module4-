package codegym.reposiroty;

import codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceReposiroty  extends PagingAndSortingRepository<Province , Long> {
}
