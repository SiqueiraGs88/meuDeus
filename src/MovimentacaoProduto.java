
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Date;

public class MovimentacaoProduto {

    // Logger para registrar as ações de exclusão e adição de produtos.
    private static final Logger log = Logger.getLogger(ProdutoGestao.class.getName());
    public void logAutomatic(int numLog){
        
        switch (numLog) {
            
            case 1:
            try {
                // Cria o diretório "logs" se ele não existir
                java.io.File logDir = new java.io.File("logs");
                if (!logDir.exists()) {
                    logDir.mkdirs();
                }
                // Cria um FileHandler que grava os logs no arquivo "logs/exclusao_produtos.log" (modo append)
                FileHandler fileHandler = new FileHandler("logs/exclusao_produtos.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                log.addHandler(fileHandler);
                // Evita que os logs também sejam enviados ao console pelos handlers do logger pai
                log.setUseParentHandlers(false);
            } catch (IOException e) {
                System.err.println("Erro ao configurar o logger: " + e.getMessage());
            }
            
                log.info("Produto adicionado em " + new Date());
                System.out.println("Produto adicionado com sucesso!");
                break;
        
            case 2:
            case 3:
            case 4:
            default:
            log.warning("Nao foi possivel acessar o switch case.\n");
            System.out.println("\nNao haS casos correspondente. Saindo...\n");

                break;
        }
        

    }

    

    
}



    

