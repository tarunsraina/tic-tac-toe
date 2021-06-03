package com.tarun.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int active=0;
    int[] position={2,2,2,2,2,2,2,2,2};
    int[][] winPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean activeGame=true;

    public void CapAmeClick(View view)
    {
        ImageView iv=(ImageView) view;
        iv.animate().alpha(1).setDuration(300);

        int tagPos=Integer.parseInt(iv.getTag().toString());

        if (position[tagPos]==2&&activeGame) {

            position[tagPos] = active;
            if (active == 0) {
                iv.setImageResource(R.drawable.captainamerica);
                active = 1;
            } else {
                iv.setImageResource(R.drawable.ironman);
                active = 0;
            }
            String winner = "";
            for (int[] winPosition : winPos) {
                if (position[winPosition[0]] == position[winPosition[1]] &&
                        position[winPosition[1]] == position[winPosition[2]] &&
                        position[winPosition[0]] != 2) {

                    activeGame=false;
                    if (active == 1) {
                        winner = "Winner is Captain America";
                        gamefinish(winner);
                    } else if(active==0){
                        winner = "           Winner is Ironman";
                        gamefinish(winner);
                    }

                    Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT).show();

                }
                else if(isTied())
                    {
                        winner="               Draw Match";
                        gamefinish(winner);
                    }

                }
            }
        }



    public void playAgain(View view)
    {
        Button btnPlayAgain=(Button) findViewById(R.id.btnPlayAgain);
        TextView result=(TextView) findViewById(R.id.textView);
        btnPlayAgain.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        GridLayout gl=(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<gl.getChildCount();i++)
        {
            ImageView iv1=(ImageView)gl.getChildAt(i);
            iv1.animate().alpha(0).setDuration(500);
            iv1.setImageDrawable(null);
        }

        for(int t=0;t<position.length;t++)
        {
            position[t]=2;
        }
        active=0;
        activeGame=true;
    }

    public void gamefinish(String winner)
    {
        Button btnPlayAgain=(Button) findViewById(R.id.btnPlayAgain);
        TextView result=(TextView) findViewById(R.id.textView);
        btnPlayAgain.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        result.setText(winner);
    }

    public boolean isTied()
    {
        for(int i=0;i<position.length;i++)
        {
            if(position[i]==2)
            {
                return false;
            }

        }
        return  true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText stopPort;
    }
}