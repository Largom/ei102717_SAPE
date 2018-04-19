package es.uji.ei1027.SAPE.model;

public enum EstadoOferta {
	SINDEFINIR("sin definir"), INTRODUCIDA("introducida"), PENDIENTEREVISION("pendiente de revisión"), ACEPTADA("aceptada"), RECHAZADA("rechazada"), VISIBLE("visible"), ASIGNADA("asignada");

	private String descripcion;
	
	private EstadoOferta(final String descripcion){
		
		 this.descripcion = descripcion;
	}
		
	public String getDescripcion(){
		return descripcion;
	}
	
	public static EstadoOferta obtenerEstado(final String descripcion) {
		if (descripcion!=null)
			switch (descripcion) {
				case "sin definir":
					return EstadoOferta.SINDEFINIR;
				case "introducida":
					return EstadoOferta.INTRODUCIDA;
				case "pendiente de revisión":
					return EstadoOferta.PENDIENTEREVISION;
				case "aceptada":
					return EstadoOferta.ACEPTADA;
				case "rechazada":
					return EstadoOferta.RECHAZADA;
				case "visible":
					return EstadoOferta.VISIBLE;
				case "asignada":
					return EstadoOferta.ASIGNADA;
			}
		return null;
	}
}
