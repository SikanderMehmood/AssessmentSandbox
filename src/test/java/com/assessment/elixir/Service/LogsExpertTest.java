package com.assessment.elixir.Service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LogsExpertTest {

    private LogsExpert logsExpert;

    public LogsExpertTest(){
        this.logsExpert=moc
    }


    @Test
    public void checkIfDateIsPresent() {
        String s = "127.0.0.1 - - [01/Dec/2020:08:55:14 +0000] \"GET /image/layout_set_logo?img_id=20456&t=1606812914053 HTTP/1.1\" 200 3223";
        assertTrue(logsExpert.datePresent(s));
    }

}