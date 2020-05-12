import java.util.ArrayList;
import java.util.HashSet;

public class CollectLibrerias {
	ArrayList<Libreria> librerias = new ArrayList<Libreria>();
	ArrayList<Book> todos = new ArrayList<Book>();
	private static CollectLibrerias milibreria=new CollectLibrerias();
	int tiempomax;
	//constructura
private CollectLibrerias(){
		
	}

public static CollectLibrerias getCollectLibreria(){

		return milibreria;
	}
public void añadirLibro(Book plibro){
	if(!todos.contains(plibro)){
		todos.add(plibro);
	}else{
		
	}
}
public void añadirLibreria(Libreria plibreria){
	if(!librerias.contains(plibreria)){
		librerias.add(plibreria);
	}else{
		
	}
}
public void setTiempo(int tiempo){
	this.tiempomax=tiempo;
}
public ArrayList<Book> getHashSet (){
	return this.todos;
}
public ArrayList<Libreria> getHash1(){
	return this.librerias;
}
	
}
