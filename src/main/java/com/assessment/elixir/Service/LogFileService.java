package com.assessment.elixir.Service;

import com.assessment.elixir.Entity.HttpAuditLogs;
import com.assessment.elixir.Repository.LogFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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

}
