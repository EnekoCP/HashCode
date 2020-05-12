import java.util.ArrayList;
import java.util.HashSet;



public class Libreria {
	ArrayList<Book> libros = new ArrayList<Book>();
	int time;
	int escaneos;
	
	//constructura
public Libreria(ArrayList<Book> o, int i, int j){
		
	}

	
	public void añadirLibro(Book plibro){
		if(!libros.contains(plibro)){
			libros.add(plibro);
		}else{
			
		}
	}
	public void setTime(int ptime){
		this.time=ptime;
	}
	public void setescaneos(int pescaneos){
		this.escaneos=pescaneos;
	}
	
}
