package es.uji.ei1027.SAPE.model;

public enum MenuEstadoAsignacion {
	
	TRASPASADA("Traspasada"), RECHAZADA("Rechazada"), ACEPTADA("Aceptada");

	private String descripcion;
	
	private MenuEstadoAsignacion(String descripcion){
		 this.descripcion = descripcion;
	}
	
	public static String getMenu(){
		
		StringBuilder sb = new StringBuilder();
			
		for(MenuEstadoAsignacion opcion: MenuEstadoAsignacion.values() ){
				
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
