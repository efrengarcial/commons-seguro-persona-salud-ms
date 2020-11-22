package com.segurosbolivar.seguropersonasalud.config;

import com.segurosbolivar.seguropersonasalud.client.ListasClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ListasServiceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.segurosbolivar.wsdl.listassservice");
        return marshaller;
    }

    @Bean
    public ListasClient listasClient(Jaxb2Marshaller marshaller) {
        ListasClient client = new ListasClient();
        client.setDefaultUri("https://ambientepruebas.segurosbolivar.com/SimonWS/ListasService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
