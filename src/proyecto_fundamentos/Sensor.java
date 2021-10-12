/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_fundamentos;

/**
 *
 * @author EQUIPO
 */
public class Sensor {
    public static Sensor[][] sensores;
    private int estado;
    public Sensor(){
        
    }
    public Sensor(int e){
        this.estado = e;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public String toString(){
        if(estado == 1){
            return "Ocupado";
        } else if (estado == 0) {
            return "Libre";
        }
        return "Libre";
    }
        public static String sensorLibre(){
        String concat="";
        for(int i=0;i<sensores.length; i++){
            for(int j=0;j<sensores[i].length;j++){
                if(sensores[i][j]!= null){
                    if(sensores[i][j].getEstado()==0){
                        int piso=i;
                        int espacio=j;
                        concat=("Piso: "+piso+"Espacio: "+espacio+", ")+concat;
                    }
                }
            }
        }
        return concat;
    }
    public static String sensorEstado(){
        String concat="";
        for(int i=0;i<sensores.length; i++){
            for(int j=0;j<sensores[i].length;j++){
                int piso=i;
                int espacio=j;
                concat=("Piso: "+piso+"Espacio: "+espacio+"Estado: "+sensores[i][j].getEstado())+concat;
                    }
                }
        return concat;
            }
}
