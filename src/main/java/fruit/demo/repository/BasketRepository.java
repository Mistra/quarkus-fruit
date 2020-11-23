package fruit.demo.repository;

import javax.enterprise.context.ApplicationScoped;
import fruit.demo.model.Basket;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BasketRepository implements PanacheRepository<Basket> {

    public Basket findByName(String name) {
        return find("name", name).firstResult();
    }
    
}
