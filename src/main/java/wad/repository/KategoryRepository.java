
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Category;


public interface KategoryRepository extends JpaRepository<Category, Long>{
    
}
