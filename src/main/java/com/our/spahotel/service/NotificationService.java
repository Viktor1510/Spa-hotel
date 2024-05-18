package com.our.spahotel.service;

import com.our.spahotel.model.NotificationDto;

import java.util.List;

public interface NotificationService {

    NotificationDto addNotification(NotificationDto notificationDto);
    NotificationDto getNotificationById(Long id);
    NotificationDto updateNotification(Long id, NotificationDto task);
    void deleteNotification(Long id);
    List<NotificationDto> getAllNotifications();
}
