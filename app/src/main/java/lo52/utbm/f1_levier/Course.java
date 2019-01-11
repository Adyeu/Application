package lo52.utbm.f1_levier;


import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Course extends AppCompatActivity implements OnClickListener {

    private Button startButton, stopButton;

    private Chronometer chrono;

    private TextView sprint1Value, fract1Value, pitStopValue, sprint2Value, fract2Value, moyToursValue, moySprintValue, moyFractValue;

    private int cpt = 1;

    private float sp1, sp2, fr1, fr2, pitStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_course);

        chrono = (Chronometer) findViewById(R.id.chronometer);

        startButton = (Button) findViewById(R.id.button_start);

        stopButton = (Button) findViewById(R.id.button_stop);

        sprint1Value = (TextView) findViewById(R.id.sprint1Value);

        fract1Value = (TextView) findViewById(R.id.fract1Value);

        sprint2Value = (TextView) findViewById(R.id.sprint2Value);

        fract2Value = (TextView) findViewById(R.id.fract2Value);

        pitStopValue = (TextView) findViewById(R.id.pitstopValue);

        fract1Value = (TextView) findViewById(R.id.fract1Value);

        sprint2Value = (TextView) findViewById(R.id.sprint2Value);

        fract2Value = (TextView) findViewById(R.id.fract2Value);

        pitStopValue = (TextView) findViewById(R.id.pitstopValue);

        moyToursValue = (TextView) findViewById(R.id.moyToursValue);
//
//        sprint2Value = (TextView) findViewById(R.id.sprint2Value);
//
//        fract2Value = (TextView) findViewById(R.id.fract2Value);
//
//        pitStopValue = (TextView) findViewById(R.id.pitstopValue);

        startButton.setOnClickListener(this);

        stopButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            default:

                break;

            case R.id.button_start:

                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                break;

            case R.id.button_stop:
                chrono.stop();
                if (cpt == 1) {
                    getSprint1();
                    cpt += 1;
                } else if (cpt == 2) {

                    getFrac1();
                    cpt += 1;
                } else if (cpt == 3) {

                    getPitStop();
                    cpt += 1;

                } else if (cpt == 4) {

                    getSprint2();
                    cpt += 1;

                } else if (cpt == 5) {
                    getFrac2();
                    cpt = 0;
                    moyenneTours();

                } else
                    break;

        }

    }

    public void moyenneTours(){

        float moyenne = (sp1+sp2+fr1+fr2)/4;

        moyToursValue.setText(String.valueOf(moyenne));

    }

    public void moyenneSprint(){

        float moyenne = (sp1+sp2)/2;


    }

//    public int getChronoValue(int value){
//
//
//
//        value =s;
//        return value;
//    }

    public void getSprint1() {

        long systemCurrTime = SystemClock.elapsedRealtime();

        long chronometerBaseTime = chrono.getBase();

        long deltaTime = systemCurrTime - chronometerBaseTime;

        int h = (int) (deltaTime / 3600000);
        int m = (int) (deltaTime - h * 3600000) / 60000;
        sp1 = (float) (deltaTime - (h * 3600000) - (m * 60000)) / 1000;

        sprint1Value.setText(String.valueOf(sp1));

        chrono.setBase(SystemClock.elapsedRealtime());

    }
    private void getFrac1() {

        long systemCurrTime = SystemClock.elapsedRealtime();

        long chronometerBaseTime = chrono.getBase();

        long deltaTime = systemCurrTime - chronometerBaseTime;

        int h = (int) (deltaTime / 3600000);
        int m = (int) (deltaTime - h * 3600000) / 60000;
        fr1 = (float) (deltaTime - (h * 3600000) - (m * 60000)) / 1000;

        fract1Value.setText(String.valueOf(fr1));

        chrono.setBase(SystemClock.elapsedRealtime());
    }


    private void getPitStop() {
        long systemCurrTime = SystemClock.elapsedRealtime();

        long chronometerBaseTime = chrono.getBase();

        long deltaTime = systemCurrTime - chronometerBaseTime;

        int h = (int) (deltaTime / 3600000);
        int m = (int) (deltaTime - h * 3600000) / 60000;
        pitStop = (float) (deltaTime - (h * 3600000) - (m * 60000)) / 1000;

        pitStopValue.setText(String.valueOf(pitStop));

        chrono.setBase(SystemClock.elapsedRealtime());
    }

    private void getSprint2() {

        long systemCurrTime = SystemClock.elapsedRealtime();

        long chronometerBaseTime = chrono.getBase();

        long deltaTime = systemCurrTime - chronometerBaseTime;

        int h = (int) (deltaTime / 3600000);
        int m = (int) (deltaTime - h * 3600000) / 60000;
        sp2 = (float) (deltaTime - (h * 3600000) - (m * 60000)) / 1000;

        sprint2Value.setText(String.valueOf(sp2));

        chrono.setBase(SystemClock.elapsedRealtime());
    }
    private void getFrac2() {

        long systemCurrTime = SystemClock.elapsedRealtime();

        long chronometerBaseTime = chrono.getBase();

        long deltaTime = systemCurrTime - chronometerBaseTime;

        int h = (int) (deltaTime / 3600000);
        int m = (int) (deltaTime - h * 3600000) / 60000;
        fr2 = (float) (deltaTime - (h * 3600000) - (m * 60000)) / 1000;

        fract2Value.setText(String.valueOf(fr2));
        chrono.setBase(SystemClock.elapsedRealtime());

    }






}
