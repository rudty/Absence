package org.rudtyz.absence.repository;

import org.rudtyz.absence.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    Optional<Absence> findAbsenceByBeginDateAndEndDate(Date beginDate, Date endDate);
}
