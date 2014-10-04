package ua.artcode.week5.hw;

public class Memory {

    private int id;
    private String producer;
    private float volume;

    public Memory(MemoryBuilder memoryBuilder) {
        this.id = memoryBuilder.id;
        this.producer = memoryBuilder.producer;
        this.volume = memoryBuilder.volume;
    }

    public int getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public float getVolume() {
        return volume;
    }



    public class MemoryBuilder {

        private int id;
        private String producer;
        private float volume;

        public MemoryBuilder() {
        }

        public MemoryBuilder(Memory original) {
            this.id = original.id;
            this.producer = original.producer;
            this.volume = original.volume;
        }

        public MemoryBuilder setId(int id){
            this.id = id;
            return this;
        }

        public MemoryBuilder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public MemoryBuilder setVolume(float volume){
            this.volume = volume;
            return this;
        }

        public Memory build(){
            return new Memory(this);
        }
    }
}
