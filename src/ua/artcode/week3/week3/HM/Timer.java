package ua.artcode.week3.week3.HM;

/**
 * Created by 1 on 09.09.14.
 */
public class Timer {
    private long delay;
    ActionX actionX;

    public Timer(long delay, ActionX actionX) {
        this.delay = delay;
        this.actionX = actionX;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public ActionX getActionX() {
        return actionX;
    }

    public void setActionX(ActionX actionX) {
        this.actionX = actionX;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "delay=" + delay +
                ", actionX=" + actionX +
                '}';
    }

    public void start() throws InterruptedException {
        Thread thread = new Thread("Action Thread");
        int sec = (int)delay;
        thread.sleep(sec);
        actionX.perform();
    }
}

