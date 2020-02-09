package by.bsuir.filmography.service.converter;

import by.bsuir.filmography.service.convertaition.InputDataConverter;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class InputDataConverterTest {
    @Test
    public void dateConverterShouldReturnNull() {
        String emptyString = "";
        Assert.assertNull(InputDataConverter.convertDate(emptyString));
    }
    @Test
    public void dateConverterShouldReturnLocalDate() {
        String externalDate = "2020-02-07";
        LocalDate expected = LocalDate.parse(externalDate);
        Assert.assertEquals(expected, InputDataConverter.convertDate(externalDate));
    }
    @Test
    public void intConverterShouldReturnNegativeOne() {
        String emptyString = "";
        Assert.assertEquals(-1, InputDataConverter.convertID(emptyString));
    }
    @Test
    public void intConverterShouldReturnPositiveNumber() {
        String externalData = "13";
        Assert.assertEquals(13, InputDataConverter.convertID(externalData));
    }
}
