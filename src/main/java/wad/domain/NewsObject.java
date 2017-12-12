
package wad.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsObject {
    
    private String otsikko;
    private Date time;
    private String ingressi;
    private String teksti;
    private String kirjoittaja;
    private String kategoriat;
}
