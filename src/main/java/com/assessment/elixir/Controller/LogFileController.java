package com.assessment.elixir.Controller;


import com.assessment.elixir.Entity.HttpAuditLogs;
import com.assessment.elixir.Service.LogFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogFileController {

    @Autowired
    private LogFileService logFileService;

    @PostMapping(value = "/file/")
    public List<HttpAuditLogs> parseLogFile(@RequestParam("file") MultipartFile file) throws IOException {
        return logFileService.parseFile(file);
    }


}
