package ex2p1_josebendana;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2P1_JoseBendana {

    public static void main(String[] args) {
        segundomain();
    }
    
    public static void segundomain() {
        Scanner numeros = new Scanner(System.in);
        Scanner oraciones = new Scanner(System.in);
        ArrayList<Vacas> vacas = new ArrayList();
        ArrayList<Vegetales> vegetales = new ArrayList();
        ArrayList<Conejos> conejos = new ArrayList();
        System.out.print("Bienvenido a la granja: ");
        String name = oraciones.nextLine();
        Granja granja=new Granja(name);
        int monets= 500;
        int cantidad=0;
        int copia = 0;
        int contadordias=0;
        for (int i = 1; i <= 15; i++) {
            System.out.println("<------------Dia: "+i+"------------>");
            if ((i==1)||(copia<=0)){
                System.out.println("No hay cosechas");
            }else if(contadordias>0){
                System.out.println("Faltan "+contadordias+" para poder cosechar");
            }else{
                System.out.println("Ya hay cosechas");
            }
            System.out.println("Que desea hacer?");
            System.out.println("1. -Plantar cosechas");
            System.out.println("2. -Cosechar las cosechas");
            System.out.println("3. -Conseguir animales");
            System.out.println("4. -Vender Animales");
            System.out.println("5. -Dormir");
            System.out.println("6. -Terminar el juego");
            System.out.print("Ingrese que actividad desea hacer: ");
            int actividad = numeros.nextInt();
            switch(actividad){
                case 1:
                    if(contadordias ==0){
                        cantidad = plantar();
                        copia = cantidad;
                        contadordias=6;
                        cantidad = 0;
                    }else if (contadordias != 0){
                        System.out.println("Ya hay plantas en la tierra, no puede plantar");
                    }
                    break;
                case 2:
                    if(contadordias==0){
                        cosechar(copia, granja);
                        System.out.println("Ahora tiene "+granja.vegetales.size()+" vegetales");
                        contadordias=1;
                        copia=0;
                    }else if(contadordias!=0){
                        System.out.println("Las plantas no estan listas aun no puede cosechar");
                    }
                    break;
                case 3:
                    monets = comprar(granja, monets);
                    break;
                case 4:
                    monets = vender(granja, monets, vacas, vegetales, conejos);
                    break;
                case 5:
                    System.out.println("Buenas noches, que Dios lo bendiga");
                    System.out.println("Amen");
                    break;
                case 6:
                    Scanner car = new Scanner(System.in);
                    Scanner enter = new Scanner(System.in);
                    if (monets>10000){
                        System.out.println("""
                                           Como esta granja fue otro rollo y llego a tener mas de 10000 MONETSSSS
                                           es decir fue mas que un exito, el owner fue contratado en una empresa multi-
                                           millonaria de animales. 
                                            """);
                        System.out.print("Usted decide quiere continuar en la empresa o no?[s/n]:");
                        char resp = car.next().charAt(0);
                        if ((resp=='s')||(resp=='S')) {
                            System.out.print("Presione ENTER para continuar");
                            enter.nextLine();
                            System.out.println("NAHHHHHHHHHHHHHHHHHHH, te la creiste???? no estoy para otras 5 horas talvez tomorrow.");
                        }else if((resp=='n')||(resp=='N')){
                            System.out.println("Bueno te lo perdiste");
                        }else{
                            System.out.println("DIOS MIOOOOOOOOOO, como es eso que no le podes dar a una tecla, bye");
                        }
                    }else{
                        System.out.println("Bueno para tanto tiempo que tuvo (Dias infinitos) y no pudo hacer ni 10000");
                        System.out.println("monets en una vida donde se puede conseguir billete infinito el owner");
                        System.out.println("como es tan tronco en la vida decidio tirarse de un puente por que queria acabar con");
                        System.out.println("ella perooooo es tan desgraciado que sobrevivio y se dio cuenta que esta en un juego");
                        System.out.println("y no puede morir y su vida termina cuando 2000 dias despues se cierra el juego");
                        System.out.println();
                        System.out.println("Si quere ver el otro final solo agruegue (monets=10000000;) en la parte superior del case 6");
                    }
                    i=200;
                    break;
                default:
                    System.out.println("Buenaaaaaaaaaa, por chavacan gasto un dia");
                    break;
            }
                contadordias--;
        }
    }
    
    public static int plantar(){
        Scanner plantar = new Scanner(System.in);
        System.out.print("Ingrese cuantas plantas quiere cosechar: ");
        int cantidad = plantar.nextInt();
        System.out.println("Plantando cosechas......");
        System.out.println("Las cosechas tardaran 5 dias en estar");
        int contador = cantidad;
        return contador;
    }
    
    public static void cosechar(int copia, Granja granja){
        for (int j = 0; j < copia; j++) {
            granja.addvegetal();
        }
        
    }
    
    public static int comprar(Granja granja,int monets){
        int cuantosquiere;
        int precio;
        Scanner comp = new Scanner(System.in);
        Scanner oracion = new Scanner(System.in);
        System.out.println("Cantidad de dinero actual: "+monets);
        System.out.println("""
                           1. -Conejos -> 150 monets
                           2. -Vacas   -> 350 monets
                           """);
        System.out.print("Que animales desea? ");
        int cualcompra = comp.nextInt();
        switch(cualcompra){
            case 1:
                System.out.print("Cuantos conejos desea? ");
                cuantosquiere = comp.nextInt();
                int valorcon = 150;
                precio = cuantosquiere*valorcon;
                if (monets>=precio) {
                    System.out.println("Conejos comprado$$$");
                    monets-=precio;
                    for (int i = 0; i < cuantosquiere; i++) {
                        System.out.print("Ingrese el nombre del conejo: ");
                        String conejoname = oracion.nextLine(); 
                        granja.addconejo(conejoname);
                        System.out.println(conejoname+" Ha sido enviad@ a la granja");
                    }
                }else{
                    System.out.println("LO SIENTO NO TIENES SUFICIENTES MONETS");
                }
                System.out.println("Ahora tienes "+monets+" monets");
                break;
            case 2:
                System.out.print("Cuantas Vacas desea? ");
                cuantosquiere = comp.nextInt();
                int valorvaca = 350;
                precio = cuantosquiere*valorvaca;
                if (monets>=precio) {
                    System.out.println("Vacas comprado$$$");
                    monets-=precio;
                    for (int i = 0; i < cuantosquiere; i++) {
                        System.out.print("Ingrese el nombre de la vaca: ");
                        String vacaname = oracion.nextLine(); 
                        granja.addvaca(vacaname);
                        System.out.println(vacaname+" Ha sido enviad@ a la granja");
                    }
                }else{
                    System.out.println("LO SIENTO NO TIENES SUFICIENTES MONETS");
                }
                System.out.println("Tu nueva cantidad de dinero es: "+monets);
                break;
            default:
                System.out.println("No compra nada");
                break;
        }
        return monets;
    }
    
    public static int vender(Granja granja, int monets ,ArrayList<Vacas> vacas, ArrayList<Vegetales> vegetales, ArrayList<Conejos> conejos){
        Scanner entero = new Scanner(System.in);
        System.out.println("Que deseas vender?");
        System.out.println("----------ANALISIS DE GRANJA----------");
        granja.printgranja();
        System.out.println("Tienes "+monets+" Monets");
        System.out.println("--------------------------------------");
        System.out.println("""
                           1. Vegetales
                           2. Conejos
                           3. Vacas
                           """);
        System.out.println("Seleccione[1-3]: ");
        int opcion = entero.nextInt();
        switch(opcion){
            case 1:
                if(granja.vagesize()>0){
                    System.out.print("Ingrese la cantidad a vender: ");
                    int vender = entero.nextInt();
                    if(granja.vagesize()>=vender){
                        monets += (vender*100);
                        System.out.println("Se han vendido "+vender+" vegetales");
                        for (int i = 0; i < vender; i++) {
                            granja.vegetales.remove(0);
                        }
                    }else{
                        System.out.println("No tiene esa cantidad");
                    }
                }else{
                    System.out.println("Dejese de loqueras que no tiene ni uno");
                }
                break;
            case 2:
                if(granja.conejosize()>0){
                    System.out.println("La cantidad de conejos es: "+granja.conejosize());
                    System.out.println("Y sus nombres son: ");
                    for (int i = 0; i < granja.conejosize(); i++) {
                        System.out.println(granja.nombrecon(i));
                    }
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cant = entero.nextInt();
                    if(granja.conejosize()>=cant){
                        for (int i = 0; i < cant; i++) {
                            System.out.print("Bye Bye "+granja.nombrecon(0));
                            granja.Conejos.remove(0);
                        }
                        System.out.println("Se han vendido "+cant+" conejos");
                        monets += (cant * 170);
                    }else{
                        System.out.println("No tiene esa cantidad");
                    }
                }else{
                    System.out.println("Dejese de loqueras que no tiene ni uno");
                }
                break;
            case 3:
                if(granja.vacasize()>0){
                    System.out.println("La cantidad de vacas es: "+granja.vacasize());
                    System.out.println("Y sus nombres son: ");
                    for (int i = 0; i < granja.vacasize(); i++) {
                        System.out.println(granja.nombrevac(i));
                    }
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantvac = entero.nextInt();
                    if(granja.vacasize()>=cantvac){
                        for (int i = 0; i < cantvac; i++) {
                            System.out.print("Bye Bye "+granja.nombrevac(0));
                            granja.vacas.remove(0);
                        }
                        System.out.println("Se han vendido "+cantvac+" conejos");
                        monets += (cantvac * 400);
                    }else{
                        System.out.println("No tiene esa cantidad");
                    }
                }else{
                    System.out.println("Dejese de loqueras que no tiene ni uno");
                }
                break;
            default:
                System.out.println("OMG, LEEEEEE, barbaro solo se podia [1, 2 o 3]");
                break;
        }
        System.out.println("Tu nueva cantidad de dinero es: "+monets+"Monets");
        return monets;
    }
}
