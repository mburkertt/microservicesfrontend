package ch.erni.frontend.service;

import ch.erni.frontend.model.Ernian;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

import static ch.erni.frontend.service.ErnianObjectMother.getAdrianHappyPath;
import static ch.erni.frontend.service.ErnianObjectMother.getAdrianNullId;
import static ch.erni.frontend.service.ErnianObjectMother.getClaudioHappyPath;
import static org.assertj.core.api.Assertions.assertThat;

public class FileReaderServiceTest {

    FileWriterReaderServiceImpl classUnderTest = new FileWriterReaderServiceImpl();

    @Test
    public void test_read_and_write_ernians() {
        classUnderTest.writeErnians(getClaudioHappyPath());
        Map<UUID, Ernian> result = classUnderTest.readErnians();
        Ernian testErnian = result.get(UUID.fromString("1-1-1-1-1"));
        assertThat(testErnian).extracting(
                Ernian::getFirstName,
                Ernian::getLastName,
                Ernian::getStreet)
                .containsExactly(
                        getClaudioHappyPath().getFirstName(),
                        getClaudioHappyPath().getLastName(),
                        getClaudioHappyPath().getStreet());
    }

    @Test
    public void test_read_and_write_ernians_different(){
        classUnderTest.writeErnians(getAdrianHappyPath());
        Map<UUID, Ernian> result = classUnderTest.readErnians();
        Ernian testErnian = result.get(UUID.fromString("2-2-2-2-2"));
        assertThat(testErnian).extracting(
                Ernian::getFirstName,
                Ernian::getLastName,
                Ernian::getStreet)
                .containsExactly(
                        getAdrianHappyPath().getFirstName(),
                        getAdrianHappyPath().getLastName(),
                        getAdrianHappyPath().getStreet());
    }

    @Test(expected=NullPointerException.class)
    public void test_read_and_write_ernians_with_null_id_throws_nullpointer(){
        classUnderTest.writeErnians(getAdrianNullId());
        Map<UUID, Ernian> result = classUnderTest.readErnians();
    }

}
