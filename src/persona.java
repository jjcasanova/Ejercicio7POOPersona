
public class persona {

	private String nombre;
	private double peso, altura;
	private int edad;
	private dni midni;
	private char sexo;
	
	public persona() {
		final char sexo='H';
		this.sexo=sexo;
		generaDNI();
	}
	
	public persona(String nombre, int edad, char sexo){
		this.nombre=nombre;
		this.edad=edad;
		this.sexo=comprobarSexo(sexo);
		generaDNI();
	}
	
	public persona(String nombre, int edad, char sexo, double peso, double altura){
		this.nombre=nombre;
		this.edad=edad;
		this.peso=peso;
		this.altura=altura;
		this.sexo=comprobarSexo(sexo);
		generaDNI();
	}
	
	protected byte calcularIMC(){
		final double pesoideal=this.peso/(Math.pow(this.altura, 2));
		if (peso>pesoideal) return 1;
		else if (peso<pesoideal) return -1;
			else return 0;
	}
	
	protected boolean esMayorDeEdad(){
		final byte mayoredad=18;
		if (edad>=mayoredad) return true;
		else return false;
	}
	
	private char comprobarSexo(char sexo){
		if (sexo!='H' && sexo!='M') return 'H';
		else return sexo;
	}
	
	public String toString(){
		persona mipersona= new persona();
		return null;
	}
	
	private void generaDNI(){
		midni=new dni();
		final char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int numero=0;
		numero=(int)Math.floor(Math.random()*99999999+999999);
		char letra=letras[numero%23];
		midni.setNumero(numero);
		midni.setLetra(letra);
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	protected void setPeso(double peso) {
		this.peso = peso;
	}


	protected void setAltura(double altura) {
		this.altura = altura;
	}


	protected void setEdad(int edad) {
		this.edad = edad;
	}


	protected void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void mostrardatos(String cadena) {
		System.out.println("Estos son los datos de la " + cadena);
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Sexo: " + sexo);
		System.out.println("Altura: " + altura);
		System.out.println("Peso: "+peso);
		System.out.println("DNI: " + midni.getNumero() + "-" + midni.getLetra());
	}
	
	
}
