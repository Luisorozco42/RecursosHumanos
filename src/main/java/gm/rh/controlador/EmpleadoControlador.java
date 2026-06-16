package gm.rh.controlador;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import gm.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    @Autowired
    private IEmpleadoServicio empleadoServicio;
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado) -> logger.info(empleado.getNombre()));
        return empleados;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
        logger.info("Empleado a agregar: " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }
}
