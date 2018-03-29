package es.uji.ei1027.SAPE.model;

public class Coordinador extends Personal {
	
	private String CEITFG;

	
	public Coordinador() {
		super();
	}


	public Coordinador(String cEITFG) {
		super();
		CEITFG = cEITFG;
	}


	public final String getCEITFG() {return CEITFG;}
	public final void setCEITFG(String cEITFG) {CEITFG = cEITFG;}
	

}
