package com.segurosbolivar.seguropersonasalud.web.rest;

import com.segurosbolivar.seguropersonasalud.CommonsseguropersonasaludmsApp;
import com.segurosbolivar.seguropersonasalud.repository.ListasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the ListaResource REST controller.
 *
 * @see ListaResource
 */
@SpringBootTest(classes = CommonsseguropersonasaludmsApp.class)
public class ListaResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ListasRepository listasRepository = null;
        ListaResource listaResource = new ListaResource(listasRepository);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(listaResource)
            .build();
    }

    /**
     * Test getCatalogo
     */
    @Test
    public void testGetCatalogo() throws Exception {
        restMockMvc.perform(get("/seguro-persona-salud/api/v1/poliza/consulta"))
            .andExpect(status().isOk());
    }
}
