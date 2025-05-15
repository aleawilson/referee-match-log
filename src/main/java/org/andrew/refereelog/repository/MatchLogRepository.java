package org.andrew.refereelog.repository;

import org.andrew.refereelog.model.MatchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MatchLogRepository extends JpaRepository<MatchLog, Long> {
}
