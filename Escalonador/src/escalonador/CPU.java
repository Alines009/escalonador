
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
            this.tempoUtilizacao = p.getTimeCPU();
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
                this.p.setTimeCPU(0);
            }else{
                this.p.setTimeCPU(
                    (this.p.getTimeCPU() - this.tempoUtilizacao)
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
    
    public boolean isOcioso(){
        return (this.p == null)? true: false;
    }
    
    public int getPrioridadeProcesso(){
        return (p == null) ? -1 : p.getPriority();
    }
}
