package modelo;

public class Tarjeta {
    
    private String nombre;
    private int numero;
    private String fecha;
    private int csv;

    public Tarjeta(String pnombre,int pnumero, String pfecha, int pcsv){
        this.nombre=pnombre;
        this.numero=pnumero;
        this.fecha=pfecha;
        this.csv=pcsv;
    }
    public int getNumero(){
        return this.numero;
    }
    public boolean validarNombre (String elNombre){
        String patron = "^[^0-9]*$";
    
        return elNombre.matches(patron);
    }
    public boolean validacion(){
        boolean resp=true;
        if(!validarNombre(this.nombre)){
            resp=false;
        }
        if (!verificarNumeroMaximoDigitos(this.numero)){
            resp=false;
        } 
        return resp;
    }
    public boolean verificarNumeroMaximoDigitos(int numero) {
        // Calcular la cantidad de dígitos utilizando logaritmo en base 10
        int cantidadDigitos = (int) (Math.log10(numero) + 1);
        
        // Verificar si la cantidad de dígitos es menor o igual a 12
        return cantidadDigitos <= 12;
    }
}
