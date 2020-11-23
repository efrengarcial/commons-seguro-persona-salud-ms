package com.segurosbolivar.seguropersonasalud.repository;

import com.segurosbolivar.wsdl.listassservice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

/**
 * https://spring.io/guides/gs/consuming-web-service/
 */
public class ListasRepository extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ListasRepository.class);

    public CatalogoDatosRespType getCatalogo(String name, String parameter) {

        CatalogoDatosReqType request = new CatalogoDatosReqType();
        JAXBElement<CatalogoDatosReqType> req = new ObjectFactory().createCatalogoDatosRequest(request);

        DataHeaderRequestType headerRequestType = new DataHeaderRequestType();
        headerRequestType.setModulo("2");
        headerRequestType.setProceso(241);
        headerRequestType.setSubProceso(240);
        headerRequestType.setCodCia(3);
        headerRequestType.setCodSecc(1);
        headerRequestType.setCodProducto(250);
        headerRequestType.setSubProducto(251);
        headerRequestType.setCodUrs("79468066");
        headerRequestType.setEntidadColocadora(1);
        headerRequestType.setCanal(3);
        headerRequestType.setSistemaOrigen(101);
        headerRequestType.setPais(1);
        headerRequestType.setDireccionIp("127.0.0.1");
        headerRequestType.setVersionServicio("1.0");
        headerRequestType.setInfo2("16659");
        headerRequestType.setInfo3("48;1");
        headerRequestType.setInfo5("55800");

        request.setDataHeader(headerRequestType);

        CatalogoSolicitudType catalogoSolicitudType= new CatalogoSolicitudType();
        catalogoSolicitudType.setNombre(name);
        catalogoSolicitudType.setParam(parameter);
        request.getData().add(catalogoSolicitudType);

        JAXBElement<CatalogoDatosRespType> response =  ( JAXBElement<CatalogoDatosRespType>)getWebServiceTemplate()
            .marshalSendAndReceive("https://ambientepruebas.segurosbolivar.com/SimonWS/ListasService", req,
                new SoapActionCallback(
                    "http://www.segurosbolivar.com/simon/listas/1.0/CatalogoDatosRespType"));

        return response.getValue();
    }
}
