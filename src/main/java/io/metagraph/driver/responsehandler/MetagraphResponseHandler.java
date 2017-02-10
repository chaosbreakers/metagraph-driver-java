package io.metagraph.driver.responsehandler;

import io.metagraph.driver.resultmodel.ReturnType;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * handler for REST services.
 * Created by (zhaoliang@metagraph.io) on (17-2-9).
 */
public class MetagraphResponseHandler<T> implements ResponseHandler<T> {
    private ReturnType type;

    public MetagraphResponseHandler(ReturnType type) {
        this.type = type;
    }

    @Override
    public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content");
        }
        ContentType contentType = ContentType.getOrDefault(entity);
        if (!contentType.equals(ContentType.APPLICATION_JSON)) {
            throw new ClientProtocolException("Unexpected content type:" + contentType);
        }
        String charset = contentType.getCharset().name();
        return null;
    }
}
