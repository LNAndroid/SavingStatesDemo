package maulik.letsnurture.savingstatesdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class SaveStatesActivity extends AppCompatActivity implements TestFragment.CountManager {

    private int mCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestFragment testFragment = TestFragment.newInstance(mCount);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, testFragment)
                    .addToBackStack(null)
                    .commit();
            mCount++;
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCount = savedInstanceState.getInt("count");
    }

    public void onAddClicked(View view) {
        TestFragment testFragment = TestFragment.newInstance(mCount);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,testFragment)
                .addToBackStack(null)
                .commit();
        mCount++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",mCount);
    }

    @Override
    public void onCountReduced() {
        mCount--;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mCount==0) {
            finish();
        }
    }
}
