public class Quintuple {

    private char pos0, pos1, pos2, pos3, pos4;

    public Quintuple(char pos0, char pos1, char pos2, char pos3, char pos4) {
        this.pos0 = pos0;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
    }

    public char get0() {
        return this.pos0;
    }

    public char get1() {
        return this.pos1;
    }

    public char get2() {
        return this.pos2;
    }

    public char get3() {
        return this.pos3;
    }

    public char get4() {
        return this.pos4;
    }

    public void set0(char a) {
        this.pos0 = a;
    }

    public void set1(char a) {
        this.pos1 = a;
    }

    public void set2(char a) {
        this.pos2 = a;
    }

    public void set3(char a) {
        this.pos3 = a;
    }

    public void set4(char a) {
        this.pos4 = a;
    }

    public StringBuilder printSequence() {
        StringBuilder str = new StringBuilder();

        str.append(get0()).append(get1()).append(get2()).append(get3()).append(get4());

        return str;
    }
}