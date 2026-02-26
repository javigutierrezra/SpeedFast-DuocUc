package modelo;

public class Repartidor {

    private int id;
    private String nombre;

    // Constructor con id y nombre
    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor solo con nombre (para guardar)
    public Repartidor(String nombre) {
        this.nombre = nombre;
    }

    // Constructor vacío (muy recomendable para JTable y formularios)
    public Repartidor() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}