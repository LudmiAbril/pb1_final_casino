package ar.edu.unlam.pb1;

public class Carta {
	private int codigo; 
	private Palo palo;
	private Figura figura; 
	
	public Carta(int codigo, Palo palo, Figura figura) {
		this.codigo = codigo;
		this.palo = palo;
		this.figura = figura;
	}
	
	
	
	@Override
	public String toString() {
		return palo + " de " + figura;
	}



	public int getValor() {
if(figura==Figura.AS) {
	return 1;
			
}
if(figura==Figura.DOS) {
			
	return 2;
}

if(figura==Figura.TRES) {
	return 3;
}

if(figura==Figura.CUATRO) {
	return 4;
}

if(figura==Figura.CINCO) {
	return 5;
	
}
if(figura==Figura.SEIS) {
	return 6;
	
}
if(figura==Figura.SIETE) {
	return 7;
	
}
if(figura==Figura.OCHO) {
	return 8;
	
}
if(figura==Figura.NUEVE) {
	return 9;
	
}
if(figura==Figura.DIEZ) {
	return 10;
	
}
		/*
		 * Debe retornar el valor asociado a la figura
		 */
		return 10;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}	

}
