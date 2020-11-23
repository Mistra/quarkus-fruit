package fruit.demo.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import fruit.demo.model.BasketFruit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BasketFruitRepository implements PanacheRepository<BasketFruit> {

    public List<BasketFruit> findByFruitId(Long id) {
        return find("fruitId", id).list();
    }

    public List<BasketFruit> findByBasketId(Long id) {
        return find("basketId", id).list();
    }
}
