package br.senai.sc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer codigo;
	private String descicao;
	
	public static TipoCliente toEnum(Integer codigo) {
		for (TipoCliente tipo : TipoCliente.values()) {
			if(tipo.getCodigo() == codigo) {
				return tipo;
			}
		}
		return null;
	}
	
	
	private TipoCliente(Integer codigo, String descicao) {
		this.codigo = codigo;
		this.descicao = descicao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescicao() {
		return descicao;
	}
	
	
	
}
