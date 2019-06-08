/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;



/**
 *
 * @author Ricardo Monteiro
 */
public class FilaPrioridade {
    private ArrayList<Processo> filaPrioridade;
    private PrintStream erro;
    
    public FilaPrioridade() throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.filaPrioridade = new ArrayList<Processo>();
    }
    
    public int processoFinalizou(Processo p){
        if(p.getArrivalTime() == 0){
            return 20;            
        }else if(p.getArrivalTime() != 0){
            return 10;      
        }  
        this.erro.println("Erro 1 (FilaPrioridade.processoFinalisou): Não existe processo para comparar o tempo.");
        return 1;     
    }
    
    public int recebeProcesso(Processo p){
        if(this.processoFinalizou(p) == 20){
            return 0;
        }else if(this.processoFinalizou(p) == 10){
            this.erro.println("Erro 4 (FilaPrioridade.recebeProcesso): Processo retornado não foi executado por completo pela CPU.");
            return 4;
        }
        this.erro.println("Erro 1 (FilaPrioridade.recebeProcesso): Não existe processo para ser adicionado.");
        return 1;
    }
    
    public Object enviaProcesso(){
        try{
            return this.filaPrioridade.remove(0);
        }catch(Exception e){
            this.erro.println("Erro 2 (FilaPrioridade.enviaProcesso): Fila Vazia.");
            return 2;
        }
    }
}
