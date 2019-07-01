package chapter.android.aweme.ss.com.homework;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {
    private List<Message> mDatas;

    public static class VH extends RecyclerView.ViewHolder{
        public final CircleImageView icon;
        public final ImageView icon2;
        public final TextView name;
        public final TextView content;
        public final TextView time;
        public VH(View v) {
            super(v);
            icon =  v.findViewById(R.id.iv_avatar);
            icon2=  v.findViewById(R.id.robot_notice);
            name = v.findViewById(R.id.tv_title);
            content = v.findViewById(R.id.tv_description);
            time = v.findViewById(R.id.tv_time);
            System.out.println("????");
        }
    }


    public NormalAdapter(List<Message> data) {
        this.mDatas = data;
        System.out.println("wtf");
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        /*holder.icon.setImageResource(mDatas.get(position).getIcon());
                (mDatas.get(position).getIcon());
                ();*/
        holder.content.setText(mDatas.get(position).getDescription());
        holder.time.setText(mDatas.get(position).getTime());
        holder.name.setText(mDatas.get(position).getTitle());

        String temp_icon=mDatas.get(position).getIcon();
        if(temp_icon.equals("TYPE_ROBOT")){
            holder.icon.setImageResource(R.drawable.session_robot);
        }
        else if (temp_icon.equals("TYPE_GAME")){
            holder.icon.setImageResource(R.drawable.icon_micro_game_comment);
        }
        else if (temp_icon.equals("TYPE_USER")){
            holder.icon.setImageResource(R.drawable.icon_girl);
        }
        else if (temp_icon.equals("TYPE_SYSTEM")){
            holder.icon.setImageResource(R.drawable.session_system_notice);
        }
        else if (temp_icon.equals("TYPE_STRANGER")){
            holder.icon.setImageResource(R.drawable.session_stranger);
        }
        else{
            holder.icon.setImageResource(R.drawable.icon_girl);
        }

        if(mDatas.get(position).isOfficial()){
            holder.icon2.setVisibility(ImageView.VISIBLE);
            holder.icon2.setImageResource(R.drawable.im_icon_notice_official);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
                System.out.println("click");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.im_list_item, parent, false);
        return new VH(v);
    }
}
