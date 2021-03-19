package com.example.videolist.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videolist.R;
import com.example.videolist.models.videopopular.VideoFile;
import com.example.videolist.models.videopopular.VideoPicture;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularVideoAdapter extends RecyclerView.Adapter<PopularVideoAdapter.PopularVideoViewHolder> {
    private Context context;
    private List<VideoPicture> videoPictures;
    private List<VideoFile> videoFiles;

    public PopularVideoAdapter(Context context, List<VideoPicture> videoPictures, List<VideoFile> videoFiles) {
        this.context = context;
        this.videoPictures=videoPictures;
        this.videoFiles=videoFiles;
    }

    public void addItems(List<VideoPicture> videoPictures, List<VideoFile> videoFiles){
        this.videoPictures=videoPictures;
        this.videoFiles=videoFiles;
    }

    @NonNull
    @Override
    public PopularVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        return new PopularVideoViewHolder(inflater.inflate(R.layout.row_popular_video,null));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularVideoViewHolder holder, int position) {
        holder.bind(videoPictures.get(position),videoFiles.get(position));
    }

    @Override
    public void onViewAttachedToWindow(@NonNull PopularVideoViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position=holder.getAdapterPosition();
        holder.imageView.setVisibility(View.GONE);

        holder.videoPlayer.setVisibility(View.VISIBLE);
        holder.player.setPlayWhenReady(true);
    }

    @Override
    public int getItemCount() {
        return videoPictures.size();
    }

    public static class PopularVideoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private PlayerView videoPlayer;
        private SimpleExoPlayer player;

        public PopularVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            videoPlayer=itemView.findViewById(R.id.videoPlayer);
            player = new SimpleExoPlayer.Builder(itemView.getContext()).build();
            videoPlayer.setPlayer(player);
        }

        public void bind(VideoPicture videoPicture,VideoFile videoFile){
            Picasso.get().load(videoPicture.getPicture()).noFade().into(imageView);
            initializePlayer(videoFile.getLink());
        }

        private void initializePlayer(String url){
        // Create a default TrackSelector
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelection.Factory videoTrackSelectionFactory =
                    new AdaptiveTrackSelection.Factory();
            TrackSelector trackSelector =
                    new DefaultTrackSelector(videoTrackSelectionFactory);

        //Initialize the player
            player = ExoPlayerFactory.newSimpleInstance(itemView.getContext(), trackSelector);

        //Initialize simpleExoPlayerView

            videoPlayer.setPlayer(player);

            // Produces DataSource instances through which media data is loaded.
                        DataSource.Factory dataSourceFactory =
                                new DefaultDataSourceFactory(itemView.getContext(), Util.getUserAgent(itemView.getContext(), "CloudinaryExoplayer"));

            // Produces Extractor instances for parsing the media data.
                        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

            // This is the MediaSource representing the media to be played.
                        Uri videoUri = Uri.parse(url);
                        MediaSource videoSource = new ExtractorMediaSource(videoUri,
                                dataSourceFactory, extractorsFactory, null, null);

            // Prepare the player with the source.
            player.prepare(videoSource);

        }
    }
}


