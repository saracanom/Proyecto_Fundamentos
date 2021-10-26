package proyecto_fundamentos;
public class Vehiculo {
    
    private String placa; 
    private String marca; 
    private String color; 
    private int valorComercial;
 
    public static int tamano;
    public static int cantidad = 0;
    public static Vehiculo[][] vehiculos; 
 
 
    public Vehiculo() {
 
    }
 
    public Vehiculo(String p, String m, String c) {
        this(p, m, c, 30000000);    
    }
 
    public Vehiculo(String p, String m, String c, int v) {
        this.placa = p.toUpperCase(); 
        this.marca = m.toUpperCase(); 
        this.color = c.toUpperCase(); 
 
        if (v >= 0) {
          this.valorComercial = v;
        } else {
          this.valorComercial = 30000000;
        }
 
        cantidad++; 
    }
 
    public void setPlaca(String p) {
        this.placa = p.toUpperCase(); 
    }
 
    public String getPlaca() {
       return this.placa;
    }
 
    public void setMarca(String m) {
        this.marca = m.toUpperCase(); 
    }
 
    public String getMarca() {
       return this.marca;
    }
 
    public void setColor(String c) {
        this.color = c.toUpperCase(); 
    }
 
    public String getColor() {
       return this.color;
    }
 
    public void setValorComercial(int v) {
        if (v >= 0) {
          this.valorComercial = v;
        } else {
          this.valorComercial = 30000000;
        } 
    }
 
    public int getValorComercial() {
       return this.valorComercial;
    }
 
    public String toString() {
        String informacion1 = "{Placa: " + this.placa + ", Marca: " + this.marca;
        String informacion2 =  ", Color: " + this.color + ", Valor Comerical: " + this.valorComercial + "}";
        String informacionCompleta = informacion1 + informacion2;
        return informacionCompleta;
    }
 
    public static String toStringVehiculos() {
        String infoTodos = "Información Vehículos:"; 
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j ++) {
 
                if (vehiculos [i][j] != null) {
                    String infoIndividual = " " + vehiculos[i][j].toString();
                    infoTodos = infoTodos + infoIndividual; 
                }
            }
        }
        
        if (infoTodos.equals("Información Vehículos:")) {
            infoTodos = "No hay ningún vehículo en el parqueadero"; }
 
        return infoTodos; 
    }
 
    public static int cantidadVehiculos() {
        return cantidad; 
    }
    
    public static String vehiculosMismoColor(String c){
        String colorIgual = "Vehículos con el color " + c + ":";
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j ++) {
 
                if (vehiculos[i][j] != null && c.equals(vehiculos[i][j].getColor())) {
                    String infoIndividual = " " + vehiculos[i][j].toString();
                    colorIgual = colorIgual + infoIndividual;    
                } 
            }
        }
 
        if(colorIgual.equals("Vehículos con el color " + c + ":")) {
            colorIgual = colorIgual + " Ninguno"; }
 
        return colorIgual;
    }
    
    public static Vehiculo[] valoresOrdenados(int cantidadActual){
        Vehiculo[] ordenValor = new Vehiculo[cantidadActual];
        int k = 0;
        
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) { 
                
                if(vehiculos[i][j] != null){
                    ordenValor[k] = vehiculos[i][j];
                    k++; 
                }
            }
        }
        
        Vehiculo temp = new Vehiculo();
        
        for(int i = 0; i < (ordenValor.length -1); i++){
             if(ordenValor[i].getValorComercial() > ordenValor[i+1].getValorComercial()){
                temp = ordenValor[i];
                ordenValor[i] = ordenValor[i+1];
                ordenValor[i+1] = temp; 
            }
        }
        
        return ordenValor;
    }
   
}
