package com.assessment.elixir.Service;

import com.assessment.elixir.Entity.HttpAuditLogs;
import net.rationalminds.LocalDateModel;
import net.rationalminds.Parser;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LogsExpert {


    public HttpAuditLogs parseSingleLine(String singleLog) {
        return new HttpAuditLogs(extractIpAddress(singleLog), extractDate(singleLog), extractRequestType(singleLog), extractCompleteRequestPath(singleLog), extractRequestStatus(singleLog));
    }

    private String extractRequestStatus(String log) {
        try {
            int index = log.lastIndexOf('"');
            return log.substring(index + 1, index + 5).trim();
        } catch (Exception ex) {
            return "error getting request status" + ex.getMessage();
        }
    }

    private String extractCompleteRequestPath(String log) {
        try {
            return log.substring(log.indexOf("/", getIndexOfGetOrPost(log)), log.lastIndexOf('"'));
        } catch (Exception ex) {
            return "error while getting request path" + ex.getMessage();
        }
    }

    private String extractRequestType(String log) {
        try {
            int index = getIndexOfGetOrPost(log);
            return log.substring(index, index + 4).trim();
        } catch (Exception ex) {
            return "error while getting request type" + ex.getMessage();
        }

    }

    private int getIndexOfGetOrPost(String log) {
        try {
            return !log.contains("GET") ? log.indexOf("POST") : log.indexOf("GET");
        } catch (Exception ex) {
            System.out.println("Error getting index");
        }
        return -1;
    }

    private Date extractDate(String log) {
        if (datePresent(log)) {
            try {
                Parser parser = new Parser();
                List<LocalDateModel> dates = parser.parse(log);
                String date1 = log.toLowerCase().subSequence(log.toLowerCase().indexOf(dates.get(0).getOriginalText()), log.toLowerCase().indexOf(dates.get(0).getOriginalText()) + 21).toString();
                return  new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss").parse(date1);
            } catch (Exception ex) {
                System.out.println("error extracting date -> " + ex.getMessage());
            }
        }
        return null;
    }


    private boolean datePresent(String log) {
        try {
            Pattern p = Pattern.compile(".*([01]?[0-9]|2[0-3]):[0-5][0-9].*");
            Matcher m = p.matcher(log);
            return m.matches();
        } catch (Exception ex) {
            System.out.println("Error while checking date");
            return false;
        }
    }

    private String extractIpAddress(String log) {
        try {
            String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
            Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
            Matcher matcher = pattern.matcher(log);
            if (matcher.find()) {
                return matcher.group();
            } else {
                return "0.0.0.0";
            }
        } catch (Exception ex) {
            return "Error while extracting ip address";
        }
    }
}
