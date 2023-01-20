
package ar.edu.unlam.pb1;

public class BlackJack {
	
	private static Palo palosPosibles[] = Palo.values();
	private static Figura figurasPosibles[] = Figura.values();
	private static final int CANTIDAD_MAXIMA_CARTAS = 52;
	private static Carta cartasDisponibles[] = new Carta[CANTIDAD_MAXIMA_CARTAS];
	
	private Carta mazo[];
	private Carta cartasJugador[];
	private Carta cartasCrupier[];

	public static void inicializarCartasDisponibles() {
		int c=0;
		int cod=1;
		for(int i=0;i<palosPosibles.length;i++) {
			for(int j=0;j<figurasPosibles.length;j++) {
				cartasDisponibles[c]=new Carta(cod,palosPosibles[i],figurasPosibles[j]);
				c++;
				cod++;
			}
		}
		
		/*
		 * Se debe completar el array cartasDisponibles con cada una de las cartas que se puede tener.
		 * Para esto se recomienda por cada palo (palosPosibles) ir generando las (figurasPosibles) que puede tener cada uno.
		 * Tener presente que luego, las cartas se van a tener que ordenar por alg佖 criterio, para eso se puede utilizar el atributo codigo de los objetos de tipo Carta.
		 */
	}
	
	public BlackJack() {
		inicializarCartasDisponibles();
		this.mazo=cartasDisponibles;
		this.cartasJugador=new Carta[CANTIDAD_MAXIMA_CARTAS];
		this.cartasCrupier=new Carta[CANTIDAD_MAXIMA_CARTAS];
		/*
		 * Debe generar las condiciones para el correcto funcionamiento del juego.
		 *  
		 */	
	}
	
	public void ordenar() {
		Carta aux;
		for(int i=0;i<mazo.length;i++) {
			for(int j=0;j<mazo.length-1;j++) {
				if(mazo[j]!=null && mazo[j+1]!=null && mazo[j].getCodigo()>mazo[j+1].getCodigo()) {
					aux=mazo[j];
					mazo[j]=mazo[j+1];
					mazo[j+1]=aux;
				}
			}
		}
		
		/*
		 *  Se debe ordenar el mazo de cartas de manera ascendente.
		 */		
		
	}
	
	public void mezclar() {
		Carta aux;
		int r=0;
		for(int i=0;i<mazo.length;i++) {
			r=(int)(Math.random()*(52));
			aux=mazo[i];
			mazo[i]=mazo[r];
			mazo[r]=aux;
		}
		/*
		 *  Se debe alterar el orden natural del mazo de manera que NO sea posible saber de antemano qu� carta sigue a una carta determinada.
		 *  Si as� lo deseara, el programador puede regenerar los objetos del mazo nuevamente (Vaciar las cartas que pudiera tener el mazo y luego ir completando en cada posici cada carta de manera aleatoria).
		 */
		
	}
	
	public Carta siguiente() {
		Carta siguiente;
		for(int i=0;i<mazo.length;i++) {
			for(int j=0;j<cartasJugador.length;j++) {
				if(mazo[i]!=null && cartasJugador[j]==null) {
					cartasJugador[j]=mazo[i];
					siguiente=cartasJugador[j];
					mazo[i]=null;
					
					return siguiente;
				}
			}
			
		}
		
		/*
		 *  Determina la siguiente carta que corresponde al jugador y la devuelve a t咜uo informativo
		 */
		return null;
		
	}
	
	
	
	public boolean gano() {
		
		if(contarCartasJugador()>contarCartasGrupier() && contarCartasJugador()<=21) {
			return true;
		}
		
		/*
		 * Eval俉 las cartas obtenidas por el jugador contra las cartas del crupier y devuelve true si el jugador result� ganador.
		 */
		return false;
	}
	
	public int contarCartasJugador() {
		int puntaje=0;
		for(int i=0;i<cartasJugador.length;i++) {
			if(cartasJugador[i]!=null) {
				puntaje+=cartasJugador[i].getValor();
			}
			
			
		}
		return puntaje;
	}
	
	public int contarCartasGrupier() {
		int puntaje=0;
		for(int i=0;i<cartasCrupier.length;i++) {
			if(cartasCrupier[i]!=null) {
				puntaje+=cartasCrupier[i].getValor();
			}
			
			
		}
		return puntaje;
	}
	
	public boolean perdio() {
		if(contarCartasJugador()>21) {
			return true;
		}
		
		/*
		 * Devuelve true si el puntaje del jugador supera los 21 puntos.
		 */
		
		return false;
	}
	
	public void jugarGrupier() {
		int puntos=0;
		int j=0;
		for(int i=0;i<mazo.length;i++) {
			
			if(cartasCrupier[j]!=null) {
				j++;
			}
			
			if(mazo[i]!=null && cartasCrupier[j]==null) {
				cartasCrupier[j]=mazo[i];
				mazo[i]=null;
				puntos+=cartasCrupier[j].getValor();
				j++;
			}
		
			if(puntos>=17) {
				break;
			}
			
		
		}
		
	
		/*
		 * El juego del grupier consiste en ir sacando y guardando sus cartas mientras su puntaje sea menor a 17. Cuando el puntaje del grupier es 17 o m疽 finaliza su juego.
		 */
	}
	
	public String toString() {
		String jug="CARTAS DEL JUGADOR:";
		for(int i=0;i<cartasJugador.length;i++) {
			if(cartasJugador[i]!=null) {
				jug+="\n"+cartasJugador[i].getCodigo();
			}
		}
		
		String crup="CARTAS DEL CRUPIER:";
		for(int i=0;i<cartasCrupier.length;i++) {
			if(cartasCrupier[i]!=null) {
				crup+="\n"+cartasCrupier[i].getCodigo();
			}
		}
		
		/*
		 * Devuelve un String con las cartas del jugador y las cartas del crupier
		 */
		
		return jug + "\n" + crup;
	}

}
