package com.example.irishka.movieapp.ui.actor.info;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.irishka.movieapp.R;
import com.example.irishka.movieapp.data.models.ActorProfileModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private List<ActorProfileModel> profileModels = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    @Inject
    public PhotosAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ActorProfileModel actorProfileModel);
    }

    public void setPhotosList(List<ActorProfileModel> profileModels) {
        this.profileModels = profileModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_photo_item, parent, false), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {

        holder.bind(profileModels.get(position));

    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }

    static class PhotosViewHolder extends RecyclerView.ViewHolder {

        OnItemClickListener onItemClickListener;

        @BindView(R.id.actor_image)
        ImageView image;

        PhotosViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
        }

        void bind(ActorProfileModel profileModel) {

            itemView.setOnClickListener(view -> onItemClickListener.onItemClick(profileModel));

            Glide.with(itemView.getContext())
                    // TODO: хардкод
                    .load("http://image.tmdb.org/t/p/w500/" +  profileModel.getFilePath())
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                            .placeholder(R.drawable.no_image)
                            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL))
                    .into(image);
        }
    }
}