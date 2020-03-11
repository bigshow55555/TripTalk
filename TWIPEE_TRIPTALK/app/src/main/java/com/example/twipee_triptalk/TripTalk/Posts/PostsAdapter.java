package com.example.twipee_triptalk.TripTalk.Posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalk.Posts.Posts_Model.DataModelBoard;

import java.util.List;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>{

    private List<DataModelBoard> mdata;
    private static View.OnClickListener onClickListener;


    public  static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        public ImageView ImageView_title;
        public  View rootView;


        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.posts_title);
            textView2 = itemView.findViewById(R.id.posts_contents);
            ImageView_title =itemView.findViewById(R.id.ImageView_title);
            ImageView_title.setImageResource(R.drawable.siru);
            rootView = itemView;

            itemView.setClickable(true); //누를 수있다없다
            itemView.setEnabled(true); // 활성화 상태
            itemView.setOnClickListener(onClickListener);

         }
    }

    public PostsAdapter(List<DataModelBoard> myData, Context context, View.OnClickListener onClick)
    {
        mdata= myData;
        onClickListener = onClick;
    }

    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        //Context context = parent.getContext();
       // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item, parent,false);
        //View view = inflater.inflate(R.layout.posts_item ,parent, false);
        PostsAdapter.ViewHolder vh = new PostsAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DataModelBoard models = mdata.get(position);

        holder.textView1.setText(models.getUser_id());

        String Title_text = models.getBoard_type();

        if(Title_text != "null")
        {
            holder.textView2.setText(Title_text);
        }
        else {
            holder.textView2.setText("정보가 없음");
        }

        //holder.textView2.setText(models.getLocation());
        //holder.ImageView_title.setText(String.valueOf());

        holder.rootView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mdata == null ? 0 : mdata.size();
    }

    public DataModelBoard getBoard(int position)
    {
        return mdata != null ? mdata.get(position) : null;
    }


}
