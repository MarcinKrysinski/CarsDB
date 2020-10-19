package pl.krysinski.db.model.validator;

import pl.krysinski.db.model.Color;

public class ColorValidator {

    public static String validateColor(String stringColor) {
        String color = stringColor.toLowerCase();

        if (color.equals("black")){
            return String.valueOf(Color.black);
        }else if (color.equals("white")){
            return String.valueOf(Color.white);
        }else if (color.equals("red")){
            return String.valueOf(Color.red);
        }else if (color.equals("green")){
            return String.valueOf(Color.green);
        }else if (color.equals("blue")) {
            return String.valueOf(Color.blue);
        }else if (color.equals("yellow")){
            return String.valueOf(Color.yellow);
        }else if (color.equals("silver")){
            return String.valueOf(Color.silver);
        }
        return String.valueOf(Color.unknown);
    }

}
