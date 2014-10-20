package ua.artcode.week8.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 19.10.2014.
 */
@Component
public class Client {

    @Autowired
    @Qualifier(value = "service1")
    private IService iService;

    public Client() {
    }

    public Client(IService iService) {
        this.iService = iService;
    }

    public IService getiService() {
        return iService;
    }

    public void setiService(IService iService) {
        this.iService = iService;
    }
}
