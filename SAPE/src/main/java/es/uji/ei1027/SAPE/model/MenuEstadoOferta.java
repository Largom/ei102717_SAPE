package es.uji.ei1027.SAPE.model;

public enum MenuEstadoOferta {
	SINDEFINIR("Sin definir"), INTRODUCIDA("Introducida"), PENDIENTEREVISION("Pendiente de revision"), ACEPTADA("Aceptada"), RECHAZADA("Rechazada"), VISIBLEALUMNOS("Visible a alumnos"), ASIGNADA("Asignada");

	private String descripcion;
	
	private MenuEstadoOferta(String descripcion){
		
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
