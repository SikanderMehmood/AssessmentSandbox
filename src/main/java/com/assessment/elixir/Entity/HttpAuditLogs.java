package com.assessment.elixir.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class HttpAuditLogs {

    @Id
    @SequenceGenerator(name = "log_sequence", sequenceName = "log_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_sequence")
    @Column(name = "logId", nullable = false, columnDefinition = "int default 1")
    int id;
    String url;
    @Column(length = 65555)
    @JsonDeserialize(using= LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    DateTime dataTime;
    String requestType;
    @Column(columnDefinition = "TEXT")
    String resourceurl;
    String status;

    public HttpAuditLogs() {
    }

    public HttpAuditLogs(String url, DateTime dataTime, String requestType, String resourceurl, String status) {
        this.url = url;
        this.dataTime = dataTime;
        this.requestType = requestType;
        this.resourceurl = resourceurl;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DateTime getDate() {
        return dataTime;
    }

    public void setDate(DateTime date) {
        this.dataTime = date;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCompleteUrl() {
        return resourceurl;
    }

    public void setCompleteUrl(String completeUrl) {
        this.resourceurl = completeUrl;
    }

    public String getHttpResponse() {
        return status;
    }

    public void setHttpResponse(String httpResponse) {
        this.status = httpResponse;
    }


}
