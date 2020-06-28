package SolidMaster.dependency_inversion.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class WeatherTracker {
    public String currentConditions;

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
    }

    public void notify(Notifier notifier) {
        notifier.alertWeatherConditions(currentConditions);
    }

    public static void main(String[] args) {
        WeatherTracker weatherTracker = new WeatherTracker();
        weatherTracker.setCurrentConditions("sunny");
        weatherTracker.notify(new EmailClient());
        weatherTracker.setCurrentConditions("rainy");
        weatherTracker.notify(new MobileDevice());
    }
}


