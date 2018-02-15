package maulik.letsnurture.savingstatesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Activity to show the behaviour of app when states are not saved using lifecycle methods
 */
public class NormalActivity extends AppCompatActivity implements TestFragment.CountManager {

    /*
       We will be manipulating value of this variable
       to understand the concept of saving states.
       We will increase the count value by one when adding a fragment
       We will decrease the count value by one when a fragment is destroyed by back press
   */
    private int mCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestFragment testFragment = TestFragment.newInstance(mCount);
        setContentView(R.layout.activity_demo);
        //code to initialize first fragment as soon as the activity is started for the first time
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, testFragment)
                    .addToBackStack(null)
                    .commit();
            //increase the count by one
            mCount++;
        }
    }

    //click event for ADD button
    public void onAddClicked(View view) {
        //use the current count to initialize the fragment
        TestFragment testFragment = TestFragment.newInstance(mCount);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, testFragment)
                .addToBackStack(null)
                .commit();
        //increase the count by one
        mCount++;
    }

    /**
     * implementation of method specified in the interface of the fragment
     * Used to decrease count value by one when the fragment is destroyed by backpress
     */
    @Override
    public void onCountReduced() {
        mCount--;
    }

    @Override
    public void onBackPressed() {
        //code to finish the activity in case of backpress when count is 0
        if ((mCount-1) == 0) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
