package edu.cst.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Demur
 */
public interface HttpResponse {
    /**
     * Sets response header with a givean name and value
     * @param name
     * @param value
     */
    public void setHeader(String name, String value);

    /**
     * Sets response header with a givean name and value
     * @param headers
     */
    public void setHeaders(Map<String, String> headers);

    /**
     * Sets status code for the response
     * @param status
     */
    public void setStatus(HttpStatus.Code status);

    /**
     * Sets status code for the response
     * @param status
     */
    public void setStatus(int status) throws IllegalAccessException;

    /**
     * Sends a temporary redirect response with 307 HTTP status code
     * @param location
     */
    public void redirect(String location);

    /**
     * Sends redirect response with specified redirect status code
     * @param location
     * @param redirectStatus
     */
    public void redirect(String location, HttpStatus.Code redirectStatus);

    /**
     * Sends redirect response with specified redirect status code
     * @param location
     * @param redirectStatus
     */
    public void redirect(String location, int redirectStatus);

    /**
     * Sends error response with specified error code
     * @param errorStatus
     */
    public void error(HttpStatus.Code errorStatus) throws HttpRequestException;

    /**
     * * Sends error response with specified error code and specific body
     * @param errorStatus
     * @param body
     */
    public void error(HttpStatus.Code errorStatus, String body) throws HttpRequestException;

    /**
     * Writes passed content to underlying OutputStream
     * @param content
     */
    public void write(String content) throws IOException;

    public void write(InputStream inputStream) throws IOException;

    /**
     * Immediately flushes underlying OutputStream
     */
    public void flush() throws IOException;

    /**
     *
     */
    public HttpStatus.Code getStatusCode();

    /**
     *
     */
    public Map<String, String> getHeaders();

    /**
     *
     */
    public String getMessageBody();

}
