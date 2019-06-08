/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

public class Processo {
    private int id;
    private int arrivalTime;
    private int priority;
    private int timeCPU;
    private int memory;
    private int printer;
    private int disc;
    private int qtdExec;
    private int tabelaDePaginas[];
    
    public Processo(int id, int arrivalTime, int priority, int timeCPU, int memory, int printer, int disc){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.timeCPU = timeCPU;
        this.memory = memory;
        this.printer = printer;
        this.disc = disc;
        this.setQtdExec(0);
    }
    
    public String toString(){
        return this.getId()+" "+this.arrivalTime+" "+this.priority+" "+this.timeCPU+" "+this.memory+" "+this.printer+" "+this.disc+"\n";  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    /**
     * @return the printer
     */
    public int getPrinter() {
        return printer;
    }

    /**
     * @param printer the printer to set
     */
    public void setPrinter(int printer) {
        this.printer = printer;
    }

    /**
     * @return the qtdExec
     */
    public int getQtdExec() {
        return qtdExec;
    }

    /**
     * @param qtdExec the qtdExec to set
     */
    public void setQtdExec(int qtdExec) {
        this.qtdExec = qtdExec;
    }

    /**
     * @return the timeCPU
     */
    public int getTimeCPU() {
        return timeCPU;
    }

    /**
     * @param timeCPU the timeCPU to set
     */
    public void setTimeCPU(int timeCPU) {
        this.timeCPU = timeCPU;
    }



    
    
}
