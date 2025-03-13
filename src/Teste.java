import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        int [] x = new int [5];
        carregarDados(x);
        imprimir(x);
    }

    public static void imprimir(int [] x){

        for(int i=0; i<x.length; i++){
            System.out.println(x[i]);
        }

        for(int i : x ){
            System.out.println(i);
        }
    }

    public static void carregarDados(int [] x){
        Random random = new Random();
        for(int i =0; i<x.length; i++){
            x[i] = random.nextInt(15);
        }

    }

}
