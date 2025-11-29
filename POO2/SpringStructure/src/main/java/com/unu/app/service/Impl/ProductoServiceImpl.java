package com.unu.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unu.app.entity.Cliente;
import com.unu.app.entity.Producto;
import com.unu.app.repository.ClienteRepository;
import com.unu.app.repository.ProductoRepository;
import com.unu.app.service.ClienteService;
import com.unu.app.service.ProductoService;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> Listar() {
		return productoRepository.findAll();
	}

	@Override
	public Producto Insertar(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void Eliminar(Integer id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void Actualizar(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public Producto Obtener(int id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Producto> BuscarByAll(String busqueda) {
		return productoRepository.BuscarByAll(busqueda);
	}

	

}
