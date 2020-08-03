package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    TextView  txt;
    public void tap(View view){
        ImageView img = (ImageView) view;
        txt = findViewById(R.id.status);
        txt.setTextColor(Color.BLACK);
        int position = Integer.parseInt(img.getTag().toString());
            if (tapPosition[position] == 2 && flag) {                      //To check tapped position is empty or not
               // img.setTranslationY(-1000f);
                if (player == 0) {
                    img.setImageResource(R.drawable.o);
                    tapPosition[position] = player;
                    player = 1;
                    duce++;
                    txt.setText("X's turn - Tap to play");
                }
                else {
                    img.setImageResource(R.drawable.x);
                    tapPosition[position] = player;
                    player = 0;
                    duce++;
                    txt.setText("O's turn - Tap to play");
                }
                //img.animate().translationYBy(1000f).setDuration(300);
            }
        for(int [] winPositions : winPositions){
            if(tapPosition[winPositions[0]] == tapPosition[winPositions[1]] &&
                    tapPosition[winPositions[1]] == tapPosition[winPositions[2]] &&
                    tapPosition[winPositions[0]] != 2){
                if(tapPosition[winPositions[0]] == 0){
                    txt.setText("O has WON");
                    txt.setTextColor(Color.RED);
                    flag = false;
                }
                else if(tapPosition[winPositions[0]]==1){
                    txt.setText("X has WON");
                    txt.setTextColor(Color.RED);
                    flag = false;
                }
                else{
                    txt.setText("Play Again");
                    flag = false;
                }
            }
        }
        if(!flag || duce>=9){
            gameReset();
        }
    }
    public void gameReset() {
        for(int i=0;i<tapPosition.length;i++){
            tapPosition[i]=2;
        }
        flag = true;
        duce = 0;
        player = 0;
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