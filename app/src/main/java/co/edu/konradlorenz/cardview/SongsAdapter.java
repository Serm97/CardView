package co.edu.konradlorenz.cardview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.myItemHolder> {

    private Context sContext;
    private List<String> listSongs;

    public class myItemHolder extends RecyclerView.ViewHolder {

        public TextView nameSong, duration;
        private View view;


        public myItemHolder(View itemView) {
            super(itemView);
            nameSong = itemView.findViewById(R.id.nameSong);
            view = itemView;
        }
    }

    public SongsAdapter(Context sContext) {
        this.sContext = sContext;
        this.listSongs = createList();
    }

    public List<String> createList(){
        List<String> listCreated = new ArrayList<String>();

        for (int i=0; i<=10; i++){
            listCreated.add("Canción " + i + " del album --- 0"+i+":0"+i);
        }
        return listCreated;
    }

    @Override
    public myItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.song, parent, false);
        return new myItemHolder(item);
    }



    @Override
    public void onBindViewHolder(myItemHolder holder, int position) {
        holder.nameSong.setText(listSongs.get(position));
    }

    @Override
    public int getItemCount() {
        return listSongs.size();
    }
}
