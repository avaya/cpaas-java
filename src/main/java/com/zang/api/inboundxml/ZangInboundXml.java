package com.zang.api.inboundxml;

import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.elements.ResponseBuilder;

/**
 * Utility class for creating an InboundXml document.
 * @see ResponseBuilder
 */
public class ZangInboundXml {

    /**
     * Utility method for creating an InboundXml document. Calls Response.builder();
     * @return A new ResponseBuilder to start creating an InboundXml document.
     * @see ResponseBuilder
     */
    public static ResponseBuilder builder() {
        return Response.builder();
    }

}
