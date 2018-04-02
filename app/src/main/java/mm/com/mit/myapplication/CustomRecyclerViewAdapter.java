package mm.com.mit.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MIT on 4/2/2018.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    private Context mContext;
    private List<MyData> mDataList;

    public CustomRecyclerViewAdapter(Context context, List<MyData> your_array_list) {
        this.mContext = context;
        this.mDataList = your_array_list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.my_data_item, parent, false);

        return new CustomViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.name)
        TextView mName;
            @BindView(R.id.icon)
        ImageView mIcon;

        public CustomViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);


        }

        private void bind(MyData myData) {
            mName.setText(myData.name);
            mIcon.setImageResource(myData.imgDrawable);
        }
    }
}
