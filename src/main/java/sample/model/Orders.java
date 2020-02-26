package sample.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    private Date date;
    private LocalTime localTime;
    @ManyToOne(cascade=CascadeType.ALL)
    private Tables tables;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Check> dishes;
    private String сustomer;
    private String telephone;
}
