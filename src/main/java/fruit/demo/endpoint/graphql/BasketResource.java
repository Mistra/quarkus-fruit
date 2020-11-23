package fruit.demo.endpoint.graphql;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import fruit.demo.model.Basket;
import fruit.demo.model.Fruit;
import fruit.demo.service.BasketService;

@GraphQLApi
public class BasketResource {

    private BasketService basketService;

    @Inject
    public BasketResource(BasketService basketService) {
        super();
        this.basketService = basketService;

    }

    @Query("allBaskets")
    @Description("Get all Baskets")
    public List<Basket> getAllBaskets() {
        return basketService.findAll();
    }

    @Query
    @Description("Get a Basket by ID")
    public Basket getBasket(@Name("id") long id) {
        return basketService.findById(id);
    }

    public List<Basket> baskets(@Source Fruit fruit) {
        return basketService.findContainingFuit(fruit);
    }

    // @Mutation
    // public Hero createHero(Hero hero) {
    // service.addHero(hero);
    // return hero;
    // }

    // @Mutation
    // public Hero deleteHero(int id) {
    // return service.deleteHero(id);
    // }

    // @Query
    // public List<Hero> getHeroesWithSurname(@DefaultValue("Skywalker") String surname) {
    // return service.getHeroesBySurname(surname);
    // }

}
