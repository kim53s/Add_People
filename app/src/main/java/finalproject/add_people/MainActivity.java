package finalproject.add_people;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    //5000 seconds
    private static final int MAX_TIME = 5000000;

    private Button mProspectButton;
    private Button mAbbeyButton;
    private Button mHamButton;
    private Button mMacButton;
    private Button mWilderButton;
    private Button mRockyButton;

    private DiningHall mProspect;
    private DiningHall mAbbey;
    private DiningHall mWilder;
    private DiningHall mRocky;
    private DiningHall mHam;
    private DiningHall mMac;

    private DiningHall[] mDininghalls;
    private DatabaseReference mDatabase;

    private CountDownTimer mTimer;
    protected int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTimer();

        mProspect = new DiningHall("Prospect", 90);
        mAbbey = new DiningHall("Abbey", 90);
        mWilder = new DiningHall("Wilder", 90);
        mRocky = new DiningHall("Rocky", 90);
        mHam = new DiningHall("Ham", 90);
        mMac = new DiningHall("Mac", 90);

        mDininghalls = new DiningHall[]{mProspect, mAbbey, mWilder, mRocky, mHam, mMac};

        mProspectButton = (Button) findViewById(R.id.prospect);
        mAbbeyButton = (Button) findViewById(R.id.abbey);
        mHamButton = (Button) findViewById(R.id.ham);
        mMacButton = (Button) findViewById(R.id.mac);
        mWilderButton = (Button) findViewById(R.id.wilder);
        mRockyButton = (Button) findViewById(R.id.rocky);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mProspectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(time, 10);
                mProspect.add(s);
            }
        });

        mAbbeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student s = new Student(time, 10);
                mAbbey.add(s);
            }
        });


        mHamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(time, 10);
                mHam.add(s);

            }
        });

        mMacButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(time, 10);
                mMac.add(s);

            }
        });

        mRockyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(time, 10);
                mRocky.add(s);

            }
        });

        mWilderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student s = new Student(time, 10);
                mWilder.add(s);

            }
        });
    }

    private void setupTimer()
    {
        mTimer = new CountDownTimer(MAX_TIME, 1000) {

            public void onTick(long millisUntilFinished) {
                time++;
                for(int i = 0; i < mDininghalls.length; i++) {
                    if (!mDininghalls[i].isEmpty() && (time - mDininghalls[i].getFirst().getArrivalTime()) == mDininghalls[i].getFirst().getTime()) {
                        mDininghalls[i].delete();
                    }
                    updatePopulation();
                }
            }
            public void onFinish() {
            }
        }.start();
    }

    public void updatePopulation(){
        for(int i = 0; i < mDininghalls.length; i++ )
            mDatabase.child(mDininghalls[i].getName()).setValue(mDininghalls[i].getppl());
    }
}

