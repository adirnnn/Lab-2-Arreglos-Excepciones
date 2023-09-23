// Adrian Lopez 231361
// POO Lab 2

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private int idSede; // Identificador de la sede
    private char edificio; // Código de carácter del edificio de la sede
    private int nivel; // Nivel de la sede
    private List<Edificio> edificios; // Lista de edificios asociados a la sede

    public Sede(int idSede, char edificio, int nivel) {
        this.idSede = idSede;
        this.edificio = edificio;
        this.nivel = nivel;
        this.edificios = new ArrayList<>(); // Inicialización de la lista de edificios
    }    

    // Método getter para obtener el ID de la sede
    public int getIdSede() {
        return idSede;
    }

    // Método getter para obtener el código de carácter del edificio de la sede
    public char getEdificio() {
        return edificio;
    }

    // Método getter para obtener el nivel de la sede
    public int getNivel() {
        return nivel;
    }

    // Método getter para obtener la lista de edificios asociados a la sede
    public List<Edificio> getEdificios() {
        return edificios;
    }

    // Método para agregar un objeto Edificio a la lista de edificios de la sede
    public void addEdificio(Edificio edificio) {
        edificios.add(edificio);
    }
}