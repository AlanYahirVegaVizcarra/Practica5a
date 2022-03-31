package Classes;

//Crea una clase Cuenta, que tendrá diferentes atributos que, por la naturaleza
//de esta información deberán permanecer todos privados y solo ser accesibles para la clase Banco.


public class Cuenta{
    private int nip;
    private int numCue;
    private float saldo;
    private String nomClie;
    private String direc;

    //getters y setters para cada tipo de informacion respectivo
    public int getNip(){
        return this.nip;
    }
    public void setNip(int nip){
        this.nip = nip;
    }

    public int getNumCue(){
        return this.numCue;
    }
    public void setNumCue(int numCue){
        this.numCue = numCue;
    }

    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public String getNomClie(){
        return this.nomClie;
    }
    public void setNomClie(String nomClie){
        this.nomClie = nomClie;
    }

    public String getDirec(){
        return this.direc;
    }
    public void setDirec(String direc){
        this.direc = direc;
    }
}