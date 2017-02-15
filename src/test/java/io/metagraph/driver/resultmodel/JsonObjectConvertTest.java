package io.metagraph.driver.resultmodel;

import io.metagraph.driver.resultmodel.metagraph.CreateResponse;
import io.metagraph.driver.resultmodel.metagraph.MetagraphResponse;
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
        String json = "{\"successful\":true,\"requestId\":\"59f85184-734e-4a8c-b3a4-ab58915b4954\",\"result\":[{\"graph_name\":[\"testGraph2\"],\"label\":\"graph\",\"id\":\"ciz6fmldf000cvi836ta6i6g4\"},{\"graph_name\":[\"testGraph2\"],\"label\":\"graph\",\"id\":\"ciz6flsja0006vi8371v03m3v\"},{\"graph_name\":[\"testGraph1\"],\"label\":\"graph\",\"id\":\"ciz6fmlck0009vi83dpe4lazu\"},{\"graph_name\":[\"testGraph2\"],\"label\":\"graph\",\"id\":\"ciz6fn2i3000ivi83udcfkpcr\"},{\"graph_name\":[\"testGraph1\"],\"label\":\"graph\",\"id\":\"ciz6fn2hi000fvi83kzu8gn5d\"},{\"graph_name\":[\"testGraph1\"],\"label\":\"graph\",\"id\":\"ciz6flsi30003vi83canj07eh\"}]}";
        MetagraphResponse metagraphResponse = JsonObjectConvert.convertToMetagraphResponse(json);
        System.out.println(metagraphResponse);
        System.out.println(json);
    }
}