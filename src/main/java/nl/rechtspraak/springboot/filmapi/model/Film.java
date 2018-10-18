package nl.rechtspraak.springboot.filmapi.model;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * De film klasse;
 */
public class Film {
    private String titel;
    private int releaseJaar;
    private Set<String> acteurs = new HashSet<>();
    private Duration duur;
    private String regisseur;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getReleaseJaar() {
        return releaseJaar;
    }

    public void setReleaseJaar(int releaseJaar) {
        this.releaseJaar = releaseJaar;
    }

    public Duration getDuur() {
        return duur;
    }

    public void setDuur(Duration duur) {
        this.duur = duur;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public Set<String> getActeurs() {
        return Collections.unmodifiableSet(acteurs);
    }

    public void addActeurs(String... acteurs) {
        this.acteurs.addAll(Arrays.asList(acteurs));
    }
}
