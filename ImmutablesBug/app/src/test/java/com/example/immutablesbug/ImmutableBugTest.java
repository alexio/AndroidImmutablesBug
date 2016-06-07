package com.example.immutablesbug;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ImmutableBugTest {

    private static final String SAMPLE_RESPONSE = "{\"status\" : \"OK\", \"results\" : [{ \"tags\" : []}]}";
    private Gson gson;

    @Before
    public void setup() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new GsonAdaptersResponse());
        gsonBuilder.registerTypeAdapterFactory(new GsonAdaptersResponseResult());
        gson = gsonBuilder.create();
    }

    @Test
    public void testObjectParsing() throws Exception {
        Response response = gson.fromJson(SAMPLE_RESPONSE, Response.class);
        assertNotNull(response);
        assertNotNull(response.status());
        assertNotNull(response.results());
        assertEquals("Results one object", 1, response.results().size());
        assertNotNull("Tags should not be null", response.results().get(0).tags());
        assertTrue(response.results().get(0).tags().isEmpty());
    }
}