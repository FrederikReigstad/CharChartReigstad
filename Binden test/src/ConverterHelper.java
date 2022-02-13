import javafx.util.StringConverter;

public class ConverterHelper extends StringConverter<Number> {


    @Override
    public String toString(Number num) {
        return num.toString();
    }

    @Override
    public Number fromString(String string) {
        try {
            Double d = Double.parseDouble(string);
            return d;
        }
        catch (NumberFormatException error){
            return 0;
        }
    }
}
