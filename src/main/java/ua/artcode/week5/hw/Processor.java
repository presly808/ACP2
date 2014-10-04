package ua.artcode.week5.hw;

public class Processor {

    private int id;
    private String producer;
    private float frequency;

    public Processor(ProcessorBuilder processorBuilder) {
        this.id = processorBuilder.id;
        this.producer = processorBuilder.producer;
        this.frequency = processorBuilder.frequency;
    }

    public int getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public float getFrequency() {
        return frequency;
    }



    public class ProcessorBuilder {

        private int id;
        private String producer;
        private float frequency;

        public ProcessorBuilder() {
        }

        public ProcessorBuilder(Processor original) {
            this.id = original.id;
            this.producer = original.producer;
            this.frequency = original.frequency;
        }

        public ProcessorBuilder setId(int id){
            this.id = id;
            return this;
        }

        public ProcessorBuilder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public ProcessorBuilder setFrequency(float frequency){
            this.frequency = frequency;
            return this;
        }

        public Processor build(){
            return new Processor(this);
        }
    }
}
