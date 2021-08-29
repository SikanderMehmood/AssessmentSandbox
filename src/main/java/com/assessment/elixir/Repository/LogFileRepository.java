package com.assessment.elixir.Repository;

import com.assessment.elixir.Entity.HttpAuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogFileRepository extends JpaRepository<HttpAuditLogs,String> {
}
