package com.assessment.elixir.config;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class GenericDateSerializerModule extends SimpleModule {
    public static final StdScalarDeserializer<LocalDateTime> DATE_TIME_STD_SCALAR_DESERIALIZER =
            new StdScalarDeserializer<LocalDateTime>(LocalDate.class) {

                private DateTimeFormatter[] dtfs =  {
                        new DateTimeFormatterBuilder()
                                .appendPattern("MM/dd/yyyy")
                                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                                .toFormatter(),
                        DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"),
                        DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")
                };

                @Override
                public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                        throws IOException {
                    if (jsonParser.getCurrentTokenId() == JsonTokenId.ID_STRING) {
                        String string = jsonParser.getText().trim();
                        for (DateTimeFormatter dtf : dtfs) {
                            try {
                                return LocalDateTime.parse(string, dtf);
                            } catch(Exception e) {
                                System.err.println(e);
                            }
                        }
                    }
                    return null;
                }
            };

    public GenericDateSerializerModule() {
        addDeserializer(LocalDateTime.class, DATE_TIME_STD_SCALAR_DESERIALIZER);
    }

}
