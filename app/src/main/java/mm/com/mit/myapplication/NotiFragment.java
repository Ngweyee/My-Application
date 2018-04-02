package mm.com.mit.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by MIT on 3/26/2018.
 */

public class NotiFragment extends Fragment {



    public static Fragment newInstance() {
        NotiFragment fragment = new NotiFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_noti, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
