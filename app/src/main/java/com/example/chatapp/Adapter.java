package com.example.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataItem> myDataList=new ArrayList<>();

    public Adapter(ArrayList<DataItem> dataList){
        myDataList = dataList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(viewType == Code.ViewType.LEFT_CONTENT){
            view = inflater.inflate(R.layout.room_left_item,parent,false);
            return new LeftViewHolder(view);
        }else{
            view = inflater.inflate(R.layout.room_right_item,parent,false);
            return new RightViewHolder(view);
        }

    }


    // 실제 각 뷰 홀더에 데이터를 연결해주는 함수
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//        if(viewHolder instanceof CenterViewHolder){
//            ((CenterViewHolder)viewHolder).textv.setText(myDataList.get(position).getContent())}
        if(viewHolder instanceof LeftViewHolder){
            ((LeftViewHolder)viewHolder).textv_nicname.setText(myDataList.get(position).getName());
            ((LeftViewHolder)viewHolder).textv_msg.setText(myDataList.get(position).getContent());
        }else{
            ((RightViewHolder)viewHolder).textv_msg.setText(myDataList.get(position).getContent());
        }

    }

    // 리사이클러뷰안에서 들어갈 뷰 홀더의 개수
    @Override
    public int getItemCount() {
        return myDataList==null?0:myDataList.size();
    }

    // ★★★
    // 위에 3개만 오버라이드가 기본 셋팅임,
    // 이 메소드는 ViewType때문에 오버라이딩 했음(구별할려고)
    @Override
    public int getItemViewType(int position) {
        return myDataList.get(position).getViewType();
    }

    // "리사이클러뷰에 들어갈 뷰 홀더", 그리고 "그 뷰 홀더에 들어갈 아이템들을 셋팅"
//    public static class CenterViewHolder extends RecyclerView.ViewHolder{
//        TextView textv;
//
//        public CenterViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textv = (TextView)itemView.findViewById(R.id.textv);
//        }
//    }

    public static class LeftViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView textv_nicname;
        TextView textv_msg;
        TextView textv_time;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv = (ImageView)itemView.findViewById(R.id.user_pf1);
            textv_nicname = (TextView)itemView.findViewById(R.id.textv_nicname);
            textv_msg = (TextView)itemView.findViewById(R.id.textv_msg);
            textv_time = (TextView)itemView.findViewById(R.id.textv_time);

        }
    }

    public static class RightViewHolder extends RecyclerView.ViewHolder{
        TextView textv_msg;
        TextView textv_time;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            textv_msg = (TextView)itemView.findViewById(R.id.textv_msg);
            textv_time = (TextView)itemView.findViewById(R.id.textv_time);
        }
    }

}