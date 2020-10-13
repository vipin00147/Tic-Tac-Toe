package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PlayWithPc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_with_pc);
        getSupportActionBar().hide();
    }
    /*Player Description
        0-O
        1-x
     */
    int  player = 0;
    boolean flag = true;
    int duce = 0;
    int []tapPosition = {2, 2, 2, 2, 2, 2, 2, 2, 2};        // 2 means current position is empty, used is allowed to tao here
    int [][]winPositions = {{0,1,2},{3,4,5},{6,7,8},       // these are the winning positions of player
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    TextView txt;
    @SuppressLint("ResourceAsColor")
    public void tap(View view){
        ImageView img = (ImageView) view;
        txt = findViewById(R.id.status);
        txt.setTextColor(Color.BLACK);
        int position = Integer.parseInt(img.getTag().toString());
        if (tapPosition[position] == 2 && flag) {                      //To check tapped position is empty or not
            img.setTranslationY(-1000f);
            if(player == 0) {
                img.setImageResource(R.drawable.o);
                tapPosition[position] = player;
                player = 1;
                duce++;
                txt.setText("X's turn - Tap to play");
                txt.setTextColor(Color.parseColor("#000000"));

                for(int [] winPositions : winPositions){
                    if(tapPosition[winPositions[0]] == tapPosition[winPositions[1]] &&
                            tapPosition[winPositions[1]] == tapPosition[winPositions[2]] &&
                            tapPosition[winPositions[0]] != 2){
                        if(tapPosition[winPositions[0]] == 0){
                            txt.setText("O has WON");
                            txt.setTextColor(Color.RED);
                            player = 0;
                            flag = false;
                        }
                        else if(tapPosition[winPositions[0]]==1){
                            txt.setText("X has WON");
                            txt.setTextColor(Color.RED);
                            player = 1;
                            flag = false;
                        }
                        else{
                            txt.setText("Play Again");
                            flag = false;
                        }
                    }
                }
            }
            img.animate().translationYBy(1000f).setDuration(200);
        }

        if(player == 1) {
            new CountDownTimer(500,1000) {
                public void onTick(long millisUntilFinished){}
                public  void onFinish(){
                    Random randon = new Random();
                    for(int i = 9 ; i > 0 ; i-- ) {
                        int number = randon.nextInt(i);
                        if(tapPosition[number] == 2 && flag) {
                            if(number == 0){
                                    ((ImageView)findViewById(R.id.imageView0)).setImageResource(R.drawable.x);
                            }
                            else if(number == 1){
                                    ((ImageView)findViewById(R.id.imageView1)).setImageResource(R.drawable.x);
                            }
                            else if(number == 2){
                                    ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.x);
                            }
                            else if(number == 3) {
                                    ((ImageView) findViewById(R.id.imageView3)).setImageResource(R.drawable.x);
                            }
                            else if(number == 4){
                                    ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.x);
                            }
                            else if(number == 5){
                                    ((ImageView)findViewById(R.id.imageView5)).setImageResource(R.drawable.x);
                            }
                            else if(number == 6){
                                    ((ImageView)findViewById(R.id.imageView6)).setImageResource(R.drawable.x);
                            }
                            else if(number == 7){
                                    ((ImageView)findViewById(R.id.imageView7)).setImageResource(R.drawable.x);
                            }
                            else if(number == 8){
                                    ((ImageView)findViewById(R.id.imageView8)).setImageResource(R.drawable.x);
                            }
                            tapPosition[number] = player;
                            player = 0;
                            duce++;
                            txt.setText("O's turn - Tap to play");
                            txt.setTextColor(Color.parseColor("#F44336"));
                            break;
                        }
                        else
                            i = 10;
                    }
                    for(int [] winPositions : winPositions){
                        if(tapPosition[winPositions[0]] == tapPosition[winPositions[1]] &&
                                tapPosition[winPositions[1]] == tapPosition[winPositions[2]] &&
                                tapPosition[winPositions[0]] != 2){
                            if(tapPosition[winPositions[0]] == 0){
                                txt.setText("O has WON");
                                txt.setTextColor(Color.RED);
                                //flag = false;
                                gameReset();
                                player = 0;
                            }
                            else if(tapPosition[winPositions[0]]==1){
                                txt.setText("X has WON (Tap to play)");
                                txt.setTextColor(Color.RED);
                                //flag = false;
                                gameReset();
                                player = 1;
                            }
                            else{
                                txt.setText("Play Again");
                                flag = false;
                            }
                        }
                    }
                }
            }.start();
        }

        if(flag == false || duce>=9){
            gameReset();
        }
    }
    public void gameReset() {
        for(int i=0;i<tapPosition.length;i++){
            tapPosition[i]=2;
        }
        flag = true;
        duce = 0;

        if(player == 0)
            player = 0;
        else
            player = 1;

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
}