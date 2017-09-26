package fr.octo.connect4;

public enum Token {
    Y("X"),
    R("O");

    private final String value;
    Token(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
