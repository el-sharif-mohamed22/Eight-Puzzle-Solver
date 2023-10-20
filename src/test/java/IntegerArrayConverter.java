import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntegerArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[].class == targetType) {
            String[] numbers = ((String) source).split(" ");
            int[] results = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                try {
                    results[i] = Integer.parseInt(numbers[i]);
                } catch (NumberFormatException e) {
                    throw new ArgumentConversionException("Failed to convert", e);
                }
            }
            return results;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }

}