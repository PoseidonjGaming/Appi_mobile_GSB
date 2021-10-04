package com.example.splashscreen;

public class Visiteur {
    private int ID_VISIT;
    private String NOM;
    private String PRENOM;
    private String LOGIN;
    private String MDP;
    private String ADRESSE;
    private String CP;
    private String VILLE;


    public Visiteur(int id_visit, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville) {
        ID_VISIT = id_visit;
        NOM = nom;
        PRENOM = prenom;
        LOGIN = login;
        MDP = mdp;
        ADRESSE = adresse;
        CP = cp;
        VILLE = ville;
    }

    public int getID_VISIT() {
        return ID_VISIT;
    }

    public void setID_VISIT(int ID_VISIT) {
        this.ID_VISIT = ID_VISIT;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public String getADRESSE() {
        return ADRESSE;
    }

    public void setADRESSE(String ADRESSE) {
        this.ADRESSE = ADRESSE;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getVILLE() {
        return VILLE;
    }

    public void setVILLE(String VILLE) {
        this.VILLE = VILLE;
    }
}
