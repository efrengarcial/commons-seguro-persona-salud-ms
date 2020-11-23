package com.segurosbolivar.seguropersonasalud.web.rest;

import com.segurosbolivar.seguropersonasalud.repository.ListasRepository;
import com.segurosbolivar.wsdl.listassservice.CatalogoDatosRespType;
import com.segurosbolivar.wsdl.listassservice.CatalogoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ListaResource controller
 */
@RestController
@RequestMapping("/seguro-persona-salud/api/v1/poliza")
public class ListaResource {

    private final Logger log = LoggerFactory.getLogger(ListaResource.class);
    private final ListasRepository listasRepository;

    public ListaResource(ListasRepository listasRepository) {
        this.listasRepository = listasRepository;
    }

    /**
    * GET getCatalogo
    */
    @GetMapping("/consulta")
    public List<CatalogoType> getCatalogo() {

        String name = "DEDUCIBLE_AUTOS";
        String param = "3;2014;6403034";
        return listasRepository.getCatalogo(name, param).getData();
        //return "getCatalogo";
    }

}
