package lo52.utbm.f1_levier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class home extends AppCompatActivity implements View.OnClickListener {
    private CardView courseCard, scoreCard, teamCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        courseCard = (CardView) findViewById(R.id.course_card);
        scoreCard = (CardView) findViewById(R.id.score_card);
        teamCard = (CardView) findViewById(R.id.team_card);
        courseCard.setOnClickListener(this);
        scoreCard.setOnClickListener(this);
        teamCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.course_card:
                i = new Intent(this, Course.class);
                startActivity(i);
                break;
            case R.id.score_card:
                i = new Intent(this, Score.class);
                startActivity(i);
                break;
            case R.id.team_card:
                i = new Intent(this, Team.class);
                startActivity(i);
                break;
            default:
                break;

        }


    }
}
