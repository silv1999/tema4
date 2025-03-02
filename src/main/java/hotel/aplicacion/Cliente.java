/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

/**
 *
 * @author Silvia
 */
public class Cliente {
    private static int contadorClientes = 0;
    private int codigo;
    private String nombre;
    private String dni;
    private String telefono;

   /**
    * Constructor clase Cliente
    * @param nombre Nombre cliente
    * @param dni DNI cliente
    * @param telefono telefono cliente
    * @throws Exception
    */
    public Cliente(String nombre, String dni, String telefono) throws Exception {
        // Validación del DNI, si no es correcto no creará el objeto
        Utilidades.validarDNI(dni); 
        this.setNombre(nombre);
        this.setDni(dni);
        this.setTelefono(telefono);
        this.codigo = obtenerNumeroCliente();
    }
    /**
     * Genera numero de cliente
     * @return Numero del cliente 
     */

        private static int obtenerNumeroCliente() {
        contadorClientes++;
        return contadorClientes;
    }
        /**
         * Muestra la información del cliente
         * @return Codigo con el nombre, DNI y telefono del cliente
         */

    
    public String mostrarInformacion() {
        return "Código: " + codigo + ", Nombre: " + getNombre() + ", DNI: " + getDni() + ", Teléfono: " + getTelefono();
    }
    /**
     * Obtiene teléfono del cliente
     * @return Telefono del cliente
     */

	public String getTelefono() {
		return telefono;
	}
	/**
	 * Establece teléfono del cliente
	 * @param telefono Telefono del cliente
	 */

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 *  Obtiene DNI del cliente
	 * @return DNI del cliente
	 */

	public String getDni() {
		return dni;
	}
	/**
	 * Establece DNI del cliente
	 * @param dni DNI del cliente
	 */

	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Obtiene nombre del cliente
	 * @return Nombre del cliente
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece nombre del cliente
	 * @param nombre Nombre del cliente
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
