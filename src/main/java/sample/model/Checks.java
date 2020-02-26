package sample.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Checks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    @OneToOne(cascade=CascadeType.ALL)
    private Orders orders;
    @OneToOne(cascade=CascadeType.ALL)
    private Product product;
}
