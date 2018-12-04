package com.example.android.euchrescorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.euchrescorecard.R;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int isGameOver = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreAVar", scoreTeamA);
        outState.putInt("scoreBVar", scoreTeamB);
        outState.putInt("isGameOver", isGameOver);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

    }

    // This callback is called only when there is a saved instance that is previously saved by using
    // onSaveInstanceState(). We restore some state in onCreate(), while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreAVar");
        scoreTeamB = savedInstanceState.getInt("scoreBVar");
        isGameOver = savedInstanceState.getInt("isGameOver");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        ImageView IV = findViewById(R.id.team_a_score_img);
        int j = getResources().getIdentifier("r_" + score, "drawable", getPackageName());
        IV.setImageResource(j);
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        if (score == 10) {
            Toast.makeText(getApplicationContext(), R.string.team_a_wins, Toast.LENGTH_SHORT).show();
            isGameOver = 1;
        }
    }

    /**
     * Increase the score for Team A by 4 points.
     */
    public void addFourForTeamA(View v) {
        if (isGameOver == 0) {
            scoreTeamA = Math.min(scoreTeamA + 4, 10);
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        if (isGameOver == 0) {
            scoreTeamA = Math.min(scoreTeamA + 2, 10);
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Increase the score for Team A by 1 points.
     */
    public void addOneForTeamA(View v) {
        if (isGameOver == 0) {
            scoreTeamA = Math.min(scoreTeamA + 1, 10);
            displayForTeamA(scoreTeamA);
        }
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        ImageView IV = findViewById(R.id.team_b_score_img);
        int j = getResources().getIdentifier("b_" + score, "drawable", getPackageName());
        IV.setImageResource(j);
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
        if (score == 10) {
            Toast.makeText(getApplicationContext(), R.string.team_b_wins, Toast.LENGTH_SHORT).show();
            isGameOver = 1;
        }
    }

    /**
     * Increase the score for Team B by 4 points.
     */
    public void addFourForTeamB(View v) {
        if (isGameOver == 0) {
            scoreTeamB = Math.min(scoreTeamB + 4, 10);
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        if (isGameOver == 0) {
            scoreTeamB = Math.min(scoreTeamB + 2, 10);
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        if (isGameOver == 0) {
            scoreTeamB = Math.min(scoreTeamB + 1, 10);
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Reset the scores to zero.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
        isGameOver = 0;
    }

}
