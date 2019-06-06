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
    
    public void adicionarProcesso(int arrivalTime, int priority, int timeCPU, int printer, int disc){
        this.id = 0;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.timeCPU = timeCPU;
        this.printer = printer;
        this.disc = disc;
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
}