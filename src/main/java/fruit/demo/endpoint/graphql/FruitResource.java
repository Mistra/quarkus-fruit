package fruit.demo.endpoint.graphql;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import fruit.demo.model.Basket;
import fruit.demo.model.Fruit;
import fruit.demo.service.FruitService;

@GraphQLApi
public class FruitResource {

    private FruitService fruitService;

    @Inject
    public FruitResource(FruitService fruitService) {
        this.fruitService = fruitService;

    }

    @Query("fruits")
    @Description("Get all Fruits")
    public List<Fruit> getAllFruits(@Name("first") @DefaultValue("0") long first,
            @Name("offset") @DefaultValue("100") long offset) {
        return fruitService.findAll().stream().skip(first).limit(offset)
                .collect(Collectors.toList());
    }

    @Query
    @Description("Get a Fruit by ID")
    public Fruit getFruit(@Name("id") long id) {
        return fruitService.findById(id);
    }

    public List<Fruit> fruits(@Source Basket basket, @Name("first") @DefaultValue("0") long first,
            @Name("offset") @DefaultValue("100") long offset) {
        return fruitService.findContainedIntoBasket(basket).stream().skip(first).limit(offset)
                .collect(Collectors.toList());
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
