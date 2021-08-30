package com.assessment.elixir.Repository;

import com.assessment.elixir.config.DateTimeSandbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateTimeRepository extends JpaRepository<DateTimeSandbox,String> {
}
