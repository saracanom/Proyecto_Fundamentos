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
        this(p, m, c,30000000);    
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
 
        cantidad = cantidad + 1; 
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
        String informacion1 = "Placa: " + this.placa + ", Marca: " + this.marca;
        String informacion2 =  ", Color: " + this.color + ", Valor Comerical: " + this.valorComercial;
        String informacionCompleta = informacion1 + informacion2;
        return informacionCompleta;
    }
 
    public static String toStringVehiculos() {
 
        int i, j; 
        String infoTodos = "Información Vehiculos: "; 
        for (i = 0; i < vehiculos.length; i++) {
            for (j = 0; j < vehiculos[i].length; j ++) {
 
                if (vehiculos [i][j] != null) {
                    String infoIndividual = "{" + vehiculos[i][j].toString() + "}";
                    infoTodos = infoTodos + infoIndividual; 
                }
 
            }
        }
 
        return infoTodos; 
 
        }
 
    public static int cantidadVehiculos() {
        return cantidad; 
    }
    public static String vehiculosMismoColor(String color){
        String colorIgual = "Vehículos con el color " + color + ":";
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j ++) {
 
                if (vehiculos[i][j] != null && color.equalsIgnoreCase(vehiculos[i][j].getColor())) {
                    String infoIndividual = " " + vehiculos[i][j].toString();
                    colorIgual = colorIgual + infoIndividual;    
                } 
            }
        }
 
        if(colorIgual.equals("Vehículos con el color " + color + ":")) {
            colorIgual = colorIgual + " Ninguno"; }
 
        return colorIgual;
    }
    public static Vehiculo[] mostrarValorComercial(){
        Vehiculo temp = new Vehiculo();
        int k = 0;
        int filas = Vehiculo.vehiculos.length;
        int columnas = Vehiculo.vehiculos[0].length;
        Vehiculo[] ordenValor = new Vehiculo[filas*columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                ordenValor[k++] = Vehiculo.vehiculos[i][j];

        for(int i = 1; i<ordenValor.length ; i++){
            for(int j = 0; j<(ordenValor.length -1); j++){
                    if(ordenValor[j]!=null && ordenValor[j+1]!=null && ordenValor[j].getValorComercial()>ordenValor[j+1].getValorComercial()){
                    temp = ordenValor[j];
                    ordenValor[j] = ordenValor[j+1];
                    ordenValor[j+1] = temp;
                    }else{
                        continue;
                    }
            }
        }
        return ordenValor;
    }
}
