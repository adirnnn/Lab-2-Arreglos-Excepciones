// Adrian Lopez 231361
// POO Lab 2

public class Curso {
    private int idCurso; // Identificador del curso
    private int idSede; // Identificador de la sede
    private String nombreCurso; // Nombre del curso
    private int horario; // Horario del curso
    private int duracion; // Duración del curso en períodos
    private String[] dias; // Días de la semana en los que se imparte el curso
    private int cantidadEstudiantes; // Cantidad de estudiantes en el curso

    public Curso(int idCurso, int idSede, String nombreCurso, int horario, int duracion, String[] dias, int cantidadEstudiantes) {
        this.idCurso = idCurso;
        this.idSede = idSede;
        this.nombreCurso = nombreCurso;
        this.horario = horario;
        this.duracion = duracion;
        this.dias = dias;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    // Métodos getter y setter para todos los atributos

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String[] getDias() {
        return dias;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    private Salon salonAsignado; // Salón asignado para este curso

    public Salon getSalonAsignado() {
        return salonAsignado;
    }
}