package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Monteiro
 */
public class Impressora {
    private int id;
    private ArrayList<Processo> lista;
    
    private PrintStream erro;
    
    public Impressora(int id) throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.id = id;
        this.lista = new ArrayList<Processo>();
    }
    
    public void recebeProcesso(Processo p){
        try{
            this.lista.add(p);
        }catch(Exception e){
            this.erro.println("Erro 1 (Impressora.recebeProcesso): Não existe processo para ser adicionado.");
        }
    };
    
    
    public Object enviaProcesso(){
        try{
            return this.lista.remove(0);
        }catch(Exception e){
            this.erro.println("Erro 2 (Impressora.enviaProcesso): Fila Vazia.");
            return null;
        }
    }
}
