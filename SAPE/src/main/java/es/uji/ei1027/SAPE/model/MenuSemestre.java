package es.uji.ei1027.SAPE.model;

public enum MenuSemestre {
	
	PRIMERO("1º semestre"), SEGUNDO("2º semestre"), VERANO("Verano");
	
	private String descripcion;
	
	private MenuSemestre(String descripcion){
		
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
