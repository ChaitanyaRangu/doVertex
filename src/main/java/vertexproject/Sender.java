package vertexproject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class Sender extends AbstractVerticle {
    public void start(){
        EventBus eb = vertx.eventBus();
        vertx.setPeriodic(1000, v -> {
            eb.send("Ping-address","Ping",reply ->{
                if(reply.succeeded()){
                    System.out.println("Received Reply "+reply.result().body());
                }
                else{
                    System.out.println("No reply!!!");
                }
            });
        });
    }
}
