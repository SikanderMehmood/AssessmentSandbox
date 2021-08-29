package com.assessment.elixir.Entity;

public class HttpAuditLogs {

    String url;
    String date;
    String requestType;
    String completeUrl;
    String httpResponse;
    String message;

    public HttpAuditLogs() {
    }

    public HttpAuditLogs(String url, String date, String requestType, String completeUrl, String httpResponse) {
        this.url = url;
        this.date = date;
        this.requestType = requestType;
        this.completeUrl = completeUrl;
        this.httpResponse = httpResponse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCompleteUrl() {
        return completeUrl;
    }

    public void setCompleteUrl(String completeUrl) {
        this.completeUrl = completeUrl;
    }

    public String getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(String httpResponse) {
        this.httpResponse = httpResponse;
    }


}
