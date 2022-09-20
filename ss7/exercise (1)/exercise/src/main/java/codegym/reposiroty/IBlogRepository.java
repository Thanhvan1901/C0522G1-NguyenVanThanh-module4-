package codegym.reposiroty;

import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
//    @Query(value = "select * from blog where blog_name like %:keyword%",nativeQuery = true)
//    Page<Blog> searchByName(@Param("keyword") String name, Pageable pageable);
//
//    @Query(value = "select  * from blog order by date DESC ",nativeQuery = true)
//    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByBlogNameContaining(String name,Pageable pageable);
}
