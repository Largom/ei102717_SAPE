package es.uji.ei1027.SAPE.model;

public enum Semestre {
	
	PRIMERO("1º semestre"), SEGUNDO("2º semestre"), TODO("todo el curso");
	
	private String descripcion;
	
	private Semestre(String descripcion){
		
		this.descripcion = descripcion;
	}
		
	public String getDescripcion(){
		return descripcion;
	}
	
	public static Semestre buscar(String descrip){
		if (descrip!=null)
			switch (descrip) {
				case "1º semestre":
					return Semestre.PRIMERO;
				case "2º semestre":
					return Semestre.SEGUNDO;
				case "todo el curso":
					return Semestre.TODO;
			}
		return null;
	}

}
