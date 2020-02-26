package sample.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "`check`")
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    @OneToOne(cascade=CascadeType.ALL)
    private Order order;
    @OneToOne(cascade=CascadeType.ALL)
    private Product product;
}
