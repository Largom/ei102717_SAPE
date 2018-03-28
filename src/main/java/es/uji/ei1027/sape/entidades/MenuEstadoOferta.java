package es.uji.ei1027.sape.entidades;


public enum MenuEstadoOferta {
	
	ASIGNADA("Asignada"), VISIBLEALUMNOS("Visible para alumnos") , RECHAZADA("Rechazada") , ACEPTADA("Aceptada"), PENDIENTEREVISION("Pendiente revisión"), INTRODUCIDA("Introducida"), SINDEFINIR("Sin definir");

	private String descripcion;
	
	private MenuEstadoOferta(String descripcion){
		
		 this.descripcion = descripcion
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

