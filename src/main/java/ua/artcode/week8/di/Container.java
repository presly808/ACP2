package ua.artcode.week8.di;

/**
 * Created by admin on 19.10.2014.
 */
public class Container {

    @ForInject
    private IFormatter formatter;

    public Container() {
    }

    public IFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(IFormatter formatter) {
        this.formatter = formatter;
    }
}
