package studio.angzai.tugasutsgenap2022_akb_if_3_10119123;
//Nama : ANGGA CAHYA ABADI
//NIM : 10119123
//Kelas : IF-3

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IAdapter extends RecyclerView.Adapter<IAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Note> notes;

    IAdapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public IAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_view,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IAdapter.ViewHolder viewHolder, int position) {
        String title = notes.get(position).getTitle();
        String category = notes.get(position).getCategory();
        String date = notes.get(position).getDate();
        String time = notes.get(position).getTime();
        viewHolder.nTitle.setText(title);
        viewHolder.nCategory.setText(category);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nCategory, nDate, nTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nTitle =itemView.findViewById(R.id.nTitle);
            nCategory = itemView.findViewById(R.id.nCategory);
            nDate = itemView.findViewById(R.id.nDate);
            nTime = itemView.findViewById(R.id.nTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                    intent.putExtra("ID",notes.get(getAdapterPosition()).getID());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
