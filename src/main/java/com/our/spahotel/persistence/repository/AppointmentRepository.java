package com.our.spahotel.persistence.repository;

import com.our.spahotel.persistence.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
