package com.gallale.notes.adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallale.notes.R;
import com.gallale.notes.models.Note;


import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {

    private static final String TAG = "NotesRecyclerAdapter";

    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener mOnNoteListener;

    public NotesRecyclerAdapter(ArrayList<Note> mNotes, OnNoteListener onNoteListener) {
        this.mNotes = mNotes;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item, parent, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try{
            holder.timestamp.setText("");
            holder.title.setText("");

            // Met une image / adapte le titre pour chaque cartes
            if(mNotes.get(position).getNote().equals("DIVISION TECHNIQUE")){
                holder.image.setImageResource(R.drawable.ic_divtec_banniere);
            }else if (mNotes.get(position).getNote().equals("DIVISION LYCÉENNE")){
                holder.image.setImageResource(R.drawable.ic_divlyc_banniere);
            }else if(mNotes.get(position).getNote().equals("DIVISION COMMERCIALE")){
                holder.image.setImageResource(R.drawable.ic_divcom_banniere);
            }else if(mNotes.get(position).getNote().equals("divtec_informaticien_cfc")){
                holder.title.setText("Informaticien-ne CFC");
            }else {
                holder.title.setText(mNotes.get(position).getNote());
            }

        }catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage() );
        }
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView timestamp, title;
        ImageView image;
        OnNoteListener mOnNoteListener;

        public ViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            timestamp = itemView.findViewById(R.id.note_timestamp);
            title = itemView.findViewById(R.id.note_title);
            image = itemView.findViewById(R.id.note_img);
            mOnNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
















