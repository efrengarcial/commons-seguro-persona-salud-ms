package com.segurosbolivar.seguropersonasalud.config;

import com.segurosbolivar.seguropersonasalud.repository.ListasRepository;
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
    public ListasRepository listasClient(Jaxb2Marshaller marshaller) {
        ListasRepository client = new ListasRepository();
        client.setDefaultUri("http://www.segurosbolivar.com/simon/listas/1.0");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
