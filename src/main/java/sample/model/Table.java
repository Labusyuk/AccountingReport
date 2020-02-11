package sample.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated DataBase auto_increment when insert value
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    private String hall;
    private String nameNum;
    private int price;
}
