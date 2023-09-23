// Adrian Lopez 231361
// POO Lab 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Cargar datos desde archivos CSV
        List<Sede> sedes = cargarSedesDesdeCSV("salones.csv"); // Cargar datos de sedes desde el archivo "salones.csv"
        List<Curso> cursos = cargarCursosDesdeCSV("cursos.csv"); // Cargar datos de cursos desde el archivo "cursos.csv"

        // 2. Crear una instancia de AsignacionSalon y asignar los salones a los cursos
        AsignacionSalon asignacionSalon = new AsignacionSalon(cursos, sedes); // Crear un objeto de asignación de salones
        asignacionSalon.asignarSalones(); // Asignar salones a los cursos

        // 3. Crear una instancia de Informe y agregar cursos asignados y no asignados
        Informe informe = new Informe(); // Crear un objeto de informe

        for (Curso curso : cursos) {
            if (curso.getSalonAsignado() != null) {
                informe.agregarCursoAsignado(curso); // Agregar cursos asignados al informe
            } else {
                informe.agregarCursoNoAsignado(curso); // Agregar cursos no asignados al informe
            }
        }

        // 4. Generar y mostrar el informe
        informe.generarInforme(); // Generar el informe y mostrarlo en la consola

        // 5. Exportar el resultado a un archivo CSV
        informe.exportarResultado("informe.csv"); // Exportar el informe a un archivo CSV
    }

    private static List<Sede> cargarSedesDesdeCSV(String archivo) {
        List<Sede> sedes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            br.readLine(); // Leer y descartar la línea de encabezado del archivo

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idSede = Integer.parseInt(partes[0]);
                char edificio = partes[1].charAt(0);
                int nivel = Integer.parseInt(partes[2]);
                int idSalon = Integer.parseInt(partes[3]);
                int capacidad = Integer.parseInt(partes[4]);

                Sede sede = null;
                Edificio edificioEncontrado = null;

                // Comprobar si la sede con idSede ya existe en la lista
                for (Sede existingSede : sedes) {
                    if (existingSede.getIdSede() == idSede) {
                        sede = existingSede;
                        break;
                    }
                }

                if (sede == null) {
                    sede = new Sede(idSede, edificio, nivel);
                    sedes.add(sede); // Agregar la sede a la lista de sedes
                }

                // Comprobar si el edificio con edificio y nivel ya existe dentro de la sede
                for (Edificio existingEdificio : sede.getEdificios()) {
                    if (existingEdificio.getEdificio() == edificio && existingEdificio.getNivel() == nivel) {
                        edificioEncontrado = existingEdificio;
                        break;
                    }
                }

                if (edificioEncontrado == null) {
                    edificioEncontrado = new Edificio(edificio, nivel);
                    sede.addEdificio(edificioEncontrado); // Agregar el edificio a la sede
                }

                Salon salon = new Salon(idSalon, capacidad);
                edificioEncontrado.addSalon(salon); // Agregar el salón al edificio
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sedes;
    }

    private static List<Curso> cargarCursosDesdeCSV(String archivo) {
        List<Curso> cursos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            br.readLine(); // Leer y descartar la línea de encabezado del archivo

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idCurso = Integer.parseInt(partes[0]);
                int idSede = Integer.parseInt(partes[1]);
                String nombreCurso = partes[2];
                int horario = Integer.parseInt(partes[3]);
                int duracion = Integer.parseInt(partes[4]);
                String[] dias = partes[5].split(",");
                int cantidadEstudiantes = Integer.parseInt(partes[6]);

                Curso curso = new Curso(idCurso, idSede, nombreCurso, horario, duracion, dias, cantidadEstudiantes);
                cursos.add(curso); // Agregar el curso a la lista de cursos
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cursos;
    }
}