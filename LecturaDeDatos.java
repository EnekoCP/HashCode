import java.io.*;
import java.util.*;
import java.util.*;
public class LecturaDeDatos {
    String fileName;
   
    private static LecturaDeDatos milibreria=new LecturaDeDatos();
	
private LecturaDeDatos(){
		
	}

public static LecturaDeDatos getLecturaDeDatos(){

		return milibreria;
	}
 

    public void readInFile(String fileName) {
        this.fileName = fileName;

        try (FileReader fileReader = new FileReader("C:\\Users\\Eneko\\" + fileName)) {
            Scanner scanner = new Scanner(fileReader);

            int valor = scanner.nextInt();
            int valorAux = valor;
            
            while(valor>0){
				Book a = new Book(valor);
				a.setId(valorAux-valor);
				CollectLibrerias.getCollectLibreria().añadirLibro(a);
				
				valor=valor-1;
				}
           
            int valor1 = scanner.nextInt();
			while(valor1>0){
			ArrayList<Book> o = new ArrayList<Book>();
			Libreria p = new Libreria(o,0,0);
			CollectLibrerias.getCollectLibreria().añadirLibreria(p);;
			valor1=valor1-1;
			}
			CollectLibrerias.getCollectLibreria().setTiempo(scanner.nextInt());
			
			for (int i=0 ; i<CollectLibrerias.getCollectLibreria().getHashSet().size();i++){
				ArrayList<Book> todos = 
				CollectLibrerias.getCollectLibreria().getHashSet();
				todos.get(i).setScore(scanner.nextInt());
			}
			while (scanner.hasNextInt()) {
			for (int j=0 ; j<CollectLibrerias.getCollectLibreria().getHash1().size();j++){
				ArrayList<Libreria> todos1 = 
						CollectLibrerias.getCollectLibreria().getHash1();
				int canlibros = scanner.nextInt();
				todos1.get(j).setTime(scanner.nextInt());
				todos1.get(j).setescaneos(scanner.nextInt());
				int cont = 0;
				while (cont< canlibros){
					Book b = CollectLibrerias.getCollectLibreria().getHashSet().get(scanner.nextInt());
					todos1.get(j).añadirLibro(b);
					cont++;
				}
			}

            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }
    ArrayList<Book> escaneados = new ArrayList<Book>();
    ArrayList<Libreria> examinados = new ArrayList<Libreria>();
public int quienprimero(){
	int primero=0;
	for (int i = 0; i<CollectLibrerias.getCollectLibreria().getHash1().size();i++){
		int mayor = 0;
		if (CollectLibrerias.getCollectLibreria().getHash1().get(i).time > mayor ){
			if(!examinados.contains(CollectLibrerias.getCollectLibreria().getHash1().get(i))){
			mayor = CollectLibrerias.getCollectLibreria().getHash1().get(i).time;
			primero = i;
		}
		}
	}
	return primero;
}


   public void writeOutFile(String salida) {
	   Collections.reverse(CollectLibrerias.getCollectLibreria().getHash1().get(this.quienprimero()).libros);
	   try (FileWriter fileWriter = new FileWriter("C:\\Users\\Eneko\\" + salida, false)) {
            fileWriter.write(CollectLibrerias.getCollectLibreria().getHash1().size() + "\n");
            int size = 1;
            while(CollectLibrerias.getCollectLibreria().getHash1().size()>=size){
            int primero = this.quienprimero();
            int tiemposcan = (CollectLibrerias.getCollectLibreria().tiempomax - CollectLibrerias.getCollectLibreria().getHash1().get(primero).time);
            int numlibrosescan = -1*(tiemposcan*(CollectLibrerias.getCollectLibreria().getHash1().get(primero).escaneos));
            if (numlibrosescan<0){
            	numlibrosescan = numlibrosescan * -1;
            }
            if(CollectLibrerias.getCollectLibreria().getHash1().get(this.quienprimero()).libros.size()<=numlibrosescan){
            	fileWriter.write(this.quienprimero() +"  "+ CollectLibrerias.getCollectLibreria().getHash1().get(primero).libros.size() + "\n");
            }else{
            	fileWriter.write(primero +"  "+ numlibrosescan + "\n");
            }
            Iterator<Book> it = CollectLibrerias.getCollectLibreria().getHash1().get(primero).libros.iterator();
             
            while(it.hasNext() && numlibrosescan>0){
            	Book b = it.next();
            	fileWriter.write(b.id + " " );
            	numlibrosescan--;
            }
            
            fileWriter.write("\n");
            examinados.add(CollectLibrerias.getCollectLibreria().getHash1().get(primero));
            size++;
            }
            
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

}