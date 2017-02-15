package io.metagraph.driver.resultmodel;

import io.metagraph.driver.resultmodel.metagraph.create.CreateResponse;
import io.metagraph.driver.resultmodel.metagraph.graphs.GraphsResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-15).
 */
public class JsonObjectConvertTest {
    @Test
    public void convertToGraphResponse() throws Exception {

    }

    @Test
    public void convertToMetagraphResponse() throws Exception {

    }

    @Test
    public void convertToCreateResponse() throws Exception {
        String json = "{\"successful\":true,\"requestId\":\"d6eb6168-3988-4d92-b6f3-8f3f186c8fc7\",\"result\":{\"graph_id\":\"ciz6d1naf00036l83am9ruksh\"}}";
        CreateResponse createResponse = JsonObjectConvert.convertToCreateResponse(json);
        assertNotNull(createResponse);
        assertEquals("d6eb6168-3988-4d92-b6f3-8f3f186c8fc7", createResponse.getRequestId());
        assertEquals("ciz6d1naf00036l83am9ruksh", createResponse.getResult().getGraph_id());

    }

    @Test
    public void convertToLoginResponse() throws Exception {

    }

    @Test
    public void graphs() throws Exception {
        String json = "{\"successful\":true,\"requestId\":\"16e945c8-97ed-48f5-a4f5-655ca9254658\",\"result\":[{\"graph_name\":[\"testGraph2\"],\"label\":\"graph\",\"id\":\"ciz6nhj9d0006aq83xr3o4n1z\"},{\"graph_name\":[\"testGraph1\"],\"label\":\"graph\",\"id\":\"ciz6ni9mn0009aq83ocsp39x0\"},{\"graph_name\":[\"testGraph2\"],\"label\":\"graph\",\"id\":\"ciz6ni9nc000caq830brexu5f\"},{\"graph_name\":[\"testGraph1\"],\"label\":\"graph\",\"id\":\"ciz6nhj890003aq83fwiu09v1\"}]} ";
        GraphsResponse graphsResponse = JsonObjectConvert.convertToGraphsResponse(json);
        System.out.println(graphsResponse);
        System.out.println(json);
    }
}