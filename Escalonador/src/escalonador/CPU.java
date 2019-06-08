/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Ricardo Monteiro
 */
public class CPU {
    private int id;
    private Processo p;
    private int tempoUtilizacao;
    private PrintStream erro;
    
    public CPU(int id) throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.id = id;
        this.p = null;
    }
    
    public int recebeProcesso(Processo p){
        if(p != null){
            this.p = p;
            this.tempoUtilizacao = p.getArrivalTime();
            return 0;
        }
        this.erro.println("Erro 1 (CPU.recebeProcesso): Não existe processo para ser adicionado.");
        return 1;        
    }
    
    public int recebeProcesso(Processo p, int t){
        if(p != null){
            this.p = p;
            this.tempoUtilizacao = t;
            return 0;
        }
        this.erro.println("Erro 1 (CPU.recebeProcesso): Não existe processo para ser adicionado.");
        return 1;
    }
    
    public Object enviaProcesso(){
        if(this.p != null){
            if(p.getPriority() == 0){
                this.p.setArrivalTime(0);
            }else{
                this.p.setArrivalTime(
                    (this.p.getArrivalTime() - this.tempoUtilizacao)
                );
                
                this.p.setQtdExec(
                    (this.p.getQtdExec() + 1)
                );
            }
            
            Processo p = this.p;
            this.p = null;
            this.tempoUtilizacao = 0;
            return p;
        }
        this.erro.println("Erro 2 (CPU.enviaProcesso): Não existe processo para ser enviado.");
        return 2;
        
    }
}
