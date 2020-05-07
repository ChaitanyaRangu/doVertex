package vertexproject;


import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class MyMainClass {
    public static void main(String args[]){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Receiver());
        vertx.deployVerticle(new Sender());

    }
}
