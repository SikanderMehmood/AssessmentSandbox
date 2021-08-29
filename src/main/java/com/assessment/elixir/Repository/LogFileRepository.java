package com.assessment.elixir.Repository;

import com.assessment.elixir.Entity.HttpAuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogFileRepository extends JpaRepository<HttpAuditLogs,String> {

    @Query(
            value = "SELECT * FROM `http_audit_logs`\n" +
                    "WHERE `date_time` >= @startDate\n" +
                    "AND   `date_time` <  @endDate",
            nativeQuery = true
    )
    List<HttpAuditLogs> findAllLogs(Date startDate, Date endDate);


    List<HttpAuditLogs> findByDateTimeBetween(Date start,Date end);
}
