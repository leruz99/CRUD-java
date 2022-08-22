package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Inventario;
import com.app.web.repositorio.InventarioRepositorio;

@Service
public class InventarioServicioImpl implements InventarioServicio {

	@Autowired
	private InventarioRepositorio repositorio;

	@Override
	public List<Inventario> listarTodosLosInventario() {
		return repositorio.findAll();
	}

	@Override
	public Inventario guardarInventario(Inventario inventario) {
		return repositorio.save(inventario);
	}

	@Override
	public Inventario obtenerInventarioPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Inventario actualizarInventario(Inventario inventario) {
		return repositorio.save(inventario);
	}

	@Override
	public void eliminarInventario(Long id) {
		repositorio.deleteById(id);

	}

}
