package com.unu.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unu.app.entity.Cliente;
import com.unu.app.repository.ClienteRepository;
import com.unu.app.service.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> Listar() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente Insertar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void Eliminar(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public void Actualizar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Cliente Obtener(int id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public boolean isExistByDni(String dni) {
		Optional<Cliente> cliente = clienteRepository.isExistByDni(dni);
		if (cliente.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public List<Cliente> BuscarByAll(String busqueda) {
		return clienteRepository.BuscarByAll(busqueda);
	}

	@Override
	public List<Cliente> BuscarByDni(String busqueda) {
		return clienteRepository.BuscarByDni(busqueda);
	}

	@Override
	public List<Cliente> BuscarByNombre(String busqueda) {
		return clienteRepository.BuscarByNombre(busqueda);
	}

	@Override
	public List<Cliente> BuscarByApellido(String busqueda) {
		return clienteRepository.BuscarByApellido(busqueda);
	}

}
