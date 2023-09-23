// Adrian Lopez 231361
// POO Lab 2

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Informe {
    private List<Curso> cursosNoAsignados; // Lista de cursos no asignados
    private List<Curso> cursosAsignados; // Lista de cursos asignados

    public Informe() {
        this.cursosNoAsignados = new ArrayList<>();
        this.cursosAsignados = new ArrayList<>();
    }

    // Método para agregar un curso no asignado al informe
    public void agregarCursoNoAsignado(Curso curso) {
        cursosNoAsignados.add(curso);
    }

    // Método para agregar un curso asignado al informe
    public void agregarCursoAsignado(Curso curso) {
        cursosAsignados.add(curso);
    }

    // Método para generar y mostrar el informe
    public void generarInforme() {
        System.out.println("----- Informe de Asignación de Salones -----");
        System.out.println("Cursos Asignados:");
        for (Curso curso : cursosAsignados) {
            mostrarCurso(curso);
        }
        System.out.println("\nCursos No Asignados:");
        for (Curso curso : cursosNoAsignados) {
            mostrarCurso(curso);
        }
    }

    // Método para exportar el resultado a un archivo CSV
    public void exportarResultado(String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo);

            // Escribir encabezados en el archivo CSV
            writer.append("ID Curso,Nombre Curso,Horario,Días,Cantidad Estudiantes\n");

            // Escribir cursos asignados en el archivo CSV
            for (Curso curso : cursosAsignados) {
                writer.append(curso.getIdCurso() + ",");
                writer.append(curso.getNombreCurso() + ",");
                writer.append(curso.getHorario() + ",");
                writer.append(String.join(",", curso.getDias()) + ",");
                writer.append(curso.getCantidadEstudiantes() + "\n");
            }

            // Escribir cursos no asignados en el archivo CSV
            for (Curso curso : cursosNoAsignados) {
                writer.append(curso.getIdCurso() + ",");
                writer.append(curso.getNombreCurso() + ",");
                writer.append(curso.getHorario() + ",");
                writer.append(String.join(",", curso.getDias()) + ",");
                writer.append(curso.getCantidadEstudiantes() + "\n");
            }

            writer.flush();
            writer.close();
            System.out.println("Resultado exportado a " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al exportar el resultado: " + e.getMessage());
        }
    }

    // Método para mostrar los detalles de un curso en la consola
    private void mostrarCurso(Curso curso) {
        System.out.println("ID Curso: " + curso.getIdCurso());
        System.out.println("Nombre Curso: " + curso.getNombreCurso());
        System.out.println("Horario: " + curso.getHorario());
        System.out.println("Días: " + String.join(", ", curso.getDias()));
        System.out.println("Cantidad Estudiantes: " + curso.getCantidadEstudiantes() + "\n");
    }
}