package com.marco.sistemaVendas.entities.enums;

public enum StatusPagamento {
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	CANCELADO(3);
	
	private int codigo;
	
	private StatusPagamento(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public static StatusPagamento valueOf(int codigo) {
		for(StatusPagamento value: StatusPagamento.values()) {
			if(codigo == value.getCodigo()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de pagamento inválido");
	}
}
