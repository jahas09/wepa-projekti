
package wad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.News;


public interface NewsRepository extends JpaRepository<News, Long>{
    
    News findByOtsikko(String otsikko);
}
