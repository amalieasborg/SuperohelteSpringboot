package org.example.superoheltespringboot.Model;

public class MarvelCharacter {
    private Long id;
    private String name;
    private String alias;
    private String powers;
    private String alignment;

    public MarvelCharacter() {
    }

    public MarvelCharacter(Long id, String name, String alias, String powers, String alignment) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.powers = powers;
        this.alignment = alignment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
