import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntegerMultiArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[][].class.isAssignableFrom(targetType)) {
            String[] rows = ((String) source).replace("[[", "").replace("]]", "").split("] \\[");
            int[][] result = new int[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                String[] cols = rows[i].split(" ");
                result[i] = new int[cols.length];
                for (int j = 0; j < cols.length; j++) {
                    try {
                        result[i][j] = Integer.parseInt(cols[j].trim());
                    } catch (NumberFormatException e) {
                        throw new ArgumentConversionException("Failed to convert input to 2D int array", e);
                    }
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to " + targetType + " not supported.");
        }
    }
}