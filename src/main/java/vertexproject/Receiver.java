package vertexproject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class Receiver extends AbstractVerticle {
    public void start(){
        EventBus eb = vertx.eventBus();
        eb.consumer("Ping-address",message -> {
            System.out.println("Received Message"+message.body());
            message.reply("pong");
        });
        System.out.println("Receiver Ready!");
    }
}
