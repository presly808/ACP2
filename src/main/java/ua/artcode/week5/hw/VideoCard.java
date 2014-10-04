package ua.artcode.week5.hw;

public class VideoCard {

    private int id;
    private String producer;
    private float volume;

    public VideoCard(VideoCardBuilder videoCardBuilder) {
        this.id = videoCardBuilder.id;
        this.producer = videoCardBuilder.producer;
        this.volume = videoCardBuilder.volume;
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



    public class VideoCardBuilder {

        private int id;
        private String producer;
        private float volume;

        public VideoCardBuilder() {
        }

        public VideoCardBuilder(VideoCard original) {
            this.id = original.id;
            this.producer = original.producer;
            this.volume = original.volume;
        }

        public VideoCardBuilder setId(int id){
            this.id = id;
            return this;
        }

        public VideoCardBuilder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public VideoCardBuilder setVolume(float volume){
            this.volume = volume;
            return this;
        }

        public VideoCard build(){
            return new VideoCard(this);
        }
    }
}
