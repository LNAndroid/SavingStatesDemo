package maulik.letsnurture.savingstatesdemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Fragment for showing current count
 */
public class TestFragment extends Fragment {

    private static final String EXTRA_COUNT = "extra_count";

    //local count variable for particular fragment
    private int mCount;
    private CountManager mCountManager;

    //interface for notifying count changes to activity when fragment is destroyed
    public interface CountManager {
        void onCountReduced();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof CountManager) {
            mCountManager = (CountManager) context;
        } else {
            throw new RuntimeException("Must implement");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //notify activity that fragment is destroyed so that activity can reduce its count variable
        mCountManager.onCountReduced();
    }

    public TestFragment() {
        // Required empty public constructor
    }


    /**
     * @param count specified when initializing fragment
     * @return fragment instance
     */
    public static TestFragment newInstance(int count) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_COUNT, count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //set local count variable
            mCount = getArguments().getInt(EXTRA_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_frament, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //show count specified in the argument of the fragment
        TextView tvCount = view.findViewById(R.id.tv_count);
        tvCount.setText(""+mCount);
    }
}
