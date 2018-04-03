package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Pedido;
import com.example.repositories.PedidoRepository;
import com.example.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;

//	public Pedido find(Integer id) {
//		Optional<Pedido> obj = repo.findById(id);
//		return obj.orElse(null);
//	}
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", tipo: "+Pedido.class.getName()));
	}
	
}
