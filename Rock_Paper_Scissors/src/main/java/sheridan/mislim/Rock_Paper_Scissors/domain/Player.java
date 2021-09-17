package sheridan.mislim.Rock_Paper_Scissors.domain;

import java.io.Serializable;

public class Player implements Serializable {

    private final static String[] FACES = {"paper", "rock", "scissors"};

    private int choice = 0;
    private boolean winner =true;

    public Player(){
        int rand = (int) (3* Math.random());
        setChoice(rand);
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    @Override
    public String toString() {
        return FACES[choice];
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
