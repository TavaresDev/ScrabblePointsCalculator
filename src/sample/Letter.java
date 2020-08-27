package sample;

import javafx.scene.control.Label;

public class Letter {

    private int score, amount;
    private char letter;
    private Label id;

    public Letter(int score, char letter, int amount, Label id) {
        this.score = score;
        this.letter = letter;
        this.amount = amount;
        this.id = id;
    }

    public int getScore() {
        return score;
    }
    public char getLetter() { return letter; }
    public int getAmount() { return amount; }
    public Label getId() { return id; }

    public void removeFromBag() { this.amount -= 1; }


    @Override
    public String toString() {
        return "Letter{" +
                "score=" + score +
                ", amount=" + amount +
                ", letter=" + letter +
                ", id=" + id +
                '}';
    }
}
