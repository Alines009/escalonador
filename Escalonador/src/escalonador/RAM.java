
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Monteiro
 */
public class RAM {
    private int espacoTotal;
    private int espacoAlocado;
    private ArrayList<Integer> fila;
    private PrintStream erro;
    private int quadroDaMP[];
    private int quadrosAlocados;
    
    public RAM() throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.espacoAlocado = 0;
        this.fila = new ArrayList<Integer>();
        this.espacoTotal = 16384; // 16GB em MB (MegaByte)   
        this.quadrosAlocados = 0;        //A MP eh dividida em 256 quadros cada uma de tamanho igual a 64MB  
        this.quadroDaMP = new int [256];
    }
    
    int alocaProcesso(Processo p){
        try{
            if( (this.espacoAlocado + p.getMemory()) <= this.espacoTotal ){
                this.espacoAlocado += p.getMemory();
                this.fila.add(p.getId());
                return 0;
            }
            this.erro.println("Erro 3 (RAM.alocaProcesso): Não há espaço para o processo para ser alocado.");
            return 3;           
        }catch(Exception e){
            this.erro.println("Erro 1 (RAM.alocaProcesso): Não existe processo para ser alocado.");
            return 1;
        }
    }
    
    int desalocaProcesso(Processo p){
        if( !this.fila.isEmpty()){
            if(this.fila.contains(p.getId())){
                if(this.espacoAlocado - p.getMemory() <= 0){
                    this.espacoAlocado -= p.getMemory();
                    this.fila.remove(p.getId());
                    return 0;
                }
                this.erro.println("Erro 3 (RAM.desalocaProcesso): Espaço alocado com valor negativo.");
                return 3;
            }
            this.erro.println("Erro 1 (RAM.desalocaProcesso): Não existe processo para ser desalocado.");
            return 1;
        }
        this.erro.println("Erro 2 (RAM.desalocaProcesso): Fila Vazia.");
        return 2;
    }
}
