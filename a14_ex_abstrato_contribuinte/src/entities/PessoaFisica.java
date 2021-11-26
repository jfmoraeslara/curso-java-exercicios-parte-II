package entities;

public class PessoaFisica extends Contribuinte {

	private Double gastosSaude;	

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override	
	public double totalImposto() {
		double taxaBasica;
		if (getRendaAnual() < 20000.0) {
			taxaBasica = getRendaAnual() * 0.15;
		}
		else {
			taxaBasica = getRendaAnual() * 0.25 - gastosSaude * 0.5;		
		}		
		if (taxaBasica < 0.0) {
			taxaBasica = 0.0;
		}
		return taxaBasica;
	}	
}
