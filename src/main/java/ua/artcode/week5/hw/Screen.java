package ua.artcode.week5.hw;

public class Screen {

    private int id;
    private float size;

    public Screen(ScreenBuilder screenBuilder) {
        this.id = screenBuilder.id;
        this.size = screenBuilder.size;
    }

    public int getId() {
        return id;
    }

    public float getSize() {
        return size;
    }


    public class ScreenBuilder{

        private int id;
        private float size;

        public ScreenBuilder() {
        }

        public ScreenBuilder(Screen original) {
            this.id = original.id;
            this.size = original.size;
        }

        public ScreenBuilder setId(int id){
            this.id = id;
            return this;
        }

        public ScreenBuilder setSize(float size){
            this.size = size;
            return this;
        }

        public Screen build(){
            return new Screen(this);
        }
    }
}
