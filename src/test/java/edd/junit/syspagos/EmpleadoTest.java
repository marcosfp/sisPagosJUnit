package edd.junit.syspagos;

import edd.junit.syspagos.excepciones.CargoException;
import edd.junit.syspagos.excepciones.MesesTrabajoException;
import edd.junit.syspagos.excepciones.NombreEmpleadoException;
import edd.junit.syspagos.excepciones.NumeroEmpleadoException;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmpleadoTest {

    @Test @DisplayName("Establecer numero rango valido")
    public void establecerNumero_empleado_Correcto() {

        Empleado e = new Empleado();
        try {
            e.establecerNumero_empleado("004");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(004,e.getNumero_empleado());
    }

    @Test @DisplayName("Establecer numero limite 000")
    public void establecerNumero_empleado_000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("000");
        });
    }

    @Test @DisplayName("Establecer numero limite 1000 ")
    public void establecerNumero_empleado_1000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("1000");
        });
    }

    @Test @DisplayName("Establecer numero incorrecto")
    public void establecerNumero_empleado_Negativo() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("-415");
        });
    }

    @Test @DisplayName("Establecer numero de diferente longitud a 3")
    public void establecerNumero_empleado_diferenteLongitud() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("4");
        });
    }

    @Test @DisplayName("Establecer nombre de empleado correcto")
    public void establecerNombre_empleado_Correcto() {

        Empleado e = new Empleado();
        try {
            e.estableceNombre_empleado("PORQUELAVIDAESTANCRUEL");
        } catch (NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals("PORQUELAVIDAESTANCRUEL",e.getNombre_empleado());
    }

    @Test @DisplayName("Establecer nombre de empleado menor a 10 caracteres")
    public void establecerNombre_empleado_Menor10Caracteres() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () -> {
            e.estableceNombre_empleado("HOLA");
        });
    }

    @Test @DisplayName("Establecer nombre de empleado vacio")
    public void establecerNombre_empleado_Vacio() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () -> {
            e.estableceNombre_empleado("");
        });
    }

    @Test @DisplayName("Establecer nombre de empleado nulo")
    public void establecerNombre_empleado_Null() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            e.estableceNombre_empleado(null);
        });
    }

    @Test @DisplayName("Establecer meses trabajados correcto")
    public void establecerMeses_trabajo_Correcto() {

        Empleado e = new Empleado();
        try {
            e.estableceMeses_Trabajo("011");
        } catch (MesesTrabajoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(11, e.getMeses_trabajo());
    }

    @Test @DisplayName("Establecer meses trabajados incorrecto")
    public void establecerMeses_trabajo_Incorrecto() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("1234");
        });
    }

    @Test @DisplayName("Establecer meses trabajados limite -001")
    public void establecerMeses_trabajo_Menos1() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("-001");
        });
    }

    @Test @DisplayName("Establecer meses trabajados limite 1000")
    public void establecerMeses_trabajo_1000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("1000");
        });
    }

    @Test @DisplayName("Establecer meses trabajados menor 3 digitos")
    public void establecerMeses_trabajo_Menor3Digitos() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("1");
        });
    }

    @Test @DisplayName("Establecer ser directivo correcto 1")
    public void establecerSerDirectivo_Correcto2() {

        Empleado e = new Empleado();
        try {
            e.establecerSerDirectivo("+");
        } catch (CargoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(true, e.getDirectivo());
    }

    @Test @DisplayName("Establecer ser directivo correcto 2")
    public void establecerSerDirectivo_Correcto1() {

        Empleado e = new Empleado();
        try {
            e.establecerSerDirectivo("-");
        } catch (CargoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(false, e.getDirectivo());
    }

    @Test @DisplayName("Establecer ser directivo incorrecto")
    public void establecerSerDirectivo_Incorrecto() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(CargoException.class, () -> {
            e.establecerSerDirectivo("PACO");
        });
    }

    @Test @DisplayName("Establecer ser directivo nulo")
    public void establecerSerDirectivo_Nulo() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            e.establecerSerDirectivo(null);
        });
    }

    @Test @DisplayName("Establecer Prima 1")
    public void establecer_Prima1() {

        Empleado e = new Empleado();
        try {
            e.calcularPrima("001","FernandoCorrea","012","+");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P1, e.getPrima());
    }

    @Test @DisplayName("Establecer Prima 2")
    public void establecer_Prima2() {

        Empleado e = new Empleado();
        try {
            e.calcularPrima("002","DanielBejarano","015","-");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P2, e.getPrima());
    }

    @Test @DisplayName("Establecer Prima 3")
    public void establecer_Prima3() {

        Empleado e = new Empleado();
        try {
            e.calcularPrima("003","ErikAlejandro","002","+");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P3, e.getPrima());
    }

    @Test @DisplayName("Establecer Prima 4")
    public void establecer_Prima4() {

        Empleado e = new Empleado();
        try {
            e.calcularPrima("004","IvanRobles","005","-");
        } catch (CargoException | MesesTrabajoException | NumeroEmpleadoException | NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P4, e.getPrima());
    }
}
