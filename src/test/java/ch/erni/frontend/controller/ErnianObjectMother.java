package ch.erni.frontend.controller;

import ch.erni.frontend.model.Ernian;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class ErnianObjectMother {

    public static final Ernian getClaudioHappyPath() {
        Ernian ernian = new Ernian();
        ernian.setId(UUID.fromString("1-1-1-1-1"));
        ernian.setCountry(new Locale("CH"));
        ernian.setFirstName("Claudio");
        ernian.setLastName("Kägi");
        ernian.setTown("Zürich");
        ernian.setZip("8050");
        ernian.setStreet("Thurgauerstrasse");
        return ernian;
    }

    public static final Ernian getAdrianHappyPath() {
        Ernian ernian = new Ernian();
        ernian.setId(UUID.fromString("2-2-2-2-2"));
        ernian.setCountry(new Locale("CH"));
        ernian.setFirstName("Adrian");
        ernian.setLastName("Müller");
        ernian.setTown("Zürich");
        ernian.setZip("8050");
        ernian.setStreet("Thurgauerstrasse");
        return ernian;
    }

    public static final Ernian getAdrianNullId() {
        Ernian ernian = new Ernian();
        ernian.setId(null);
        ernian.setCountry(new Locale("CH"));
        ernian.setFirstName("Adrian");
        ernian.setLastName("Müller");
        ernian.setTown("Zürich");
        ernian.setZip("8050");
        ernian.setStreet("Thurgauerstrasse");
        return ernian;
    }
}
