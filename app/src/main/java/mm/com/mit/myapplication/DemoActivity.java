package mm.com.mit.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mm.com.mit.myapplication.SlidingUpPanelLayout.PanelState;

public class DemoActivity extends AppCompatActivity {

    public static final String TAG = "DemoActivity";
    @BindView(R.id.sliding_layout)
    SlidingUpPanelLayout mSlidingUpPanelLayout;


    @BindView(R.id.more)
    ImageView mMore;
    @BindView(R.id.noti)
    ImageView mNoti;
    @BindView(R.id.people)
    ImageView mPeople;
    @BindView(R.id.news)
    ImageView mNews;

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    List<MyData> your_array_list;

    private CustomRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        navigateToNewsPage();
        if (savedInstanceState != null) {

            mSlidingUpPanelLayout.setPanelState(PanelState.ANCHORED);
        }

        mSlidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, PanelState previousState, PanelState newState) {
                Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });
        mSlidingUpPanelLayout.setTouchEnabled(false);

        setupRecyclerView();
    }

    private void navigateToNewsPage() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, NewsFeedFragment.newInstance()).commit();
    }

    private void navigateToNotiPage() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, NotiFragment.newInstance()).commit();
    }

    private void navigationToPeoplePage() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, PeopleFragment.newInstance()).commit();
    }

    private void setupRecyclerView() {

        MyData data1 = new MyData();
        data1.name = "Videos";
        data1.imgDrawable = R.drawable.ic_video_library_black_24dp;

        MyData data2 = new MyData();
        data2.name = "News";
        data2.imgDrawable = R.drawable.ic_newfeed_black_24;

        MyData data3 = new MyData();
        data3.name = "Contents";
        data3.imgDrawable = R.drawable.ic_content_copy_black_24dp;

        MyData data4 = new MyData();
        data4.name = "Q&A";
        data4.imgDrawable = R.drawable.ic_question_answer_black_24dp;

        MyData data5 = new MyData();
        data5.name = "Save ";
        data5.imgDrawable = R.drawable.ic_save_black_24dp;

        MyData data6 = new MyData();
        data6.name = "videos";
        data6.imgDrawable = R.drawable.ic_close_black_24dp;

        MyData data7 = new MyData();
        data7.name = "Contents";
        data7.imgDrawable = R.drawable.ic_content_copy_black_24dp;

        MyData data8 = new MyData();
        data8.name = "Q&A";
        data8.imgDrawable = R.drawable.ic_question_answer_black_24dp;

        MyData data9 = new MyData();
        data9.name = "Save ";
        data9.imgDrawable = R.drawable.ic_save_black_24dp;

        MyData data10 = new MyData();
        data10.name = "videos";
        data10.imgDrawable = R.drawable.ic_close_black_24dp;

        your_array_list = new ArrayList<>();
        your_array_list.add(data1);
        your_array_list.add(data2);
        your_array_list.add(data3);
        your_array_list.add(data4);
        your_array_list.add(data5);
        your_array_list.add(data6);
        your_array_list.add(data7);
        your_array_list.add(data8);
        your_array_list.add(data9);
        your_array_list.add(data10);

        mAdapter = new CustomRecyclerViewAdapter(this, your_array_list);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.more)
    public void onButtonMoreClick() {
        if (mSlidingUpPanelLayout.getPanelState() == PanelState.COLLAPSED) {
            mSlidingUpPanelLayout.setPanelState(PanelState.EXPANDED);
            mMore.setImageResource(R.drawable.ic_close_black_24dp);
        } else if (mSlidingUpPanelLayout.getPanelState() == PanelState.EXPANDED) {
            mSlidingUpPanelLayout.setPanelState(PanelState.COLLAPSED);
            mMore.setImageResource(R.drawable.ic_more_black_24dp);
        }
    }

    @OnClick(R.id.people)
    public void onButtonPeopleClick() {
        navigationToPeoplePage();
    }


    @OnClick(R.id.noti)
    public void onButtonNotiClick() {
        navigateToNotiPage();
    }


    @OnClick(R.id.news)
    public void onButtonNewsClick() {
        navigateToNewsPage();
    }

}
