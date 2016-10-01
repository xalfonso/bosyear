package sourcebossyear.modelo;

public class Grupo {

    private Long id;
    private String nombre;
    private int year;

    
    public void setNombre(String nombre) {
        this.nombre = nombre;        
    }

    public String getNombre() {
        return this.nombre;
    }

    public final Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    
    
}
