package maulik.letsnurture.savingstatesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NormalActivity extends AppCompatActivity implements TestFragment.CountManager {

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
