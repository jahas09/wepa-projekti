
package wad.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News extends AbstractPersistable<Long>{

//    @NotEmpty
//    @Size(min = 1, max = 50)
    private String otsikko;
    private Date time;
//    @NotEmpty
//    @Size(min = 0, max = 300)
    private String ingressi;
//    @NotEmpty
    private String teksti;
//    private Long kuvaId;
    private String kirjoittaja;
    @ManyToMany
    private List<Category> kategoriat;
}
