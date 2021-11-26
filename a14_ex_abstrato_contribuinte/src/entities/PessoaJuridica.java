package entities;

public class PessoaJuridica extends Contribuinte {
	
	private Integer numeroFuncionario;
		
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionario) {
		super(nome, rendaAnual);
		this.numeroFuncionario = numeroFuncionario;
	}
	
	
	public Integer getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(Integer numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	@Override
	public double totalImposto() {
		if (numeroFuncionario > 10) {
			return getRendaAnual() * 0.14;
		}
		else {
			return getRendaAnual() * 0.16;			
		}
	}
}
