package mm.com.mit.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MIT on 3/26/2018.
 */

public class PeopleFragment extends Fragment {

        @BindView(R.id.recyclerview)
        RecyclerView recyclerView;


    public static Fragment newInstance() {
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.bind(this, rootView);

         GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridLayoutManager.setAutoMeasureEnabled(true);
        ApplicationAdapter adapter = new ApplicationAdapter(getContext(), listApplications(getContext()));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);


        return rootView;
    }

    public static List<ApplicationInfo> listApplications(Context context) {
        int flags = PackageManager.GET_META_DATA;
        List<ApplicationInfo> installedApps = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> applications = pm.getInstalledApplications(flags);
        for (ApplicationInfo appInfo : applications) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                installedApps.add(appInfo);
            }
        }
        return installedApps;
    }
}
