package mm.com.mit.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MIT on 3/26/2018.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder> {

    private Context context;




    public NewsFeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public NewsFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_feed_item, parent, false);
        return new NewsFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsFeedViewHolder holder, int position) {
      //  holder.bind()\
        holder.mProfileImage.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_person_black_24dp));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profileImage)
        CircularImageView mProfileImage;

        public NewsFeedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
