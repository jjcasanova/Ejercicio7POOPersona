import java.io.*;

public class principal {
	
	public static void main(String[] args){
		String nombre=null;
		int edad=0;
		char sexo=' ';
		double peso=0,altura=0;
		boolean introducido=false;
		persona[] mipersona=new persona[3];
		do{
			nombre=pedirdatos("Introduzca el nombre");
			try{
				edad=Integer.parseInt(pedirdatos("Introduzca la edad"));
				sexo=pedirdatos("Introduce el sexo: H hombre, M mujer").charAt(0);
				peso=Double.parseDouble(pedirdatos("Introduzca el peso"));
				altura=Double.parseDouble(pedirdatos("Introduzca la altura"));
				introducido=true;
			}catch(NumberFormatException ex){
				System.out.println("La edad, el peso o la altura no se han introducido correctamente. Vuelva a meter los datos");
			}catch(IndexOutOfBoundsException ex){
				System.out.println("Por favor, no deje el campo sexo vacío. Vuelva a meter todos los datos");
			}
		}while(!introducido);
		mipersona=rellenardatos(nombre,edad,sexo,peso,altura);
		peso(mipersona);
		mayoredad(mipersona);
		mostrarinformacion(mipersona);
	}


	private static void mayoredad(persona[] mipersona) {
		for (int i=0;i<mipersona.length;i++){
			if (mipersona[i].esMayorDeEdad()) System.out.println("La persona " +(i+1)+" es mayor de edad");
			else System.out.println("La persona " +(i+1)+ " NO es mayor de edad");
		}
		
	}


	private static void peso(persona[] mipersona) {
		for (int i=0;i<mipersona.length;i++){
			if (mipersona[i].calcularIMC()==1) System.out.println("La persona " + (i+1) + " está en sobrepeso");
			else if (mipersona[i].calcularIMC()==0) System.out.println("La persona " + (i+1) + " tiene el peso ideal");
			else System.out.println("La persona "+(i+1)+" está por debajo de su peso ideal");
		}
	}

	private static persona[] rellenardatos(String nombre, int edad, char sexo, double peso, double altura) {
		persona[] mipersona=new persona[3];
		for (int i=0;i<mipersona.length;i++){
			if (i==0){
				mipersona[i]=new persona(nombre,edad,sexo,peso,altura);
			}
			else if(i==1){
				mipersona[i]=new persona(nombre,edad,sexo);
			}
			else{
				mipersona[i]=new persona();
				mipersona[i].setNombre(nombre);
				mipersona[i].setEdad(edad);
				mipersona[i].setPeso(peso);
				mipersona[i].setAltura(altura);
			}
		}
		return mipersona;
	}

	private static void mostrarinformacion(persona[] mipersona) {
		for (int i=0;i<mipersona.length;i++){
			mipersona[i].mostrardatos("persona "+(i+1));
		}
	}


	private static String pedirdatos(String cadena) {
		String teclado=null;
		BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(cadena);
		try {
			teclado=leer.readLine();
		} catch (IOException e) {
			
		}
		return teclado;
	}
}
