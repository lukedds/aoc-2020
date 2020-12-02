package day2;

public class Password {

    private String password;
    private String letter;
    private Integer digit1;
    private Integer digit2;

    public Password(final String inputValue) {
        this.password = inputValue.split(" ")[2];
        this.letter = inputValue.split(" ")[1].split(":")[0];
        this.digit1 = Integer.parseInt(inputValue.split(" ")[0].split("-")[0]);
        this.digit2 = Integer.parseInt(inputValue.split(" ")[0].split("-")[1]);
    }

    public String getPassword() {
        return password;
    }

    public String getLetter() {
        return letter;
    }

    public Integer getDigit1() {
        return digit1;
    }

    public Integer getDigit2() {
        return digit2;
    }
}
