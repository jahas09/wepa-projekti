
package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account extends AbstractPersistable<Long>{
    
    @NotEmpty
    @Size(min = 1, max = 30)
    private String username;
    @NotEmpty
    @Size(min = 6)
    private String password;
}
