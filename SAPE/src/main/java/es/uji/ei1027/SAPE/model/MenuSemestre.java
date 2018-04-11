package es.uji.ei1027.SAPE.model;

public enum MenuSemestre {
	
	PRIMERO("1º semestre"), SEGUNDO("2º semestre"), TODO("todo el curso");
	
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
	
	public static String getHTML(){
		
		StringBuilder sb = new StringBuilder();
			
		for(MenuEstadoOferta opcion: MenuEstadoOferta.values() ){
			
			sb.append("<option value=\"");
			sb.append(opcion);					
			sb.append("\">");
			sb.append(opcion.getDescripcion());
			sb.append("</option>\n");
			}
			return sb.toString();
	}
		
	public String getDescripcion(){
		return descripcion;
	}
	
	public static MenuSemestre buscar(String descrip){
		if (descrip!=null)
			switch (descrip) {
				case "1º semestre":
					return MenuSemestre.PRIMERO;
				case "2º semestre":
					return MenuSemestre.SEGUNDO;
				case "todo el curso":
					return MenuSemestre.TODO;
				default:
					return null;
			}
		return null;
	}


	
	
}
