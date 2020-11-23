package fruit.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "basket_fruit")
@NoArgsConstructor
public class BasketFruit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "basket_id")
    private Long basketId;

    @Column(name = "fruit_id")
    private Long fruitId;
}
