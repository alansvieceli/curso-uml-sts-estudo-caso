package com.alanvieceli.cursouml.domains.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2,"'Quitado"),
	CANCELADO(3, "Canceldo");
	
	private int cod;
	private String desc;

	private EstadoPagamento(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
	
	public static EstadoPagamento ToEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;				
			}
		}
		
		throw new IllegalArgumentException("código inválido: " + cod);
		
	}

}
