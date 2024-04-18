// заключается в создании объекта-фасада,
// который представляет собой единый интерфейс к более широкому набору интерфейсов внутри системы

package semestr4.Task_7.FacadePattern;

public class CarFacade {
    private Engine engine;
    private Lights lights;

    public CarFacade() {
        this.engine = new Engine();
        this.lights = new Lights();
    }
    public void startCar() {
        engine.start();
        lights.turnOn();
    }
    public void stopCar() {
        engine.stop();
        lights.turnOff();
    }
}
