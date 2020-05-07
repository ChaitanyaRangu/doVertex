package vertexproject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class Server extends AbstractVerticle {

    @Override
    public void start(){
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router
                .route("/etc/pot/")
                .handler(routingcontext -> {
                    HttpServerResponse result = routingcontext.response();
                    result.putHeader("header1","Header_value");

                    result.end("HIIIIII");
                });
        server.requestHandler(router).listen(8086);
    }

    @Override
    public void stop(){

    }
}