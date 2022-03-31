import java.util.ArrayList;
import java.util.Scanner;
import Classes.Banco;
import Classes.Cuenta;

public class SistemaBancario{
    public static void main(String[] args){

        int nip, numCue;

        Scanner scan = new Scanner(System.in);

        //Arreglo para ingresar a las cuentas del banco
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

        String nom, direc;
        float saldo;
        boolean exit = false;
        int count=0;
        while(!exit){
            printMenu();
            //Colocamos un switch case para crear el menu
            //este permitira ingresar a una cuenta de banco
            //o por otro lado crear desde cero una cuenta de banco
            switch(scan.nextInt()){
                case 1:
                    //Crear cuenta de banco y genera un numero de cuenta
                    System.out.printf("\nIntroducir nombre: ");
                    nom = scan.next();
                    scan.nextLine();

                    System.out.printf("\nIntroducir direccion: ");
                    direc = scan.next();
                    scan.nextLine();

                    System.out.printf("\nIntroducir saldo: ");
                    saldo = scan.nextFloat();

                    System.out.printf("\nIntroducir nip (ej: 2342): ");
                    nip = scan.nextInt();

                    Banco banco = new Banco();
                    cuentas.add(banco.registrarCuenta(nom, direc, saldo, nip));

                    System.out.printf("Numero de cuenta: %d", cuentas.get(count).getNumCue());
                    count++;

                    break;



                case 2:
                    //busca por numero de cuenta y mostrar informacion sobre dicha cuenta
                    boolean cuentaExiste = false;
                    int cuentaNIP = 0;
                    int cuentaIndice = 0;
                    int usuarioNIP = 0;

                    System.out.println("Introducir numero de cuenta: ");
                    numCue = scan.nextInt();

                    //Se utiliza para buscar la cuenta entre el arreglo
                    for(int i=0; i<cuentas.size(); i++){

                        //Comparar el numero de cuenta ingresado con las existentes cuentas
                        if(((cuentas.get(i).getNumCue() == numCue))){
                            cuentaExiste = true;
                            cuentaIndice = i;
                            cuentaNIP = cuentas.get(i).getNip();

                            //si la cuenta existe, entonces entrar a este menu
                            if(cuentaExiste){

                                //si la cuenta existe, pedir nip
                                System.out.println("Introducir nip: ");
                                usuarioNIP = scan.nextInt();

                                //si el nip ingresado es el mismo que el guardado, entra a menu
                                if(cuentaNIP == usuarioNIP){

                                    boolean exitOpcionesDeCuenta = false;
                                    float deposito = 0, nuevoSaldo = 0, retiro = 0;

                                    //while loop para seguir dentro de las opciones de cuenta
                                    while(!exitOpcionesDeCuenta){

                                        //imprimir menu de opciones de cuenta y preguntar a donde quiere ir
                                        printOpcionesDeCuenta();
                                        int opcionDeCuenta = scan.nextInt();
                                        switch(opcionDeCuenta){
                                            case 1:
                                                //Mostrar al usuario el saldo de la cuenta
                                                System.out.printf("\nSaldo: %.2f", cuentas.get(cuentaIndice).getSaldo());
                                                break;
                                            case 2:
                                                //Deposito de dinero
                                                System.out.println("\nCuanto vas a depositar: ");
                                                deposito = scan.nextFloat();
                                                nuevoSaldo = cuentas.get(cuentaIndice).getSaldo() + deposito;
                                                cuentas.get(cuentaIndice).setSaldo(nuevoSaldo);
                                                break;
                                            case 3:
                                                //Retiro de dinero
                                                System.out.println("\nCuanto quieres retirar?: ");
                                                retiro = scan.nextFloat();

                                                //verificar cuenta para poder realizar un retiro
                                                if(retiro <= cuentas.get(cuentaIndice).getSaldo()){
                                                    nuevoSaldo = cuentas.get(cuentaIndice).getSaldo() - retiro;
                                                    cuentas.get(cuentaIndice).setSaldo(nuevoSaldo);
                                                }else{
                                                    System.out.println("Cuenta con un saldo de cero, no puede realizar un retiro\n");
                                                }
                                                break;
                                            case 4:
                                                exitOpcionesDeCuenta = true;
                                                break;
                                            default:
                                                System.out.println("\nNo es valido");
                                                break;
                                        }
                                    }
                                }
                            }
                        }

                    }
                    //si la cuenta no fue encontrada, entonces informar que la cuenta no existe
                    if(!cuentaExiste){
                        System.out.println("La cuenta no existe, ingrese de nuevo los datos");
                    }
                    break;

                case 3:
                    System.out.println("Adios, gracias por usar nuestro banco!");
                    exit=true;
                    break;

                default:
                    //break condition
                    break;
            }
        }
        scan.close();
    }

    //Opciones del menu principal
    static void printMenu(){
        System.out.printf("\n\nMENU");
        System.out.printf("\n1) Crear cuenta");
        System.out.printf("\n2) Acceder a cuenta");
        System.out.printf("\n3) Exit");
        System.out.printf("\n\nEscoger una opcion(1-3):");
    }

    //Opciones de cuando accedes a una cuenta
    static void printOpcionesDeCuenta(){
        System.out.printf("\nOPCIONES DE CUENTA");
        System.out.printf("\n1) Consulta saldo");
        System.out.printf("\n2) Hacer deposito");
        System.out.printf("\n3) Hacer retiro");
        System.out.printf("\n4) Exit");
        System.out.printf("\nEscoge una opcion(1-4): ");
    }
}