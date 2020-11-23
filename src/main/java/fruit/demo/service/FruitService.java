package fruit.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import fruit.demo.model.Basket;
import fruit.demo.model.BasketFruit;
import fruit.demo.model.Fruit;
import fruit.demo.repository.BasketFruitRepository;
import fruit.demo.repository.FruitRepository;

@ApplicationScoped
public class FruitService {

    private FruitRepository fruitRepo;
    private BasketFruitRepository basketFruitRepo;

    @Inject
    public FruitService(FruitRepository fruitRepo, BasketFruitRepository basketFruitRepo) {
        this.basketFruitRepo = basketFruitRepo;
        this.fruitRepo = fruitRepo;
    }

    @Transactional
    public Fruit save(Fruit fruit) {
        fruitRepo.persist(fruit);
        return fruit;
    }

    public List<Fruit> findAll() {
        return fruitRepo.listAll();
    }

    public Fruit findById(Long id) {
        return fruitRepo.findById(id);
    }

    public List<Fruit> findContainedIntoBasket(Long basketId) {
        return basketFruitRepo.findByBasketId(basketId).stream().map(BasketFruit::getFruitId)
                .map(fruitRepo::findById).collect(Collectors.toList());
    }

    public List<Fruit> findContainedIntoBasket(Basket basket) {
        return findContainedIntoBasket(basket.getId());
    }

    public void delete(Long fruitId) {
        fruitRepo.deleteById(fruitId);
    }

    public void delete(Fruit fruit) {
        fruitRepo.delete(fruit);
    }
}
