package es.uji.ei1027.SAPE.model;

public enum MenuEstadoAsignacion {
	
	TRASPASADA("traspasada"), RECHAZADA("rechazada"), ACEPTADA("aceptada");

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
	
	public static MenuEstadoAsignacion obtenerEstado(String descripcion) {
		MenuEstadoAsignacion estado;
		switch (descripcion) {
			case "traspasada":
				estado = MenuEstadoAsignacion.TRASPASADA;
				break;
			case "rechazada":
				estado = MenuEstadoAsignacion.RECHAZADA;
				break;
			case "aceptada":
				estado = MenuEstadoAsignacion.ACEPTADA;
				break;
			default:
				estado = null;
				break;
		}
		return estado;
	}

}
