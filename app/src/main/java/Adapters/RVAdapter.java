package Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.utsavstha.futsalbook.R;

import java.util.List;

import Utils.InformationData;

/**
 * Created by utsav on 8/24/2015.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.DataViewHolder> {
        List<InformationData> data;

    public RVAdapter(List<InformationData> data) {
        this.data = data;
        }

public static class DataViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView futsalName;
    TextView futsalAddress;
    TextView timeDuration;
    RatingBar futsalRating;
    ImageView imageView;
    DataViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        futsalName = (TextView)itemView.findViewById(R.id.futsal_name);
        futsalAddress = (TextView)itemView.findViewById(R.id.futsal_address);
        futsalRating = (RatingBar)itemView.findViewById(R.id.futsal_rating);
        futsalRating.setIsIndicator(true);
        imageView = (ImageView)itemView.findViewById(R.id.futsal_main_image);
    }
}

    @Override
    public RVAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        DataViewHolder pvh = new DataViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.DataViewHolder holder, int position) {
        /*holder.subject_name.setText(data.get(position).subjectName);
        holder.teachersName.setText(data.get(position).teachersName);
        holder.timeDuration.setText(data.get(position).timeDuration);*/
        holder.futsalName.setText(data.get(position).getFutsalName());
        holder.futsalAddress.setText(data.get(position).getFutsalAddress());
        holder.futsalRating.setNumStars(data.get(position).getRating() + 1);
        holder.imageView.setImageResource(R.drawable.images);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
