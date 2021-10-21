/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_fundamentos;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Ingrese la cantidad de pisos del edificio: ");
        int pisos = scan.nextInt();
        System.out.println(" ");
        System.out.println("Ingrese la cantidad de espacios de parqueo por piso: ");
        int espacios = scan.nextInt();
        System.out.println(" ");
 
        if(pisos > 0 && espacios > 0) {
            Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
            Sensor.sensores = new Sensor[pisos][espacios];
        } else {
            System.out.println("El valor de los pisos y los espacios debe ser mayor que 0");
            System.exit(0);
        }
 
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < espacios; j ++) {
                Sensor S = new Sensor(0); 
                Sensor.sensores[i][j] = S;  
            }
        }
        Vehiculo.tamano = pisos*espacios;
        System.out.println("Ingrese el numero de la acción que desea realizar: ");
        System.out.println("1 - Mostrar Sensores desocupados");
        System.out.println("2 - Parquear vehiculo sin valor comercial");
        System.out.println("3 - Parquear vehiculo con valor comercial");
        System.out.println("4 - Mostrar información de vehiculos almacenados");
        System.out.println("5 - Mostrar historial de la cantidad de vehiculos creados");
        System.out.println("6 - Mostrar estado de un sensor");
        System.out.println("7 - Mostrar estado de todos los sensores");
        System.out.println("8 - Mostrar color de todos los vehículos");
        System.out.println("9 - Mostrar valor comercial de todos los vehiculos");
        System.out.println("0 - Salir ");
        
        int accion = scan.nextInt();
        while(accion!=0){
            if(accion != 0){
                switch(accion){
                    case 1: 
                        System.out.println(Sensor.sensorLibre());
                        break;
                    case 2: 
                        if (Vehiculo.cantidad == Vehiculo.tamano) {
                            System.out.println("El parqueadero esta lleno. No puede parquear.");
                            break;
                        }
                        System.out.println("Ingrese el piso donde desea parquear el vehiculo: ");
                        System.out.println("Recuerde que los pisos disponibles para parquear van del 0 al "+(pisos-1));
                        int piso = scan.nextInt();
                        System.out.println("Ingrese el espacio donde desea parquear el vehiculo: ");
                        System.out.println("Recuerde que los espacios disponibles para parquear van del 0 al "+(espacios-1));
                        int espacio = scan.nextInt();
                        
                        if(piso<pisos && espacio<espacios && piso>=0 && espacio>=0){
                            if(Sensor.sensores[piso][espacio].getEstado()==1){
                                System.out.println("Este espacio está ocupado. No se puede parquear");
                            } else {
                                System.out.println("Ingrese la placa del vehiculo:");
                                String placa = scan.next();
                                System.out.println("Ingrese la marca del vehiculo:");
                                String marca = scan.next();
                                System.out.println("Ingrese el color del vehiculo:");
                                String color = scan.next();
                                Vehiculo v = new Vehiculo(placa,marca,color);
                                Vehiculo.vehiculos[piso][espacio] = v;
                                Sensor.sensores[piso][espacio].setEstado(1);
                                System.out.println("Vehiculo parqueado en el piso "+piso+" espacio "+espacio+": "+ Vehiculo.vehiculos[piso][espacio].toString());   
                            }
                        } else {
                            System.out.println("Espacio o piso inválido");
                        }
                        break;
                    case 3:
                         if (Vehiculo.cantidad == Vehiculo.tamano) {
                            System.out.println("El parqueadero esta lleno. No puede parquear.");
                            break;
                        }
                        System.out.println("Ingrese el piso donde desea parquear el vehiculo: ");
                        System.out.println("Recuerde que los pisos disponibles para parquear van del 0 al "+(pisos-1));
                        int piso2 = scan.nextInt();
                        System.out.println("Ingrese el espacio donde desea parquear el vehiculo: ");
                        System.out.println("Recuerde que los espacios disponibles para parquear van del 0 al "+(espacios-1));
                        int espacio2 = scan.nextInt();
                        
                        if(piso2<pisos && espacio2<espacios && piso2>=0 && espacio2>=0){
                            if(Sensor.sensores[piso2][espacio2].getEstado()==1){
                                System.out.println("Este espacio está ocupado. No se puede parquear");
                                
                            } else {
                                System.out.println("Ingrese la placa del vehiculo:");
                                String placa = scan.next();
                                System.out.println("Ingrese la marca del vehiculo:");
                                String marca = scan.next();
                                System.out.println("Ingrese el color del vehiculo:");
                                String color = scan.next();
                                System.out.println("Ingrese el valor comercial del vehiculo:");
                                int valor = scan.nextInt();
                                Vehiculo v = new Vehiculo(placa,marca,color,valor);
                                Vehiculo.vehiculos[piso2][espacio2] = v;
                                Sensor.sensores[piso2][espacio2].setEstado(1);
                                System.out.println("Vehiculo parqueado en el piso "+piso2+" espacio "+espacio2+": "+ Vehiculo.vehiculos[piso2][espacio2].toString());   
                            }
                        } else {
                            System.out.println("Espacio o piso inválido");
                            
                        }
                        break;
                        case 4: 
                            System.out.println(Vehiculo.toStringVehiculos());
                            break;
                        case 5:
                            System.out.println("Cantidad de vehiculos: "+Vehiculo.cantidad);
                            int cantidadRestante = Vehiculo.tamano - Vehiculo.cantidad;
                            System.out.println("Pueden entrar " + cantidadRestante + " vehículo(s) más al parqueadero");
                            break;
                        case 6:
                            System.out.println("Ingrese el piso del parqueadero que desea consultar:");
                            System.out.println("Recuerde que los pisos disponibles para parquear van del 0 al "+(pisos-1));
                            int piso3 = scan.nextInt();
                            System.out.println("Ingrese el espacio del parqueadero que desea consultar:");
                            System.out.println("Recuerde que los espacios disponibles para parquear van del 0 al "+(espacios-1));
                            int espacio3 = scan.nextInt();
                            if(piso3<pisos && espacio3<espacios && piso3>=0 && espacio3>=0){
                                System.out.println("El estado del sensor en el piso "+piso3+" y espacio "+espacio3+" es: "+Sensor.sensores[piso3][espacio3].toString());
                            } else {
                                System.out.println("Espacio o piso inválido");
                            }
                            break;
                        case 7:
                            System.out.println(Sensor.sensorEstado());
                            break;
                        case 8: 
                            System.out.println("Ingrese el color que desea buscar: ");
                            String color = scan.next();
                            System.out.println(Vehiculo.vehiculosMismoColor(color));
                            break;
                        case 9:
                            Vehiculo[] ordenValor = Vehiculo.mostrarValorComercial();
                            for(int i = 0; i<ordenValor.length ; i++){
                            if(ordenValor[i] != null){
                             System.out.println(ordenValor[i].toString());
                            }
                            }
                            
                            break;
                            
                        default: 
                        System.out.println("Comando incorrecto");
                        break;                   
            }
            } else if (accion == 0) {
                System.out.println("Saliendo...");
                break; 
            }
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Ingrese una nueva opción del menú:");
            accion = scan.nextInt();
            System.out.println(" ");
           
        }
        
        
    }
}
