package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {

    @FXML
    private TextField newWord;
    @FXML
    private TextArea prevWords;
    @FXML
    private Label error, pointTotal;

    @FXML
    private Label aQuantity, bQuantity ,cQuantity, dQuantity, eQuantity, fQuantity, gQuantity, hQuantity, iQuantity, jQuantity, kQuantity, lQuantity, mQuantity, nQuantity, oQuantity, pQuantity, qQuantity,rQuantity, sQuantity, tQuantity, uQuantity, vQuantity, wQuantity, xQuantity, yQuantity, zQuantity ;

    private int sumPoints = 0;
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<Letter> letters = new ArrayList<>();


    public Controller() {
    }

    @FXML
    private void initialize(){
        System.out.println("App started");

        setLetters();
        System.out.println(letters);

    }
    @FXML
    public void onEnter(ActionEvent ae){
        submit(ae);

    }

    @FXML
    private void submit(ActionEvent event){
        String word = newWord.getText().toLowerCase();
        try{
            if (!word.isEmpty() && !word.contains(" ") && word.length() >= 2 && word.length() <= 8){
                error.setText("");
                newWord.setText("");
                sumPoints += getWordScore(word);
                words.add(word);
                pointTotal.setText(String.valueOf(sumPoints));
                //prev word
                String oldWords = words.toString();
                oldWords = oldWords.substring(1, oldWords.length() - 1);
                prevWords.setText(oldWords);

                newWord.setText("");
                //update used letters
                updateLetters();


            }else {
                throw new IllegalArgumentException("Invalid Word!");

            }
        }catch(Exception e){
            error.setText(e.getMessage());
            System.out.println(e.getMessage());

        }

    }



    private void setLetters() {

        letters.add(new Letter(1, 'a', 9,aQuantity));
        letters.add(new Letter(3, 'b', 2, bQuantity));
        letters.add(new Letter(3, 'c', 2, cQuantity));
        letters.add(new Letter(2, 'd', 4, dQuantity));
        letters.add(new Letter(1, 'e', 12, eQuantity));
        letters.add(new Letter(4, 'f', 2, fQuantity));
        letters.add(new Letter(2, 'g', 3 , gQuantity));
        letters.add(new Letter(4, 'h', 2, hQuantity));
        letters.add(new Letter(1, 'i', 8, iQuantity));
        letters.add(new Letter(8, 'j', 1, jQuantity));
        letters.add(new Letter(5, 'k', 1, kQuantity));
        letters.add(new Letter(1, 'l', 4, lQuantity));
        letters.add(new Letter(3, 'm', 2, mQuantity));
        letters.add(new Letter(1, 'n', 6, nQuantity));
        letters.add(new Letter(1, 'o', 8, oQuantity));
        letters.add(new Letter(3, 'p', 2, pQuantity));
        letters.add(new Letter(10, 'q', 1, qQuantity));
        letters.add(new Letter(1, 'r', 6, rQuantity));
        letters.add(new Letter(1, 's', 4, sQuantity));
        letters.add(new Letter(1, 't', 6, tQuantity));
        letters.add(new Letter(1, 'u', 4, uQuantity));
        letters.add(new Letter(4, 'v', 2, vQuantity));
        letters.add(new Letter(4, 'w', 2, wQuantity));
        letters.add(new Letter(8, 'x', 1, xQuantity));
        letters.add(new Letter(4, 'y', 2, yQuantity));
        letters.add(new Letter(10, 'z', 1, zQuantity));

    }

    private void updateLetters(){
        for (Letter letterItem : letters){
            String sAmount = String.valueOf(letterItem.getAmount());
            letterItem.getId().setText(sAmount);

        }

    }

    private int getWordScore(String word) {
        int finalScore = 0;
        for (char letter : word.toCharArray()) {
            finalScore += getLetterScore(letter);
        }
        return finalScore;
    }

    private int getLetterScore(char letter){
        for (Letter letterItem : letters){
            if (letterItem.getLetter() == letter){
                if (letterItem.getAmount() != 0){
                    letterItem.removeFromBag();
                    return letterItem.getScore();
                }else{
                    throw new IllegalArgumentException("'" + letter + "' is not available");
                }
            }
        }

        throw new IllegalArgumentException("'" + letter + "' is not a valid scrabble letter");
    }



}
