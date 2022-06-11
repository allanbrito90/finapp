package br.com.at.finapp.enumeration;

public enum EnumRepetirDespesas {

    NAO_REPETIR("Nao Repetir"),
    FIXO("Fixo"),
    PARCELADO("Parcelado");

    EnumRepetirDespesas(String repeticao){
        this.repeticao = repeticao;
    }

    private String repeticao;

    public String getRepeticao(){
        return this.repeticao;
    }
}
