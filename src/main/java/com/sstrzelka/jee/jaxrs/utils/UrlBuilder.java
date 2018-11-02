package com.sstrzelka.jee.jaxrs.utils;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class UrlBuilder {
    public static URI build(Class<?> className, String method, Object... vals) {
        return UriBuilder.fromResource(className).path(className, method).build(vals);
    }
}
