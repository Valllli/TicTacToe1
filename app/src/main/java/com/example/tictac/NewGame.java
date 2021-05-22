package com.example.tictac;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewGame extends AppCompatActivity {
    private static final String ANS = "answers";
    private ArrayList<Integer> answers = new ArrayList<>();
    private boolean isCross = true;
    private int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private int a, b, c = 0;
    private boolean isGameFinished = false;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_new_game);
        Log.d(NewGame.class.getName(), "onCreate");
        load(state);
    }

    public void answer(View view) {
        if (!isGameFinished) {
            Button button = (Button) view;
            int id = button.getId();
            if (!answers.contains(id)) {
                if (isCross) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                answers.add(view.getId());
                switch (id) {
                    case 2131230815:
                        map[0][0] = isCross ? 1 : 2;
                        break;
                    case 2131230816:
                        map[0][1] = isCross ? 1 : 2;
                        break;
                    case 2131230817:
                        map[0][2] = isCross ? 1 : 2;
                        break;
                    case 2131230808:
                        map[1][0] = isCross ? 1 : 2;
                        break;
                    case 2131230809:
                        map[1][1] = isCross ? 1 : 2;
                        break;
                    case 2131230810:
                        map[1][2] = isCross ? 1 : 2;
                        break;
                    case 2131230811:
                        map[2][0] = isCross ? 1 : 2;
                        break;
                    case 2131230812:
                        map[2][1] = isCross ? 1 : 2;
                        break;
                    case 2131230814:
                        map[2][2] = isCross ? 1 : 2;
                        break;
                }
                if (checkWinner()) {
                    Toast toast = Toast.makeText(getApplicationContext(), isCross ? "Победил X" : "Победил 0", Toast.LENGTH_LONG);
                    toast.show();
                    finishGame();
                }
                if (ckeckDraw()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "НИЧЬЯ", Toast.LENGTH_LONG);
                    toast.show();
                    finishGame();
                }
                isCross = !isCross;
            }
        }
    }

    private void finishGame() {
        isGameFinished = true;
//        delay(3);
//        startActivity(new Intent("com.example.tictac.MainActivity"));
    }

    // Метод проверки ппобедителя
    private boolean checkWinner() {
        // Проверка всех вертикалей
        for (int j = 0; j < map[0].length; j++) {
            int[] vertical = new int[map.length];
            for (int i = 0; i < map.length; i++) {
                vertical[i] = map[i][j];
            }
            if (isLine(vertical)) return true;
        }
        // Проверка всех горизонталей
        for (int i = 0; i < map.length; i++) {
            if (isLine(map[i])) return true;
        }
        // Проверка диагоналей
        int[] diag1 = new int[map.length];
        int[] diag2 = new int[map.length];
        for (int i = 0; i < map.length; i++) {
            diag1[i] = map[i][i];
            diag2[i] = map[i][map.length-i-1];
        }
        if (isLine(diag1) || isLine(diag2)) return true;
        return false;
    }

    // Метод проверки на ничью
    private boolean ckeckDraw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    // Стоят ли в одной линии все крестики или нолики
    private boolean isLine(int[] line) {
        int currentElement = line[0];
        if (currentElement != 0) {
            for (int i = 1; i < map.length; i++) {
                if (line[i] != currentElement) return false;
                currentElement = line[i];
            }
            return true;
        }
        else return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        Log.d(NewGame.class.getName(),"onSaveInstanceState");
        state.putIntegerArrayList("ANS", answers);
    }

    private void load(Bundle state){
        if (state != null){
            for (Integer id : state.getIntegerArrayList(ANS)){
                Button btn = findViewById(id);
                btn.setText("X");
                answers.add(btn.getId());
            }
        }
    }

    void delay(int Seconds) {
        long Time = 0;
        Time = System.currentTimeMillis();
        while (System.currentTimeMillis() < Time + (Seconds * 1000)) ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(NewGame.class.getName(), "onResume");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(NewGame.class.getName(), "onStart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(NewGame.class.getName(), "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(NewGame.class.getName(), "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(NewGame.class.getName(), "onDestroy");
    }





}