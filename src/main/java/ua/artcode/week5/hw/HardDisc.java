package ua.artcode.week5.hw;

public class HardDisc {

    private int id;
    private String producer;
    private float volume;

    public HardDisc(HardDiskBuilder hardDiskBuilder ) {
        this.id = hardDiskBuilder.id;
        this.producer = hardDiskBuilder.producer;
        this.volume = hardDiskBuilder.volume;
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



    public class HardDiskBuilder {

        private int id;
        private String producer;
        private float volume;

        public HardDiskBuilder() {
        }

        public HardDiskBuilder(HardDisc original) {
            this.id = original.id;
            this.producer = original.producer;
            this.volume = original.volume;
        }

        public HardDiskBuilder setId(int id){
            this.id = id;
            return this;
        }

        public HardDiskBuilder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public HardDiskBuilder setVolume(float volume){
            this.volume = volume;
            return this;
        }

        public HardDisc build(){
            return new HardDisc(this);
        }
    }

}
