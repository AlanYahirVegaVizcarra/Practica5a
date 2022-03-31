package Classes;
import java.util.Random;

//Es una clase Banco para permitir registrar nuevas cuentas
//con setters y getters para que obtengas y a la vez guardes los datos
public class Banco extends Cuenta{
    Cuenta cuenta = new Cuenta();

    //Aqui se colocan : nombre, direccion, saldo
    public Cuenta registrarCuenta(String nom, String direc, float saldo, int nip){
        this.cuenta.setNomClie(nom);
        this.cuenta.setDirec(direc);
        this.cuenta.setSaldo(saldo);
        this.cuenta.setNip(nip);

        //Genera un numero de cuenta (aleatorio)
        Random r = new Random( System.currentTimeMillis());
        this.cuenta.setNumCue(10000 + r.nextInt(20000));
        return this.cuenta;
    }
    public float AccederSaldo(int nip, int numCue){
        if((cuenta.getNip() == nip) &&
                (cuenta.getNumCue() == numCue)){
            return cuenta.getSaldo();
        }else{
            return 0;
        }
    }
}
