package edd.junit.syspagos;

import edd.junit.syspagos.excepciones.NumeroEmpleadoException;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmpleadoTest {

    @Test @DisplayName("Establecer numero rango valido")
    public void establecerNumero_empleado_Correcto() {

        Empleado e = new Empleado();
        try {
            e.establecerNumero_empleado("4");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(4,e.getNumero_empleado());
    }

    @Test @DisplayName("Establecer numero limite 000")
    public void establecerNumero_empleado_000() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("0");
        });
    }

    @Test
    public void establecerNumero_empleado_999() {

        Empleado e = new Empleado();
        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("999");
        });

    }














}
