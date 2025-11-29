package com.unu.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unu.app.entity.Cliente;
import com.unu.app.entity.Producto;
import com.unu.app.entity.Venta;
import com.unu.app.repository.ClienteRepository;
import com.unu.app.repository.ProductoRepository;
import com.unu.app.repository.VentaRepository;
import com.unu.app.service.ClienteService;
import com.unu.app.service.ProductoService;
import com.unu.app.service.VentaService;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {

	@Autowired
	@Qualifier("ventaRepository")
	private VentaRepository ventaRepository;

	@Override
	public List<Venta> Listar() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta Insertar(Venta venta) {
		return ventaRepository.save(venta);
	}

	@Override
	public void Eliminar(Integer id) {
		ventaRepository.deleteById(id);
	}

	@Override
	public void Actualizar(Venta venta) {
		ventaRepository.save(venta);
	}

	@Override
	public Venta Obtener(Integer id) {
		return ventaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Venta> BuscarByAll(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer ObtenerLastId() {
		if(ventaRepository.getNewId() == null) {
			return 0;
		}
		return ventaRepository.getNewId();
	}

	@Override
	public boolean isExistByIdVenta(Integer idVenta) {
		Optional<Venta> cliente = ventaRepository.isExistByIdVenta(idVenta);
		if (cliente.isPresent()) {
			return true;
		}
		return false;
	}

}
