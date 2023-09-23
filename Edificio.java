// Adrian Lopez 231361
// POO Lab 2

import java.util.ArrayList;
import java.util.List;

public class Edificio {
    private char edificio; // Representa el código o nombre del edificio
    private int nivel; // Representa el nivel o piso del edificio
    private List<Salon> salones; // Almacena una lista de objetos Salon en este edificio

    // Constructor de la clase que recibe el código del edificio y el nivel
    public Edificio(char edificio, int nivel) {
        this.edificio = edificio;
        this.nivel = nivel;
        this.salones = new ArrayList<>(); // Inicializa la lista de salones como una lista vacía
    }

    // Método para agregar un salón a la lista de salones en este edificio
    public void addSalon(Salon salon) {
        salones.add(salon);
    }

    // Getter para obtener el código o nombre del edificio
    public char getEdificio() {
        return edificio;
    }

    // Getter para obtener el nivel o piso del edificio
    public int getNivel() {
        return nivel;
    }

    // Getter para obtener la lista de salones en este edificio
    public List<Salon> getSalones() {
        return salones;
    }
}