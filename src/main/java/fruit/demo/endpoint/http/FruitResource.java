package fruit.demo.endpoint.http;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import fruit.demo.model.Fruit;
import fruit.demo.service.FruitService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FruitResource {

    @Inject
    public FruitResource(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    private FruitService fruitService;

    @GET
    public List<Fruit> get() {
        return fruitService.findAll();
    }

    // TODO: spostare in BasketResource
    // @GET
    // @Path("gne/{id}")
    // public List<Basket> getBasketsByFruitId(@PathParam Long id) {
    // return fruitService.find
    // List<BasketFruit> combos = bfrepo.findByFruitId(id);
    // return combos.stream().map(BasketFruit::getBasketId).map(basketRepo::findById)
    // .collect(Collectors.toList());
    // }

    @GET
    @Path("{id}")
    public Fruit getSingle(@PathParam Long id) {
        return fruitService.findById(id);
    }

    @POST
    @Transactional
    public Fruit create(Fruit fruit) {
        return fruitService.save(fruit);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Fruit update(@PathParam Long id, Fruit fruit) {
        if (fruit.getName() == null) {
            throw new WebApplicationException("Fruit Name was not set on request.", 422);
        }

        Fruit entity = fruitService.findById(id);

        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }

        entity.setName(fruit.getName());

        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam Long id) {
        Fruit entity = fruitService.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        fruitService.delete(id);
        return Response.status(204).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response
                    .status(code).entity(Json.createObjectBuilder()
                            .add("error", exception.getMessage()).add("code", code).build())
                    .build();
        }

    }

    private void handleNullFruit(Fruit fruit) {
        if (fruit == null) {
            throw new WebApplicationException("Fruit with this id does not exist.", 404);
        }
    }
}
