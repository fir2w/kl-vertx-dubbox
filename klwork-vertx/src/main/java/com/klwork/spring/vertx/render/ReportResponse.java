package com.klwork.spring.vertx.render;

import com.klwork.rest.enums.HttpStatus;
import io.vertx.core.buffer.Buffer;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwei on 2015/6/11.
 */
public class ReportResponse {
    private Map<String, String> headers = new HashMap();
    private InputStream inputStream;
    private Buffer chunk;
    private HttpStatus status;

    private long size;

    private void init() {
        this.headers.put("server", "netfinworks-Rest-Server");
        this.status = HttpStatus.OK;
    }

    public Buffer getChunk() {
        return chunk;
    }

    public void setChunk(Buffer chunk) {
        this.chunk = chunk;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ReportResponse() {
        this.init();
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public String[] getHeaderNames() {
        return StringUtils.toStringArray(this.headers.keySet());
    }

    public String getHeader(String name) {
        return (String)this.headers.get(name);
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
