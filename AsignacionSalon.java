// Adrian Lopez 231361
// POO Lab 2

import java.util.List;

public class AsignacionSalon {
    private List<Curso> cursos; // Lista de cursos que se deben asignar a salones
    private List<Sede> sedes; // Lista de sedes donde se encuentran los salones

    // Constructor de la clase que recibe las listas de cursos y sedes
    public AsignacionSalon(List<Curso> cursos, List<Sede> sedes) {
        this.cursos = cursos;
        this.sedes = sedes;
    }

    // Método para realizar la asignación de salones a cursos
    public void asignarSalones() {
        for (Curso curso : cursos) {
            Salon salonAsignado = buscarSalonDisponible(curso);

            if (salonAsignado != null) {
                // Asignar el curso al salón
                salonAsignado.marcarOcupado(curso.getHorario());
                System.out.println("Curso asignado - ID Curso: " + curso.getIdCurso() + ", ID Salón: " + salonAsignado.getIdSalon());
            } else {
                System.out.println("No se pudo asignar un salón para el curso - ID Curso: " + curso.getIdCurso());
            }
        }
    }

    // Método para buscar un salón disponible para un curso
    private Salon buscarSalonDisponible(Curso curso) {
        int horario = curso.getHorario();
    
        // Verificar si el horario está dentro del rango válido (0 a 13)
        if (horario >= 0 && horario < 14) {
            for (Sede sede : sedes) {
                if (sede.getIdSede() == curso.getIdSede()) {
                    for (Edificio edificio : sede.getEdificios()) {
                        for (Salon salon : edificio.getSalones()) {
                            if (salon.estaDisponible(horario) && salon.getCapacidad() >= curso.getCantidadEstudiantes()) {
                                return salon;
                            }
                        }
                    }
                }
            }
        }
    
        return null; // No se encontró un salón disponible para el curso
    }    
}