package es.uji.ei1027.SAPE.model;

public enum MenuOfertaAsignada {
	

	ACEPTADA("aceptada"), RECHAZADA("rechazada"),TRASPASADA("traspasada");

	private String descripcion;
	
	private MenuOfertaAsignada(String descripcion){
		 this.descripcion = descripcion;
	}
	
	public static String getMenu(){
		
		StringBuilder sb = new StringBuilder();
			
		for(MenuOfertaAsignada opcion: MenuOfertaAsignada.values() ){
				
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
