package eu.itcrafters.brewstop.infrastructure.persistence.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from Category c inner join c.products products where upper(products.category.name) = upper(:name)")
    Optional<Category> findCategoryNameBy(@Param("name") String name);
}