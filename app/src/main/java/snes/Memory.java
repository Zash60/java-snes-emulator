package snes;
public class Memory {
    public byte[] physicalMemory;
    public boolean HiROM = true;
    public String name = "Loaded ROM";
    public SNES snes;
    public Memory(SNES snes) {
        this.snes = snes;
        physicalMemory = new byte[0x1000000];
        for (int i=0x7e0000; i<0x7fffff; i++) physicalMemory[i]=0x55;
    }
    public void loadRomBytes(byte[] rawdata) {
        // Tenta carregar no endereço padrão de HiROM (C00000)
        int cartridgeOffset = rawdata.length % 0x1000;
        try {
            for(int address=0xc00000; address<=0xffffff; address++) {
                int index = address - 0xc00000 + cartridgeOffset;
                if (index < rawdata.length) physicalMemory[address] = rawdata[index];
            }
            // Configura vetores de reset
            if(rawdata.length > 4) {
                physicalMemory[0xfffc] = rawdata[rawdata.length - 4];
                physicalMemory[0xfffd] = rawdata[rawdata.length - 3];
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    public byte readByte(int address) {
        if (address >= 0 && address < physicalMemory.length) return physicalMemory[address];
        return 0;
    }
    public void writeByte(int address, byte value) {
        if (address >= 0 && address < physicalMemory.length) physicalMemory[address] = value;
    }
    // Mocks
    public void loadCartridge(Object c) {}
    public void loadMemoryState(String s) {}
    public String dumpMemoryState() { return ""; }
}
