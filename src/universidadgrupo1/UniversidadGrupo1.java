
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
       
        //PRUEBAS INSERTAR ALUMNOS
        AlumnoData alu = new AlumnoData();
        Alumno ailen = new Alumno(36227887, "Amieva Lopez", "Ailen", LocalDate.of(1992, Month.JUNE, 24), true);
        alu.guardarAlumno(ailen);
        Alumno juan = new Alumno(35163871, "Pérez", "Juan", LocalDate.of(1991, 05, 30), true);//
        alu.guardarAlumno(juan);
        
        
        //PRUEBA ACTUALIZAR ALUMNO
        Alumno juan1 = new Alumno(35163871, "Pérez", "Juan Francisco", LocalDate.of(1991, 05, 30), true);
        
        alu.actualizarAlumnoPorDni(juan1);
        
        //PRUEBA BUSCAR ALUMNO
        Alumno buscado = alu.buscarAlumno(1);
        if(buscado != null){
            System.out.println(buscado.toString());
        }
        Alumno buscado1 = alu.buscarAlumnoPorDni(42553123);
        if(buscado1 != null){
            System.out.println(buscado1.toString());
        }
       
        //PRUEBA LISTAR ALUMNO
        List<Alumno> aluAct = alu.listarAlumnos();
        aluAct.forEach((alumno) -> {
            if (alumno != null) {
                System.out.println(alumno.toString());
            } else {
                System.out.println("Alumno nulo");
            }
        });
         
        //PRUEBA ELIMINAR ALUMNO (cambiar el valor de estado)
        
     
        alu.borrarAlumno(ailen.getIdAlumno());
        
        //este solo elimina si tiene el atributo estado=1
        alu.eliminarAlumno(ailen);        
       
    }
    
}
