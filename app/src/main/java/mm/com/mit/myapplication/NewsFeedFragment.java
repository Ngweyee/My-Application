package mm.com.mit.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MIT on 3/26/2018.
 */

public class NewsFeedFragment extends Fragment {

    @BindView(R.id.rv_news_feed)
    RecyclerView rvNewsFeed;

    NewsFeedAdapter mAdapter;


    public static Fragment newInstance() {
        NewsFeedFragment fragment = new NewsFeedFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);
        ButterKnife.bind(this, rootView);
        rvNewsFeed.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new NewsFeedAdapter(getContext());
        rvNewsFeed.setAdapter(mAdapter);
        return rootView;
    }
}
