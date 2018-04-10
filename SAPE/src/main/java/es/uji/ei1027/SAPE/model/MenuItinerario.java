package es.uji.ei1027.SAPE.model;

public enum MenuItinerario {
	
	SOFTWARE("enginyeria del programari"), SISTEMAS("sistemes d'informació"), TECNOLOGIA("tecnologies de la informació"), HARDWARE("enginyeria de computadors");
	
	private String descripcion;
	
	private MenuItinerario(String descripcion){
		
		this.descripcion = descripcion;
	}
	
	
	public static String getMenu(){
			
		StringBuilder sb = new StringBuilder();
			
		for(MenuEstadoOferta opcion: MenuEstadoOferta.values() ){
				
			sb.append(opcion.ordinal());
		    sb.append(".- ");
		    sb.append(opcion.getDescripcion());
		    sb.append("\n");
			}
			return sb.toString();
	}
		
	public String getDescripcion(){
		return descripcion;
	}


	
	
}
