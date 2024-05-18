package com.our.spahotel.controller;

import com.our.spahotel.model.AppointmentDto;
import com.our.spahotel.service.impl.AppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private AppointmentServiceImpl appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.addAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable Long id){
        return new ResponseEntity<>(appointmentService.getAppointmentById(id),HttpStatus.OK);
    }

    @GetMapping("/appointmets")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments(){
        return new ResponseEntity<>(appointmentService.getAllAppointment(),HttpStatus.OK);
    }

    @PutMapping("/appointment")
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentDto),HttpStatus.OK);
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> deleteAppointment(@PathVariable Long id){
        return new ResponseEntity<>(appointmentService.deleteTAppointment(id),HttpStatus.OK);
    }
}
