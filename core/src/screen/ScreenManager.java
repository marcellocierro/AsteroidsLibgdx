package screen;

/**
 * Created by Marcello395 on 11/17/17.
 */
public class ScreenManager {
    private static Screen current_screen;

    public static void setScreen(Screen screen){
        if(current_screen != null) {
            current_screen.dispose();
        }
        current_screen = screen;
        current_screen.create();

    }

    public static Screen getCurrent_screen(){
        return current_screen;
    }
}
