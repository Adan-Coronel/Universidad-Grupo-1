package universidadgrupo1;

//import java.sql.Connection;
//import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import universidadgrupo1.AccesoADatos.*;
//import universidadgrupo1.AccesoADatos.Conexion;
import universidadgrupo1.entidades.Alumno;
import universidadgrupo1.entidades.*;

public class UniversidadGrupo1 {

    public static void main(String[] args) {
/*
        //PRUEBAS INSERTAR ALUMNOS
        AlumnoData alu = new AlumnoData();
        Alumno ailen = new Alumno(36227887, "Amieva Lopez", "Ailen", LocalDate.of(1992, Month.JUNE, 24), true);
        System.out.println("ID DE AILEN ANTES DE GUARDAR EN DB");
        System.out.println(ailen.getIdAlumno());
        alu.guardarAlumno(ailen);
        System.out.println("ID DE AILEN DESPUES DE GUARDAR EN DB");
        System.out.println(ailen.getIdAlumno());
        

        Alumno juan = new Alumno(35163871, "Pérez", "Juan", LocalDate.of(1991, 05, 30), true);//
        alu.guardarAlumno(juan);

        
        //PRUEBA ACTUALIZAR ALUMNO
        Alumno tadeo = new Alumno(3, 42553123, "Wotoszyn", "Tadeo Miguel", LocalDate.of(2003, Month.OCTOBER, 30), true);
        tadeo = alu.buscarAlumno(3);
        tadeo.setNombre("Tadeo");
        alu.actualizarAlumno(tadeo);
        
        
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
            }else {
                System.out.println("Alumno nulo");
            }
        });
         
        
        //PRUEBA ELIMINAR ALUMNO (cambiar el valor de estado)
        
     
        alu.borrarAlumno(ailen.getIdAlumno());
        
        //este solo elimina si tiene el atributo estado=1
        alu.eliminarAlumno(ailen);        
       
       
       //PRUEBA INSERTAR MATERIA
      // MateriaData mate = new MateriaData();
       
//       Materia eda = new Materia(1, "Estructura de datos", true);
//       Materia ingles = new Materia (2, "Ingles", true);
//       
//       mate.guardarMateria(eda);
//       mate.guardarMateria(ingles);
//       
       //PRUEBA BUSCAR MATERIA
       
        //System.out.println(mate.buscarMateria(1).toString());
        //System.out.println(mate.buscarMateria(6).toString());
        
        
        //PRUEBA ACTUALIZAR MATERIA (ponemos a EDA en segundo año)
        //Materia eda = new Materia(5, 2, "Estructura de datos", true);
        //mate.actualizarMateria(eda);
        
        
        //PRUEBA ELIMINAR UNA MATERIA
//        Materia comp = new Materia (1, "Compresión de texto", true);
//        mate.guardarMateria(comp);
//        mate.eliminarMateria(comp);
        
        //PRUEBA LISTAR MATERIAS SOLO ACTIVAS
        List<Materia> materias = new ArrayList<Materia>();
        materias = mate.listarMaterias();
        for (Materia materia : materias) {
            System.out.println(materia.toString());
        }
         */
    }

}
