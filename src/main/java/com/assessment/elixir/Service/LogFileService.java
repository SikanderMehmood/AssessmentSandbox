package com.assessment.elixir.Service;

import com.assessment.elixir.Entity.HttpAuditLogs;
import com.assessment.elixir.Repository.LogFileRepository;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class LogFileService {

    @Autowired
    private LogFileRepository logFileRepository;
    @Autowired
    private LogsExpert logsExpert;


    public List<HttpAuditLogs> parseFile(MultipartFile file) throws IOException {
        List<HttpAuditLogs> logs = new LinkedList<>();
        InputStreamReader isReader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isReader);
        while ((reader.readLine()) != null) {
            String log = reader.readLine();
            if (log.length() > 1)
                logs.add(logsExpert.parseSingleLine(log));
        }
        return logFileRepository.saveAll(logs);
    }

    public List<HttpAuditLogs> findLogs(String date) {
        String startdate = "01/01/2019";
        String enddate = "12/12/2021";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy:HH:mm:ss");
        LocalDateTime start = formatter.parseDateTime(startdate.trim().concat(":00:00:00")).toLocalDateTime();
        LocalDateTime endDate = formatter.parseLocalDateTime(enddate.concat(":11:59:59"));
        return logFileRepository.findAllLogs(Date.valueOf(LocalDate.of(1967, 06, 22)), Date.valueOf(LocalDate.of(2022, 06, 22)));
    }
}
