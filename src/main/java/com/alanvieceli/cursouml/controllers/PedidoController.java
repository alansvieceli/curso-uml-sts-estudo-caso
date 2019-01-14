package com.alanvieceli.cursouml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanvieceli.cursouml.domains.Pedido;
import com.alanvieceli.cursouml.services.PedidoService;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoController {

	@Autowired
	private PedidoService serv;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = serv.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

}
