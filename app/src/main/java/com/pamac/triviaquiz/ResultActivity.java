package com.pamac.triviaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btPlayAgain,btPlayScreen;
    TextView txtTotalQuesion,txtCoins,txtWrongQues,txtCorrectQues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btPlayAgain = findViewById(R.id.bt_PlayAgainR);
        btPlayScreen = findViewById(R.id.bt_PlayScreenR);

        txtCoins = findViewById(R.id.txtCoinsR);
        txtCorrectQues = findViewById(R.id.txtCorrectR);
        txtWrongQues = findViewById(R.id.txtWrongR);
        txtTotalQuesion = findViewById(R.id.txtTotalQuestionsR);



        Intent intent = getIntent();

        int totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0);
        int coins = intent.getIntExtra(Constants.COINS,0);
        int correct = intent.getIntExtra(Constants.CORRECT,0);
        int wrong = intent.getIntExtra(Constants.WRONG,0);


        txtTotalQuesion.setText(Constants.TOTAL_QUESTIONS + String.valueOf(totalQuestions));
        txtCoins.setText(Constants.COINS + String.valueOf(coins));
        txtCorrectQues.setText(Constants.CORRECT + String.valueOf(correct));
        txtWrongQues.setText(Constants.WRONG + String.valueOf(wrong));

        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,QuizActivity.class));
            }
        });

        btPlayScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, PlayScreen.class));
            }
        });
    }
}