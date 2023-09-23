// Adrian Lopez 231361
// POO Lab 2

public class Salon {
    private int idSalon; // Identificador único del salón
    private int capacidad; // Capacidad máxima de estudiantes que puede albergar el salón
    private int[] horarioDisponibilidad; // Representación del horario de disponibilidad

    // Constructor de la clase que recibe el ID del salón y su capacidad
    public Salon(int idSalon, int capacidad) {
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.horarioDisponibilidad = new int[14]; // El horario se representa de 7:00 AM a 9:00 PM
    }

    // Método para verificar la disponibilidad en un período de tiempo específico
    public boolean estaDisponible(int periodo) {
        return horarioDisponibilidad[periodo] == 0; // 0 indica que el salón está disponible en ese período
    }

    // Método para marcar un período de tiempo como ocupado
    public void marcarOcupado(int periodo) {
        horarioDisponibilidad[periodo] = 1; // 1 indica que el salón está ocupado en ese período
    }

    // Getter para obtener el ID del salón
    public int getIdSalon() {
        return idSalon;
    }

    // Setter para establecer el ID del salón
    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    // Getter para obtener la capacidad del salón
    public int getCapacidad() {
        return capacidad;
    }

    // Setter para establecer la capacidad del salón
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Getter para obtener el horario de disponibilidad del salón
    public int[] getHorarioDisponibilidad() {
        return horarioDisponibilidad;
    }

    // Setter para establecer el horario de disponibilidad del salón
    public void setHorarioDisponibilidad(int[] horarioDisponibilidad) {
        this.horarioDisponibilidad = horarioDisponibilidad;
    }
}