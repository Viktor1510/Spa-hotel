package com.our.spahotel.persistence.repository;

import com.our.spahotel.persistence.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
