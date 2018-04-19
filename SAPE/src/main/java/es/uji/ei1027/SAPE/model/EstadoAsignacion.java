package es.uji.ei1027.SAPE.model;

public enum EstadoAsignacion {
	
	TRASPASADA("traspasada"), RECHAZADA("rechazada"), ACEPTADA("aceptada");

	private String descripcion;
	
	private EstadoAsignacion(String descripcion){
		 this.descripcion = descripcion;
	}
		
	public String getDescripcion(){
		return descripcion;
	}
	
	public static EstadoAsignacion obtenerEstado(String descripcion) {
		if (descripcion!=null)
			switch (descripcion) {
				case "traspasada":
					return EstadoAsignacion.TRASPASADA;
				case "rechazada":
					return EstadoAsignacion.RECHAZADA;
				case "aceptada":
					return EstadoAsignacion.ACEPTADA;
			}
		return null;
	}

}
