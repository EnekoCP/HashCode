import java.util.*;
import java.util.Map.Entry;

public class main{
	
	private static main miMain=new main();
	//constructura
private main(){
		
	}

public static main getMenuPrincipal(){

		return miMain;
	}
public static void main(String[] args) {
	LecturaDeDatos.getLecturaDeDatos().readInFile("example0.txt");
	System.out.println(CollectLibrerias.getCollectLibreria().getHash1().get(0).libros.get(0).id);
	System.out.println(CollectLibrerias.getCollectLibreria().getHash1().get(0).libros.get(1).id);
	System.out.println(CollectLibrerias.getCollectLibreria().getHash1().get(0).libros.get(2).id);
	System.out.println(CollectLibrerias.getCollectLibreria().getHash1().get(0).libros.get(3).id);
	LecturaDeDatos.getLecturaDeDatos().writeOutFile("salida.txt");
	

}


}
