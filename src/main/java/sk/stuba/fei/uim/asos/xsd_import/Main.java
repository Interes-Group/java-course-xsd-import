package sk.stuba.fei.uim.asos.xsd_import;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/book", new BookEndpoint());
        Endpoint.publish("http://localhost:8080/paper", new PaperEndpoint());
    }
}
