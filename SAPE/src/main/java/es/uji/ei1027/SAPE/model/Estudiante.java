package es.uji.ei1027.SAPE.model;


public class Estudiante extends Personal{
	
	private String dni;
	private String nombre;
	private int numeroCreditosAprobados;
	private int numeroAsignaturasPendientes4t;
	private MenuSemestre semestreInicioEstancia;
	private int orden;
	private MenuItinerario itinerario;
	
	/**
	 * Constructor
	 */
	public Estudiante() {
		super();
		this.dni = null;
		this.nombre = null;
		this.numeroCreditosAprobados = 0;
		this.numeroAsignaturasPendientes4t = 0;
		this.semestreInicioEstancia = null;
		this.orden = 0;
		this.itinerario = null;
	}
	/**
	 * @param Estudiante
	 * @param pass
	 * @throws IllegalArgumentException
	 */
	public Estudiante(final Estudiante e, final String pass) {
		super(e.usuario, pass);
		this.dni = e.dni;
		this.nombre = e.nombre;
		this.numeroCreditosAprobados = e.numeroCreditosAprobados;
		this.numeroAsignaturasPendientes4t = e.numeroAsignaturasPendientes4t;
		this.semestreInicioEstancia = e.semestreInicioEstancia;
		this.orden = e.orden;
		this.itinerario = e.itinerario;
	}
	/**
	 * @param usuario
	 * @param dni
	 * @param nombre
	 * @param numeroCreditosAprobados
	 * @param numeroAsignaturasPendientes4t
	 * @param semestreInicioEstancia
	 * @param orden
	 * @param itinerario
	 */
	public Estudiante(final String usuario, final String dni, final String nombre, final int numeroCreditosAprobados,
			final int numeroAsignaturasPendientes4t, final MenuSemestre semestreInicioEstancia, final int orden,
			final MenuItinerario itinerario) {
		super(usuario, null);
		if (numeroAsignaturasPendientes4t<0 || numeroAsignaturasPendientes4t>12 || numeroCreditosAprobados<149.4 || numeroCreditosAprobados>260) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.numeroCreditosAprobados = numeroCreditosAprobados;
		this.numeroAsignaturasPendientes4t = numeroAsignaturasPendientes4t;
		this.semestreInicioEstancia = semestreInicioEstancia;
		this.orden = orden;
		this.itinerario = itinerario;
	}
	

	/**
	 * @return the semestreInicioEstancia
	 */
	public final MenuSemestre getSemestreInicioEstancia() {
		return semestreInicioEstancia;
	}
	/**
	 * @param semestreInicioEstancia the semestreInicioEstancia to set
	 */
	public final void setSemestreInicioEstancia(final MenuSemestre semestreInicioEstancia) {
		this.semestreInicioEstancia = semestreInicioEstancia;
	}
	/**
	 * @return the itinerario
	 */
	public final MenuItinerario getItinerario() {
		return itinerario;
	}
	/**
	 * @param itinerario the itinerario to set
	 */
	public final void setItinerario(final MenuItinerario itinerario) {
		this.itinerario = itinerario;
	}
	/**
	 * @return the dni
	 */
	public final String getDni() {
		return dni;
	}
	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}
	/**
	 * @return the numeroCreditosAprobados
	 */
	public final int getNumeroCreditosAprobados() {
		return numeroCreditosAprobados;
	}
	/**
	 * @return the numeroAsignaturasPendientes4t
	 */
	public final int getNumeroAsignaturasPendientes4t() {
		return numeroAsignaturasPendientes4t;
	}
	/**
	 * @return the orden
	 */
	public final int getOrden() {
		return orden;
	}
}
