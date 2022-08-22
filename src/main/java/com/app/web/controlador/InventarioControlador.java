package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Inventario;
import com.app.web.servicio.InventarioServicio;

@Controller
public class InventarioControlador {

	@Autowired
	private InventarioServicio servicio;

	@GetMapping({ "/inventarios", "/" })
	public String listarInventarios(Model modelo) {
		modelo.addAttribute("inventarios", servicio.listarTodosLosInventario());
		return "inventarios";
	}

	@GetMapping({ "/inventarios/nuevo" })
	public String mostrarFormularioDeRegistrarInventario(Model modelo) {
		Inventario inventario = new Inventario();
		modelo.addAttribute("inventario", inventario);
		return "crear_inventario";
	}

	@PostMapping("/inventarios")
	public String guardarInventario(@ModelAttribute("inventario") Inventario inventario) {
		servicio.guardarInventario(inventario);
		return "redirect:/inventarios";

	}

	@GetMapping("/inventarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("inventario", servicio.obtenerInventarioPorId(id));
		return "editar_inventario";
	}

	@PostMapping("/inventarios/{id}")
	public String actualizarInventario(@PathVariable Long id, @ModelAttribute("inventario") Inventario inventario,
			Model modelo) {
		Inventario inventarioExistente = servicio.obtenerInventarioPorId(id);
		inventarioExistente.setId(id);
		inventarioExistente.setCodigo(inventario.getCodigo());
		inventarioExistente.setNombre(inventario.getNombre());
		inventarioExistente.setDescripcion(inventario.getDescripcion());
		inventarioExistente.setCantidad(inventario.getCantidad());
		inventarioExistente.setPrecio(inventario.getPrecio());

		servicio.actualizarInventario(inventarioExistente);

		return "redirect:/inventarios";
	}

	@GetMapping("/inventarios/{id}")
	public String eliminarInventario(@PathVariable Long id) {
		servicio.eliminarInventario(id);
		return "redirect:/inventarios";

	}

}
