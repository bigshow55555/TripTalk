package com.example.newsapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<NewsData> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_Title;
        public TextView TextView_Content;
        public ImageView ImageView_title;

        public MyViewHolder(View v) {
            super(v);
            TextView_Title =v.findViewById(R.id.TextView_title); //왜 이런식으로 해야하나? -> Activity에서 바로 찾아갈땐 그녀석이 부모의 뷰니까
            TextView_Content =v.findViewById(R.id.TextView_content); // 근데 여기서는 부모가 밑에 View v 니까, 즉 xml에서 어떤 요소를 찾을땐 부모에서 찾으니까.
            ImageView_title =v.findViewById(R.id.ImageView_title);

        }
    } // 한줄에 들어가는 요소

    public MyAdapter(List<NewsData> myDataset, Context context) { //메모리 누수 가능할수 ..

        mDataset = myDataset;
        Fresco.initialize(context);

    } // 크기만큼 반복 뷰홀더 , 어댑터에서 context는 사용 x (activity만)

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news, parent, false); // 특정한 컴포넌트(리사이클러 뷰)의 특정 항목의 레이아웃을 바꾸는 inflate
        MyViewHolder vh = new MyViewHolder(v); // <-- 여기가 위의 부모니까.
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        NewsData news = mDataset.get(position);

       holder.TextView_Title.setText(news.getTitle());

       String content = news.getContent();
       if(content != "null" )
       {
           holder.TextView_Content.setText(content);
       }
       else {
           holder.TextView_Content.setText("정보가 없습니다.");
       }

        Uri uri = Uri.parse(news.getUrltoImage());

        holder.ImageView_title.setImageURI(uri);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}

