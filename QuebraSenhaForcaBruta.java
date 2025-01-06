import java.util.Scanner;

public class QuebraSenhaForcaBruta {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma senha de 4 digitos: ");
        String senha = sc.next();

        System.out.println("Digite uma opcao: ");
        System.out.println("1 - para o programa executar com dicas");
        System.out.println("2 - para o programa executar sem dicas");
        int opcao = sc.nextInt();
        long tempoInicial =  System.currentTimeMillis();
        try {
            if (opcao == 1) {
                execucaoComDicas(senha);
            } else if (opcao == 2) {
                execucaoSemDicas(senha);
            } else {
                System.out.println("Opcao invalida");
            }
        } catch (Exception e) {
            System.out.println("Opcao invalida");
        }
        long tempoFinal =  System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial) + " milissegundos");
        sc.close();
    } 
    
    private static void execucaoComDicas(String senha) {
        int guessValue = 5000;
        int guessTry = guessValue;
        if (senha.toString().length() == 4 && senha.matches("[0-9]+")) {
            System.out.println("Senha digitada: " + senha);
            int tentativas = 0;
            int senhaInt = Integer.parseInt(senha);
            for (int i = 0; i <= 9999; i++) {
                tentativas++;
                if (senhaInt == guessTry) {
                    System.out.println("Senha encontrada em " + tentativas + " tentativas");
                    break;
                }else if (guessTry < senhaInt) {
                    guessTry = guessTry + (guessValue / 2);
                    if (guessValue == 0 || (guessValue / 2 == 0)) {
                        guessTry += 1; 
                    }else{
                        guessValue = guessValue / 2;
                    }
                }else {
                    guessTry = guessTry - (guessValue / 2);
                    if (guessValue == 0 || (guessValue / 2 == 0)) {
                        guessTry -= 1; 
                    }else{
                        guessValue = guessValue / 2;
                    }
                }
            }
        }else {
            System.out.println("Valor da senha digitada invalida");
        }
    }

    private static void execucaoSemDicas(String senha) {
        for (int i = 0; i <= 9999; i++) {
            if (i == Integer.parseInt(senha)) {
                System.out.println("Senha encontrada");
                break;
            }
        }
    }
}
            
    