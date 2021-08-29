package com.assessment.elixir.Entity;


import java.util.Date;

public class HttpAuditLogs {

    String url;
    Date date;
    String requestType;
    String completeUrl;
    String httpResponse;

    public HttpAuditLogs() {
    }

    public HttpAuditLogs(String url, Date date, String requestType, String completeUrl, String httpResponse) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
