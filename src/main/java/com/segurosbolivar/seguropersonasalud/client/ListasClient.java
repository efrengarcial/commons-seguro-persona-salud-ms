package com.segurosbolivar.seguropersonasalud.client;

import com.segurosbolivar.wsdl.listassservice.CatalogoDatosReqType;
import com.segurosbolivar.wsdl.listassservice.CatalogoDatosRespType;
import com.segurosbolivar.wsdl.listassservice.CatalogoSolicitudType;
import com.segurosbolivar.wsdl.listassservice.DataHeaderRequestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ListasClient  extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ListasClient.class);

    public CatalogoDatosRespType getCatalogo(String name) {

        CatalogoDatosReqType request = new CatalogoDatosReqType();
        DataHeaderRequestType headerRequestType = new DataHeaderRequestType();
        request.setDataHeader(headerRequestType);

        CatalogoSolicitudType catalogoSolicitudType= new CatalogoSolicitudType();
        catalogoSolicitudType.setNombre(name);
        request.getData().add(catalogoSolicitudType);

        CatalogoDatosRespType response = (CatalogoDatosRespType) getWebServiceTemplate()
            .marshalSendAndReceive(request);

        return response;
    }
}
