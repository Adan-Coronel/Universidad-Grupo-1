
package universidadgrupo1;

//import java.sql.Connection;
//import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import universidadgrupo1.AccesoADatos.AlumnoData;
//import universidadgrupo1.AccesoADatos.Conexion;
import universidadgrupo1.entidades.Alumno;


public class UniversidadGrupo1 {

    public static void main(String[] args){
       
        AlumnoData alu = new AlumnoData();
        Alumno ailen = new Alumno(36227887, "Amieva Lopez", "Ailen", LocalDate.of(1992, Month.JUNE, 24), true);
        alu.guardarAlumno(ailen);
        Alumno juan = new Alumno(35163871, "Pérez", "Juan", LocalDate.of(1991, 05, 30), true);//
        alu.guardarAlumno(juan);
        Alumno juan1 = new Alumno(35163871, "Pérez", "Juan Francisco", LocalDate.of(1991, 05, 30), true);
        alu.actualizarAlumno(juan1);
        Alumno buscado = alu.buscarAlumno(1);
        if(buscado != null){
            System.out.println(buscado.toString());
        }
        Alumno buscado1 = alu.buscarAlumnoPorDni(4235512);
        if(buscado1 != null){
            System.out.println(buscado1.toString());
        }
        List<Alumno> aluAct = alu.listarAlumnos();
        aluAct.forEach((alumno) -> {
            if (alumno != null) {
                System.out.println(alumno.toString());
            } else {
                System.out.println("Alumno nulo");
            }
        });
        
    }
    
}
