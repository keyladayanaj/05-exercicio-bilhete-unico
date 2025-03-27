import java.util.Random;

public class BilheteUnico {

    long numero;
    double saldo;
    static final double TARIFA = 5.20;
    Usuario usuario;

    public BilheteUnico(String nome, long cpf, String perfil){
        Random random = new Random();
        numero = random.nextLong(1000, 10000);
        usuario = new Usuario(cpf, nome, perfil);
    }

    //método para carregar o bilhete

    public double carregar(double valor){
        saldo += valor;
        return saldo;
    }

    //método para consultar o saldo do bilhete

    public double consultarSaldo(){

        return saldo;
    }

    //método para passar na catraca

    public String passarNaCatraca(){

        double debito= TARIFA /2;

        if(usuario.perfil.equalsIgnoreCase("Comum")){
            debito = TARIFA;
        }
        if(saldo >= debito){
            saldo -= debito;
            return "Catraca liberada";
        }
        return "Saldo insuficiente";


    }


}