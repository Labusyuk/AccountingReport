package sample.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "order_id", nullable = false, insertable = true, updatable = true)
    private int order_id;
    private String name;
    private int count;
    private int price;
}
