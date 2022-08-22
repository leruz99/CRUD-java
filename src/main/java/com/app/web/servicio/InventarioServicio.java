package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Inventario;

public interface InventarioServicio {
		
	public List<Inventario> listarTodosLosInventario();
	
	public Inventario guardarInventario(Inventario inventario);
	
	public Inventario obtenerInventarioPorId(Long id);
	
	public Inventario actualizarInventario(Inventario inventario);
	
	public void eliminarInventario(Long id);

}
