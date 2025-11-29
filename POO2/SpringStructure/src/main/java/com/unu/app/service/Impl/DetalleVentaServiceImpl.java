package com.unu.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unu.app.entity.DetalleVenta;
import com.unu.app.entity.Venta;
import com.unu.app.repository.DetalleVentaRepository;
import com.unu.app.service.DetalleService;

@Service("detalleVentaService")
public class DetalleVentaServiceImpl implements DetalleService {

	@Autowired
	@Qualifier("detalleVentaRepository")
	private DetalleVentaRepository detalleVentaRepository;

	@Override
	public List<DetalleVenta> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleVenta Insertar(DetalleVenta detalle) {
		return detalleVentaRepository.save(detalle);
	}

	@Override
	public void Eliminar(Integer id) {
		detalleVentaRepository.deleteById(id);
		
	}

	@Override
	public void Actualizar(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetalleVenta Obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleVenta> BuscarByAll(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleVenta> ListarDetalleBy_IdVenta(int id) {
		return detalleVentaRepository.ListarDetalleBy_IdVenta(id);
	}

	@Override
	public List<DetalleVenta> ListarDetalleBy_ObjVenta(Venta venta) {
		return detalleVentaRepository.ListarDetalleBy_ObjVenta(venta);
	}

	@Override
	public Double obtenerTotalByIdVenta(Integer id) {
		return detalleVentaRepository.obtenerTotalByIdVenta(id);
	}

	

}
