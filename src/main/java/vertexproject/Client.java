package vertexproject;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

public class Client extends AbstractVerticle {

    @Override
    public void start(){
        WebClient client = WebClient.create(vertx);
        client
                .get(9095,"localhost","/etc/pot/")
                .send(ar->{
                    if(ar.succeeded()){
                        HttpResponse< Buffer > response = ar.result();
                        System.out.println("Response received with status code "+ response.statusCode());
                    }
                    else{
                        System.out.println("something went wrong "+ar.cause().getMessage());
                    }
                });
    }
}
