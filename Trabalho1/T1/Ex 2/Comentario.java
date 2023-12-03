import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Comentario {
    private static BufferedReader in_fp;
    private static char proximoCaractere;
    private static int estadoAtual;
    

    public static void main(String[] args) {

        try {
            in_fp = new BufferedReader(new FileReader("entrada.txt"));
            String line;
            while ((line = in_fp.readLine()) != null) {
                System.out.println("Testando: " + line);
                if (reconhecerComentario(line)) {
                    System.out.println("Comentario valido: " + line);
                } else {
                    System.out.println("Comentario invalido: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    private static boolean reconhecerComentario(String entrada) {
        estadoAtual = 0;
        for (int i = 0; i < entrada.length(); i++) {
            char caractere = entrada.charAt(i);
            transicao(caractere);
        }
        return estadoAtual == 4; // Estado FINAL
    }

    private static void transicao(char caractere) {
        switch (estadoAtual) {
            case 0:
                if (caractere == '/') {
                    estadoAtual = 1;
                } else {
                    estadoAtual = -1;
                }
                break;

            case 1:
                if (caractere == '*') {
                    estadoAtual = 2;

                } else {
                    estadoAtual = -1; // Estado inválido
                }
                break;
            case 2:
                if (Character.isLetterOrDigit(caractere) || caractere == ' ' || caractere == '.'|| caractere == '-' || caractere == '_' || caractere == '+' || caractere == '=' || caractere == ',' || caractere == '!' || caractere == '{' || caractere == '}' || caractere == '(' || caractere == ')' || caractere == '[' || caractere == ']' || caractere == '@' || caractere == '#' || caractere == '&' || caractere == ':' || caractere == ';' || caractere == '?' || caractere == '<' || caractere == '>' || caractere == '%') {
                    estadoAtual = 2;
                } 
                else if(caractere == '*') {
                    estadoAtual = 3;
                }
                else {
                    estadoAtual = -1; // Estado inválido
                }
                break;
            case 3:
                if (Character.isLetterOrDigit(caractere) || caractere == ' ' || caractere == '.'|| caractere == '-' || caractere == '_' || caractere == '+' || caractere == '=' || caractere == ',' || caractere == '!' || caractere == '{' || caractere == '}' || caractere == '(' || caractere == ')' || caractere == '[' || caractere == ']' || caractere == '@' || caractere == '#' || caractere == '&' || caractere == ':' || caractere == ';' || caractere == '?' || caractere == '<' || caractere == '>' || caractere == '>' || caractere == '%') {
                    estadoAtual = 2;
                } 
                else if (caractere == '/') {
                    estadoAtual = 4;
                }
                else {
                    estadoAtual = -1; // Estado inválido
                }
                break;

                case 4:
                if (Character.isDigit(caractere)) {
                    estadoAtual = -1;
                }
                break;
        }
    }
}