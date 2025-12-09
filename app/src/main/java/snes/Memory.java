package snes;
public class Memory {
    public byte[] physicalMemory;
    public boolean HiROM = true;
    public String name = "No ROM";
    public SNES snes;
    
    public Memory(SNES snes) {
        this.snes = snes;
        physicalMemory = new byte[0x1000000]; // 16MB de espaço endereçável
        // Inicializa RAM
        for (int i=0x7e0000; i<0x7fffff; i++) physicalMemory[i]=0x55;
    }

    public void loadRomBytes(byte[] rawdata) {
        System.out.println("Carregando ROM de " + rawdata.length + " bytes");
        // Lógica simplificada de carregamento (LoROM/HiROM detection básica)
        // Assume HiROM por padrão para o teste
        int cartridgeOffset = rawdata.length % 0x1000;
        
        try {
            // Copia para a memória (Mapeamento HiROM simplificado)
            for(int address=0xc00000; address<=0xffffff; address++) {
                int index = address - 0xc00000 + cartridgeOffset;
                if (index < rawdata.length) {
                    physicalMemory[address] = rawdata[index];
                }
            }
            // Espelha vetores de interrupção
            physicalMemory[0xfffc] = rawdata[rawdata.length - 4]; // Reset Vector Low
            physicalMemory[0xfffd] = rawdata[rawdata.length - 3]; // Reset Vector High
        } catch(Exception e) {
            System.out.println("Erro ao carregar ROM na memoria");
        }
    }

    public byte readByte(int address) {
        if (address >= 0 && address < physicalMemory.length) return physicalMemory[address];
        return 0;
    }
    public void writeByte(int address, byte value) {
        if (address >= 0 && address < physicalMemory.length) physicalMemory[address] = value;
    }
    // Métodos de compatibilidade
    public void loadCartridge(Object c) {}
    public void loadMemoryState(String s) {}
    public String dumpMemoryState() { return ""; }
}
