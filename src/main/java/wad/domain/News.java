
package wad.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News extends AbstractPersistable<Long>{
    
    private String otsikko;
//    private Date time;
//    private String ingressi;
//    private ??? kuva;
    private String kirjoittaja;
//    @ManyToMany
//    private List<Category> kategoriat;
}
