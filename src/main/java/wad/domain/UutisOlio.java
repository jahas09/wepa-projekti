
package wad.domain;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UutisOlio {
    
    @NotEmpty
    @Size(min = 1, max = 50)
    private String otsikko;
    private Date time;
//    @NotEmpty
    @Size(min = 0, max = 300)
    private String ingressi;
//    @NotEmpty
    private String teksti;
//    private ??? kuva;
    private String kirjoittaja;
//    @ManyToMany
//    private List<Category> kategoriat;
}
