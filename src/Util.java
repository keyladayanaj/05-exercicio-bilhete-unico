import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    //banco de dados

    private BilheteUnico[] bilhete =  new BilheteUnico[2];
    private int index = 0;

    public void menuPrincipal(){
        int opcao =0;
        String menu = "1. Administrador\n2. Usuário\n3 . Finalizar*";

        do {
           opcao =parseInt(showInputDialog(menu));
           switch(opcao){
               case 1:
                   menuAdministrador();
                   break;
               case 2:
                   menuUsuario();
                   break;
           }
        } while(opcao != 3);

    }

    public void menuAdministrador(){
        int opcao;

        String menu = "MENU ADMINISTRADOR\n";
        menu += "1. Emitir bilhete\n";
        menu += "2. Listar bilhete\n";
        menu += "3. Excluir bilhete\n";
        menu += "4. Sair\n";

        do {
            opcao = parseInt(showInputDialog(menu));
            switch (opcao){
                case 1:
                emitirBilhete();
                break;
                case 2:
                listarBilhetes();
                    break;
                case 3:
                    removerBilhete();
                    break;
            }
        } while(opcao != 4);
    }

    private void emitirBilhete(){

        String nome, perfil;
        long cpf;
        if(index < bilhete.length){
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseLong(showInputDialog("CPF: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum");
            bilhete[index] = new BilheteUnico(nome,cpf, perfil);
            index++;
        }

        else {
            showMessageDialog(null, "Procure um posto de atendimento");
        }


    }

    private void listarBilhetes(){

        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";

        for(int i =0; i< index; i++){
            aux += "Número do bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do bilhete: R$ " + df.format(bilhete[i].saldo)+ "\n";
            aux += "Usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF: " + bilhete[i].usuario.cpf + "\n";
        }

        showMessageDialog(null, aux);

    }

    private void menuUsuario(){

        int opcao;
        String menu = "1. Carregar bilhete\n2. Consultar salado\n" +
                      "3. Passar na catraca\n4. Sair";

        do{
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 4){
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch (opcao){
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultarSaldo();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;
                }
            }
        }while(opcao != 4);
    }

    private void consultarSaldo(){

        int indice = pesquisar();

        if(indice != -1){
            showMessageDialog(null,"Saldo = R$ " + bilhete[indice].consultarSaldo());
        }

    }

    private void carregarBilhete (){

        int indice = pesquisar();
        double valor;

        if(indice != -1){
           valor = parseDouble(showInputDialog("Valor da recarga"));
           bilhete[indice].carregar(valor);
        }

    }

    private void passarNaCatraca(){

       int indice = pesquisar();

        if(indice != -1){
            showMessageDialog(null, bilhete[indice].passarNaCatraca());
        }
    }

    private int pesquisar(){

        long cpf = parseLong(showInputDialog("CPF"));

        for( int i =0; i< index; i++){
            if(bilhete[i].usuario.cpf == cpf){
                return i;
            }
        }
        showMessageDialog(null, cpf + "não encontrado");
        return -1;

    }

    private void removerBilhete(){

        int resposta;

        int indice = pesquisar();

        if(indice != -1){
            resposta = showConfirmDialog(null, "Tem certeza que deseja excluir?");

            if (resposta == YES_OPTION){
                bilhete[indice] = bilhete[indice - 1];
                index--;

            }
        }

    }


}


