package com.assessment.elixir.Repository;

import com.assessment.elixir.Entity.HttpAuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogFileRepository extends JpaRepository<HttpAuditLogs,String> {

    List<HttpAuditLogs> findByDateTimeBetween(Date start,Date end);
}
