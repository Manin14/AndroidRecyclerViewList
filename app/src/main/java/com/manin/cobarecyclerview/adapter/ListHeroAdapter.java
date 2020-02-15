package com.manin.cobarecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.manin.cobarecyclerview.Detail;
import com.manin.cobarecyclerview.MainActivity;
import com.manin.cobarecyclerview.R;
import com.manin.cobarecyclerview.model.Hero;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>{
    private Context context;

    private ArrayList<Hero> listHero;
    public ListHeroAdapter( Context context,ArrayList<Hero> list) {//nambah parameter disini yaitu context
        this.listHero = list;
        this.context = context;
    }


    //aksi klik item
   // private OnItemClickCallBack a;


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Hero hero=listHero.get(position);
        //cara ambil gambar dari hero, dia adapter
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        //cara ambil tex nama hero, di adapter
        holder.tvName.setText(hero.getName());

        //cara ambil tex detail dari hero, di adapter
        holder.tvDetail.setText(hero.getDetail());

          //aksi klik setiap item nya
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Kamu memilih "+listHero.get(holder.getAdapterPosition()).getName(),Toast.LENGTH_LONG).show();

                //cara pindah activity ke detail dengan membawa data
              Intent intent = new Intent(context,Detail.class);
              intent.putExtra("nama",hero.getName());
              intent.putExtra("gambar",hero.getPhoto());
              intent.putExtra("detail",hero.getDetail());
               context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        de.hdodenhof.circleimageview.CircleImageView imgPhoto;
        AppCompatTextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.id_item_foto);
            tvName = itemView.findViewById(R.id.id_item_name);
            tvDetail = itemView.findViewById(R.id.id_item_detail);
        }
    }
}
