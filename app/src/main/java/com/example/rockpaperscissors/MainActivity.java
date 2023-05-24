package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_paper, btn_scissors;
    TextView textScore;
    ImageView iv_ComputerChoice, iv_HumanChoice;
    int human_Score, com_Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rock = findViewById(R.id.rock_button);
        btn_paper = findViewById(R.id.paper_button);
        btn_scissors = findViewById(R.id.scissor_button);
        textScore = findViewById(R.id.tv_score);
        iv_ComputerChoice = findViewById(R.id.iv_computerChoice);
        iv_HumanChoice = findViewById(R.id.iv_humanChoice);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String msg = play_turn("rock");
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                textScore.setText("Score Human: " + Integer.toString(human_Score) + " Computer: " + Integer.toString(com_Score));
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String msg = play_turn("paper");
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                textScore.setText("Score Human: " + Integer.toString(human_Score) + " Computer: " + Integer.toString(com_Score));
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String msg = play_turn("scissors");
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                textScore.setText("Score Human: " + Integer.toString(human_Score) + " Computer: " + Integer.toString(com_Score));
            }
        });

    }

    private String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_num = r.nextInt(3);

        switch (computer_choice_num) {
            case 1:
                computer_choice = "rock";
                iv_ComputerChoice.setImageResource(R.drawable.rock);
                break;
            case 2:
                computer_choice = "paper";
                iv_ComputerChoice.setImageResource(R.drawable.paper);
                break;
            case 3:
                computer_choice = "scissors";
                iv_ComputerChoice.setImageResource(R.drawable.scissors);
                break;
            default:
                computer_choice = "paper";
                break;
        }

        if (computer_choice == player_choice) {
            return "Draw.   Nobody win.";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            human_Score++;
            return "Rock crushes scissors. You win!";
        } else if (player_choice == "rock" && computer_choice == "paper") {
            com_Score++;
            return "Paper covers rock. Computer wins!";
        } else if (player_choice == "scissors" && computer_choice == "rock") {
            com_Score++;
            return "Rock crushes scissors. Computer wins!";
        }  else if (player_choice == "scissors" && computer_choice == "paper") {
            human_Score++;
            return "Scissors cuts paper. You win!";
        }  else if (player_choice == "paper" && computer_choice == "rock") {
            human_Score++;
            return "Paper covers rock. You win!";
        }  else if (player_choice == "paper" && computer_choice == "scissors") {
            com_Score++;
            return "Scissors cuts paper. Computer wins!";
        } else {
            return "Not sure";
        }
    }
}