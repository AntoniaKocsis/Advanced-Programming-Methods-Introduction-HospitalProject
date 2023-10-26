package Interfaces;

import Domain.Appointment;

public interface AppointmentObserver {
    void update(Appointment appointment);
}
