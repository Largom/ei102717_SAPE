
public enum MenuEstado {

	
	TRASPASADA("Traspasada"), RECHAZADA("Rechazada"), ACEPTADA("Aceptada");

	private String descripcion;
	
	private MenuEstado(String descripcion){
		 this.descripcion = descripcion;
	}
	
	public static String getMenu(){
		
		StringBuilder sb = new StringBuilder();
			
		for(MenuEstado opcion: MenuEstado.values() ){
				
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