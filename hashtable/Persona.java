package hashtable;

public class Persona {
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono1;
	private String telefono2;
	
	public Persona(){}
	
	public Persona(String nombre, String apellido, String direccion, String telefono1, String telefono2) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	
	@Override
	public boolean equals(Object otro){
		if (otro == null) return false;
	    if (otro == this) return true;
	    if (!(otro instanceof Persona))return false;
	    Persona otraPersona = (Persona)otro;
	    if(nombre.equalsIgnoreCase(otraPersona.getNombre()) 
	    		&& apellido.equalsIgnoreCase(otraPersona.getApellido())
	    		&& direccion.equalsIgnoreCase(otraPersona.getDireccion())
	    		&& telefono1.equalsIgnoreCase(otraPersona.getTelefono1())
	    		&& telefono2.equalsIgnoreCase(otraPersona.getTelefono2())){
	    	return true;
	    }
	    return false;
	}
	
}
