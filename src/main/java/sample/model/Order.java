package sample.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    private Date data;
    private LocalTime localTime;
    @ManyToOne(cascade=CascadeType.ALL)
    private Table table;
    private String сustomer;
    private String telephone;
}
