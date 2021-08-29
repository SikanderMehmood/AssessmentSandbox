package com.assessment.elixir.Repository;

import com.assessment.elixir.Entity.HttpAuditLogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface LogFileRepository extends MongoRepository<HttpAuditLogs,String> {
    List<HttpAuditLogs> findAllLogs(Date valueOf, Date valueOf1);
}
