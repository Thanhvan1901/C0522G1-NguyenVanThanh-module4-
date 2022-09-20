package codegym.repposiroty;

import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blogs where name_blog like %:keyword%",nativeQuery = true)
    Page<Blog> searchByName(@Param("keyword") String name, Pageable pageable);

    @Query(value = "select  * from blogs order by date_created DESC ",nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);
}
