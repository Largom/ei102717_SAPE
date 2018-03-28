package es.uji.ei1027.clubesportiu.model;

import java.sql.Time;

public class Classificacio {
	String nomNadador;
	String nomProva;
	int posicio;
	Time temps;

	public String getNomNadador() { return nomNadador; }
	public void setNomNadador(String nomNadador) { this.nomNadador = nomNadador; }

	public String getNomProva() { return nomProva; }
	public void setNomProva(String nomProva) { this.nomProva = nomProva; }

	public int getPosicio() { return posicio; }
	public void setPosicio(int posicio) { this.posicio = posicio; }

	public Time getTemps() { return temps; }
	public void setTemps(Time temps) { this.temps = temps; }

	@Override
	public String toString() {
		return "Classificacio [posicio=" + posicio + ", temps=" + temps + "]";
	}
}

