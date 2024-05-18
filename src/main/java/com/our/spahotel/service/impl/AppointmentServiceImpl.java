package com.our.spahotel.service.impl;

import com.our.spahotel.exception.AppointmentNotFoundException;
import com.our.spahotel.model.AppointmentDto;
import com.our.spahotel.persistence.Appointment;
import com.our.spahotel.persistence.User;
import com.our.spahotel.persistence.repository.AppointmentRepository;
import com.our.spahotel.persistence.repository.UserRepository;
import com.our.spahotel.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private ModelMapper modelMapper;
    private AppointmentRepository appointmentRepository;

    private UserRepository userRepository;


    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointment=mapToEntity(appointmentDto);
        appointmentRepository.save(appointment);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        appointment.setUser(user);

        return mapToDto(appointment);
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment=appointmentRepository.findById(id)
                .orElseThrow( ()->new AppointmentNotFoundException("appointment","id",id.toString()));
        return mapToDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        Appointment appointment=appointmentRepository.findById(appointmentDto.getId())
                .orElseThrow( ()->new AppointmentNotFoundException("appointment","id",appointmentDto.getId().toString()));

        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());


        appointmentRepository.save(appointment);

        return mapToDto(appointment);
    }

    @Override
    public AppointmentDto deleteTAppointment(Long id) {
        Appointment appointment=appointmentRepository.findById(id)
                .orElseThrow( ()->new AppointmentNotFoundException("appointment","id",id.toString()));
        appointmentRepository.delete(appointment);
        return mapToDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> tasks = appointmentRepository.findAll();
        return tasks
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private AppointmentDto mapToDto(Appointment appointment){ return modelMapper.map(appointment, AppointmentDto.class);
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto){ return modelMapper.map(appointmentDto, Appointment.class);}
}
