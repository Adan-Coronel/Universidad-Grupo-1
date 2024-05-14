
package universidadgrupo1.entidades;


public class Materia {
    int idMateria, anio;
    String nombre;
    boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, int anio, String nombre, boolean estado) {
        this.idMateria = idMateria;
        this.anio = anio;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Materia(int anio, String nombre, boolean estado) {
        this.anio = anio;
        this.nombre = nombre;
        this.estado = estado;
    }
    

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", anio=" + anio + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
}
