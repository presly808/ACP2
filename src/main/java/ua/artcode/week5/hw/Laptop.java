package ua.artcode.week5.hw;

public class Laptop {

    private LaptopModel model;
    private Processor processor;
    private HardDisc hardDisc;
    private Memory memory;
    private VideoCard videoCard;
    private Screen screen;

    public Laptop(LaptopModel model, Processor processor, HardDisc hardDisc, Memory memory, VideoCard videoCard, Screen screen) {
        this.model = model;
        this.processor = processor;
        this.hardDisc = hardDisc;
        this.memory = memory;
        this.videoCard = videoCard;
        this.screen = screen;
    }

    public LaptopModel getModel() {
        return model;
    }

    public void setModel(LaptopModel model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HardDisc getHardDisc() {
        return hardDisc;
    }

    public void setHardDisc(HardDisc hardDisc) {
        this.hardDisc = hardDisc;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
