package fruit.demo.repository;

import javax.enterprise.context.ApplicationScoped;
import fruit.demo.model.Fruit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    public Fruit findByName(String name) {
        return find("name", name).firstResult();
    }
    
}
