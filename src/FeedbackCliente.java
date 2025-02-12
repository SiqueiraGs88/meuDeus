<<<<<<< HEAD
import java.io.*;
import java.util.Scanner;

public class FeedbackCliente { // classe com métodos e atributos para gerar um arquivo.txt de feedback com uma mensagem.
    static Scanner feedbackSc = new Scanner(System.in);
        private static String caminhoFeedback = "Feedback.txt"; // criando o arquivo, com o caminho específico. 
        
        public static void verificarOuCriarArquivo() { // verifica se o arquivo ja foi criado, caso não seja cai em um catch.
            File feedback = new File(caminhoFeedback);
            try {
                if (feedback.createNewFile()) {
                    System.out.println("Arquivo de relatórios criado.");// caso seja criado, irá exibir essa mensagem.
                }
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo."); /// trata exceção para caso o arquivo não possa ser criado.
            }
        }
    
        public static void informacaoInicial(Scanner sc) {
            System.out.println("Olá! Você está na página de feedback, aqui você pode deixar seus elogios, reclamacoes e/ou sugestoes.(Pressione 1 para continuar)");
    
            int continueAction = 0;
    
            while (true) { // apenas um verificação para ver se o usuário apertou a tecla correta para continuar.
                if (sc.hasNextInt()) {
                    continueAction = sc.nextInt();
                    sc.nextLine();
                    
    
                    if (continueAction == 1) {
                        break; // Sai do loop quando o valor correto for digitado.
                    }
                } else {
                    sc.nextLine(); // Descarta entrada inválida.
                }
    
                System.out.println("Opa. Algo deu errado, tente novamente.\n");
            }
        }
    
    public static void escritorDeTexto() { // método para escrever o tiutulo e o assunto que você deseja realizar.
            System.out.println("Digite o título do seu feedback.");
            String titulo = feedbackSc.nextLine();
        System.out.println("Digite o texto do seu feedback.");
        String texto = feedbackSc.nextLine();
        escreverFeedback("Feedback.txt", titulo, texto); //passa para o método escrever feedback o titulo e assunto digitados ateriormente.
    }

    public static void escreverFeedback(String nomeDoArquivo, String titulo, String texto) {
        try (BufferedWriter escritorFeed = new BufferedWriter(new FileWriter(nomeDoArquivo, true))) {
            escritorFeed.write("\t=== " + titulo + " ===\n");
            escritorFeed.write(texto + "\n\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage()); // execeção caso não seja possível escrever no arquivo. e.getMessage gera um mensagem padrão.
        }
    }

    public static String escolherAcao(Scanner sc) { // método para escolher ação que você deseja realizar.
        String[] opStrings = {"Elogios", "Reclamacoes", "Sugestoes"};

        System.out.println("Escolha o tipo de feedback que você deseja realizar:");
        System.out.println("1 - Elogios.");
        System.out.println("2 - Reclamações.");
        System.out.println("3 - Sugestões.");

        if (sc.hasNextInt()) {// se é um inteiro que está sendo passado como entrada.
            int opcaoFeed = sc.nextInt();
            sc.nextLine(); // Limpar buffer para evitar problemas nas em scanners futuros.

            if (opcaoFeed == 1) {
                return opStrings[0]; // Aqui foi feito uma condicional para verificar qual opção foi esscolhida pelo usuário.
            } else if (opcaoFeed == 2) {
                return opStrings[1];
            } else if (opcaoFeed == 3) {
                return opStrings[2];
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                return escolherAcao(sc); // Chama o método novamente, caso nenhumma das opções sejam selecionadas.
            }
        } else {
            sc.nextLine(); // Descarta entrada inválida
            System.out.println("Entrada inválida. Tente novamente.");
            return escolherAcao(sc); // Chama o método novamente, caso a entrada inicial não seja adequada.
        }
    }

    public static void lerFeedback() {
        File arquivo = new File("Feedback.txt");  // aqui, simplesmente, vai abrir o arquivo de texto.
        if (!arquivo.exists()) {
            System.out.println("Nenhum relatório encontrado.");
            return;
        }

        try (Scanner leitor = new Scanner(arquivo)) { // esse bloco serve para ler o arquivo.
            while (leitor.hasNextLine()) { //enquanto houver linhas para serem lidas, ele vai mostrar as linhas e mostrar o relatório.
                System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao ler o arquivo."); // execeção caso não consiga ler o feedback por algum motivo.
        }
    }
}
=======
import java.util.logging.FileHandler;
import java.util.logging.Logger; // bibliotecas padrão do Java para logs
import java.util.logging.SimpleFormatter;
import java.io.*;
import java.util.Scanner;

public class FeedbackCliente {
    
    // Bloco estático adicionado para configurar o FileHandler sem alterar a estrutura original
    static {
        try {
            // Cria o diretório "logs" se não existir
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdirs();
            }
            // Cria o FileHandler para o arquivo "logs/app.log" (modo append)
            FileHandler fileHandler = new FileHandler("logs/app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            // Adiciona o FileHandler ao logger da classe
            Logger.getLogger(FeedbackCliente.class.getName()).addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Erro ao configurar o logger: " + e.getMessage());
        }
    }
    
    // Seu código original permanece inalterado abaixo:
    private static final Logger log = Logger.getLogger(FeedbackCliente.class.getName()); // inicializa o logger.
    static Scanner feedbackSc = new Scanner(System.in);
    private static String caminhoFeedback = "Feedback.txt"; // criando o arquivo, com o caminho específico.
    
    public static void verificarOuCriarArquivo() {
        File feedback = new File(caminhoFeedback);
        try {
            if (feedback.createNewFile()) {
                log.info("Arquivo de feedback criado.");
            }
        } catch (IOException e) {
            log.severe("Erro ao criar o arquivo de feedback.");
        }
    }
    
    public static void informacaoInicial(Scanner sc) {
        System.out.println("Olá! Você está na página de feedback, aqui você pode deixar seus elogios, reclamações e/ou sugestões. (Pressione 1 para continuar)");
        int continueAction = 0;
        while (true) {
            if (sc.hasNextInt()) {
                continueAction = sc.nextInt();
                sc.nextLine();
                if (continueAction == 1) {
                    break;
                }
            } else {
                sc.nextLine();
            }
            log.warning("Opa. Algo deu errado, tente novamente.\n");
        }
    }
    
    public static void escritorDeTexto() { // escreve o corpo da mensagem de feedback que você deseja.
        log.info("Digite o título do seu feedback.");
        String titulo = feedbackSc.nextLine();
        log.info("Digite o texto do seu feedback.");
        String texto = feedbackSc.nextLine();
        escreverFeedback(caminhoFeedback, titulo, texto);
    }
    
    public static void escreverFeedback(String nomeDoArquivo, String titulo, String texto) { // passa como parametros o caminho, titulo e texto digitados.
        try (BufferedWriter escritorFeed = new BufferedWriter(new FileWriter(nomeDoArquivo, true))) {
            escritorFeed.write("\t=== " + titulo + " ===\n"); // formatação padronizada para mensagem de tiulo
            escritorFeed.write(texto + "\n\n"); // escreve texto.
        } catch (IOException e) {
            log.severe("Erro ao escrever no arquivo: " + e.getMessage()); // erro se não puder escrever a mensagem.
        }
    }
    
    public static String escolherAcao(Scanner sc) { // wesse bloco serve para escolgher uma ação para realizar: sugestão, elogios ou reclamações.
        String[] opStrings = {"Elogios", "Reclamações", "Sugestões"};
        log.info("Escolha o tipo de feedback que você deseja realizar:\n1 - Elogios.\n2 - Reclamações.\n3 - Sugestões.");
        if (sc.hasNextInt()) {
            int opcaoFeed = sc.nextInt();
            sc.nextLine();
            if (opcaoFeed == 1) {
                return opStrings[0];
            } else if (opcaoFeed == 2) {
                return opStrings[1];
            } else if (opcaoFeed == 3) {
                return opStrings[2];
            } else {
                log.warning("Opção inválida. Tente novamente."); // caso não digite nenhuma opção válida.
                return escolherAcao(sc);
            }
        } else {
            sc.nextLine();
            log.severe("Entrada inválida. Tente novamente."); // caso a mensagem innicial seja inválida.
            return escolherAcao(sc);
        }
    }
    
    public static void lerFeedback() { // método para verificar se há algum arquivo existente
        File arquivo = new File(caminhoFeedback);
        if (!arquivo.exists()) {
            log.info("Nenhum relatório encontrado.");
            return;
        }
        try (Scanner leitor = new Scanner(arquivo)) { // aqui serve para ler o arquivo até houver linhas não nulas.
            while (leitor.hasNextLine()) {
                log.info(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            log.severe("Erro ao ler o arquivo de feedback."); // tratamento caso ocorra algum outro erro.
        }
    }
}
    
>>>>>>> 9f1f05c (atualizoes 12/2)
