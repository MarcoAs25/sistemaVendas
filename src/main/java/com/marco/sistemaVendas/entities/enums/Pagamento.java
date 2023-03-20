package com.marco.sistemaVendas.entities.enums;

public enum Pagamento {
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	CANCELADO(3);
	
	private int code;
	
	private Pagamento(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static Pagamento valueof(int code) {
		for(Pagamento value: Pagamento.values()) {
			if(code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de pagamento inválido");
	}
}
