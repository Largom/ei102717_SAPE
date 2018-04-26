package es.uji.ei1027.SAPE.model;

public enum Itinerario {
	
	SOFTWARE("enginyeria del programari"), SISTEMAS("sistemes d'informació"), TECNOLOGIA("tecnologies de la informació"), HARDWARE("enginyeria de computadors");
	
	private String descripcion;
	
	private Itinerario(String descripcion){
		
		this.descripcion = descripcion;
	}
		
	public String getDescripcion(){
		return descripcion;
	}
	
	public static Itinerario buscar(String descrip){
		if (descrip!=null)
			switch (descrip) {
				case "enginyeria del programari":
					return Itinerario.SOFTWARE;
				case "sistemes d'informació":
					return Itinerario.SISTEMAS;
				case "tecnologies de la informació":
					return Itinerario.TECNOLOGIA;
				case "enginyeria de computadors":
					return Itinerario.HARDWARE;
			}
		return null;
	}	
	
}
