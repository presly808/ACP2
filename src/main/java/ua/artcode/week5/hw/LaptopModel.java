package ua.artcode.week5.hw;

public class LaptopModel {

    private int id;
    private String producer;
    private String model;

    public LaptopModel(LaptopModelBuilder laptopModelBuilder) {
        this.id = laptopModelBuilder.id;
        this.producer = laptopModelBuilder.producer;
        this.model = laptopModelBuilder.model;
    }

    public int getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }



    public class LaptopModelBuilder{

        private int id;
        private String producer;
        private String model;

        public LaptopModelBuilder() {
        }

        public LaptopModelBuilder(LaptopModel original) {
            this.id = original.id;
            this.producer = original.producer;
            this.model = original.model;
        }

        public LaptopModelBuilder setId(int id){
            this.id = id;
            return this;
        }

        public LaptopModelBuilder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public LaptopModelBuilder setModel(String model){
            this.model = model;
            return this;
        }

        public LaptopModel build(){
            return new LaptopModel(this);
        }
    }
}
