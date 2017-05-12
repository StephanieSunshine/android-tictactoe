package org.seattlecentral.android.dev.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static org.seattlecentral.android.dev.tictactoe.R.id.button1;
import static org.seattlecentral.android.dev.tictactoe.R.id.button2;
import static org.seattlecentral.android.dev.tictactoe.R.id.button3;
import static org.seattlecentral.android.dev.tictactoe.R.id.button4;
import static org.seattlecentral.android.dev.tictactoe.R.id.button5;
import static org.seattlecentral.android.dev.tictactoe.R.id.button6;
import static org.seattlecentral.android.dev.tictactoe.R.id.button7;
import static org.seattlecentral.android.dev.tictactoe.R.id.button8;
import static org.seattlecentral.android.dev.tictactoe.R.id.button9;

public class MainActivity extends AppCompatActivity  {
    // Player X, O
    enum Player { X, O }
    Player[] players = new Player[] {Player.X, Player.O};


    // None, X, O, Tie
    enum Winner { N, X, O, T }

    Player currentPlayer = Player.X;
    Boolean gameOver = Boolean.FALSE;
    Winner winner = Winner.N;

    Button gameGrid[][] = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameGrid[0][0] = (Button) findViewById(button1);
        gameGrid[1][0] = (Button) findViewById(button2);
        gameGrid[2][0] = (Button) findViewById(button3);
        gameGrid[0][1] = (Button) findViewById(button4);
        gameGrid[1][1] = (Button) findViewById(button5);
        gameGrid[2][1] = (Button) findViewById(button6);
        gameGrid[0][2] = (Button) findViewById(button7);
        gameGrid[1][2] = (Button) findViewById(button8);
        gameGrid[2][2] = (Button) findViewById(button9);
    }

    public void endGame(Player w) {
        if(w == Player.X) {
            winner = Winner.X;
            gameOver = true;
        }
        if(w == Player.O) {
            winner = Winner.O;
            gameOver = true;
        }
    }

    // Test Board Location
    public boolean t(int x, int y, Player player) {
        Button piece = gameGrid[x][y];
        if(piece.getTag() == player) {
            return(true);
        }else{
            return(false);
        }
    }

    public void updateStatus() {

    }

    public void testForTie() {

    }

    public boolean testForWinner() {
        for(Player cp : players) {
            if(t(0,0,cp) && t(1,0,cp) && t(2,0,cp)) {
                endGame(cp);
                return(true);
            }
        }
        return(false);
    }

    public void buttonOnClick(View v) {

        // Is the game still running?
        if(winner == Winner.N){

            Button button=(Button) v;

            // Is the button blank?
            if(button.getText() == "") {
                switch(currentPlayer) {
                    case X:
                        button.setText("X");
                        button.setTag(Player.X);
                        currentPlayer = Player.O;
                    break;
                    case O:
                        button.setText("O");
                        button.setTag(Player.O);
                        currentPlayer = Player.X;
                    break;
                }
                testForWinner();
                testForTie();
                updateStatus();
            }
        }
    }


    public void buttonNewGameOnClick(View v) {

    }

}
