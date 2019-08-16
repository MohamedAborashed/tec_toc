package com.example.tec_toc;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView tvPlayer;

    int player = 1;

    int buttonStates[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        addListenersToButtons();
        buttonStates = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};


    }


    private void addListenersToButtons() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }


    private void initViews() {

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        tvPlayer = (TextView) findViewById(R.id.tvPlayer);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btn1:

                checkWinner(0, v);

                break;

            case R.id.btn2:
                checkWinner(1, v);
                break;

            case R.id.btn3:
                checkWinner(2, v);
                break;

            case R.id.btn4:
                checkWinner(3, v);
                break;

            case R.id.btn5:
                checkWinner(4, v);
                break;

            case R.id.btn6:
                checkWinner(5, v);
                break;

            case R.id.btn7:
                checkWinner(6, v);
                break;

            case R.id.btn8:
                checkWinner(7, v);
                break;

            case R.id.btn9:
                checkWinner(8, v);
                break;

        }


    }

    private void checkWinner(int i, View v) {

        changeText(v, i);

        if (buttonStates[i] == 0) {
            buttonStates[i] = player;

        }
        if (buttonStates[0] == player && buttonStates[1] == player && buttonStates[2] == player
                || buttonStates[0] == player && buttonStates[3] == player && buttonStates[6] == player
                || buttonStates[0] == player && buttonStates[4] == player && buttonStates[8] == player
                || buttonStates[2] == player && buttonStates[5] == player && buttonStates[8] == player
                || buttonStates[6] == player && buttonStates[7] == player && buttonStates[8] == player
                || buttonStates[1] == player && buttonStates[4] == player && buttonStates[7] == player
                || buttonStates[3] == player && buttonStates[4] == player && buttonStates[5] == player
                || buttonStates[2] == player && buttonStates[4] == player && buttonStates[6] == player) {

            showAlertDialog();

        }



    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You win")
                .setMessage("do you to replay ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }


    private void changeText(View v, int i) {
        Button selectedButton = (Button) v;

        if (buttonStates[i] == 0) {
            if (player == 1) {
                selectedButton.setBackgroundResource(R.drawable.choicex);
                player = 2;
            } else if (player == 2) {
                selectedButton.setBackgroundResource(R.drawable.choiceo);
                player = 1;
            }

            tvPlayer.setText("Player : " + player);
        }

    }


}

