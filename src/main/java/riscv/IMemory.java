package riscv;

public interface IMemory {

    int get(int sourceAddress);

    void set(int targetAddress, int value);
    
}
