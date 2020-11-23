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
import fruit.demo.repository.BasketRepository;

@ApplicationScoped
public class BasketService {

    private BasketRepository basketRepo;
    private BasketFruitRepository basketFruitRepo;

    @Inject
    public BasketService(BasketRepository basketRepo, BasketFruitRepository basketFruitRepo) {
        this.basketFruitRepo = basketFruitRepo;
        this.basketRepo = basketRepo;
    }

    @Transactional
    public Basket save(Basket basket) {
        basketRepo.persist(basket);
        return basket;
    }

    public List<Basket> findAll() {
        return basketRepo.listAll();
    }

    public Basket findById(Long id) {
        return basketRepo.findById(id);
    }

    public List<Basket> findContainingFuit(Long fruitId) {
        return basketFruitRepo.findByFruitId(fruitId).stream().map(BasketFruit::getBasketId)
                .map(basketRepo::findById).collect(Collectors.toList());
    }

    public List<Basket> findContainingFuit(Fruit fruit) {
        return findContainingFuit(fruit.getId());
    }

    public void delete(Long basketId) {
        basketRepo.deleteById(basketId);
    }

    public void delete(Basket basket) {
        basketRepo.delete(basket);
    }
}
