package es.uji.ei1027.SAPE.model;

public enum MenuItinerario {
	
	SOFTWARE("Ingeniera del software"), SISTEMAS("Sistemas de la información"), TECNOLOGIA("Tecnología de la información"), HARDWARE("Ingenieria de computadores");
	
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
