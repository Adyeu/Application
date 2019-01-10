package lo52.utbm.f1_levier;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Course extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_course);

        final Chronometer chrono = (Chronometer) findViewById(R.id.chronometer);

        Button startButton = (Button) findViewById(R.id.button_start);

        Button stopButton = (Button) findViewById(R.id.button_stop);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.button_start:
                        chrono.start();

                }

            }

        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.button_stop:
                        chrono.stop();

                }

            }

        });

//        chrono.start();

    }

}
