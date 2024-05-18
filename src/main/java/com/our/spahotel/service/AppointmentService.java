package com.our.spahotel.service;

import com.our.spahotel.model.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto addAppointment(AppointmentDto appointmentDto);
    AppointmentDto getAppointmentById(Long id);
    AppointmentDto updateAppointment(AppointmentDto appointmentDto);
    AppointmentDto deleteTAppointment(Long id);
    List<AppointmentDto> getAllAppointment();
}
