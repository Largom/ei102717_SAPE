package es.uji.ei1027.SAPE.model;

public enum MenuEstadoOferta {
	SINDEFINIR("sin definir"), INTRODUCIDA("introducida"), PENDIENTEREVISION("pendiente de revisión"), ACEPTADA("aceptada"), RECHAZADA("rechazada"), VISIBLE("visible"), ASIGNADA("asignada");

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
