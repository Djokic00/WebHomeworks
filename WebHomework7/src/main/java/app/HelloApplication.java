package app;


import app.repositories.post.MySqlPostRepository;
import app.repositories.post.PostRepository;
import app.services.PostService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/index")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                // Singleton - Znaci da ce repository da se napravi samo jednom i sacuvaj u mapu, a ne svaki put kad dodje novi request
                // Bez obzira na to sto ce resource da se instancira svaki put
                this.bind(MySqlPostRepository.class).to(PostRepository.class).in(Singleton.class);
                // kad nemamo interfejs koristimo bindAsContract
                // svaki put kad dodje zahtev pravimo PostService, ali PostRepository se nece praviti opet
                this.bindAsContract(PostService.class);
            }
        };
        register(binder);
        packages("app");
    }
}