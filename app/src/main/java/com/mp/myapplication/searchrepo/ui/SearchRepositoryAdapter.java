package com.mp.myapplication.searchrepo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mp.myapplication.R;
import com.mp.myapplication.models.Repository;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchRepositoryAdapter extends RecyclerView.Adapter<SearchRepositoryAdapter.SearchRepositoryVH> {
    ArrayList<Repository> myDataset;

    SearchRepositoryAdapter(ArrayList<Repository> myDataset) {
        this.myDataset = myDataset;
    }


    @Override
    public SearchRepositoryVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_repository, parent, false);
        SearchRepositoryVH vh = new SearchRepositoryVH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SearchRepositoryVH holder, int position) {
        holder.setData(myDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

    public class SearchRepositoryVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_user_avatar)
        ImageView ivUserAvatar;
        @BindView(R.id.tv_repo_name)
        TextView tvRepoName;
        @BindView(R.id.tv_language)
        TextView tvLanguage;
        @BindView(R.id.tv_repo_description)
        TextView tvRepoDescription;
        @BindView(R.id.tv_star_num)
        TextView tvStarNum;
        @BindView(R.id.tv_fork_num)
        TextView tvForkNum;
        @BindView(R.id.tv_owner_name)
        TextView tvOwnerName;
        @BindView(R.id.tv_fork_owner)
        View forkMark;


        public SearchRepositoryVH(View v) {
            super(v);
            v.setOnClickListener(this);
            ButterKnife.bind(this,v);
        }

        public void setData(Repository repository) {

            boolean hasOwnerAvatar = StringUtils.isNotEmpty(repository.getOwner().getAvatarUrl());
            tvRepoName.setText(hasOwnerAvatar ? repository.getName() : repository.getFullName());
            ViewUtils.setTextView(tvRepoDescription, repository.getDescription());
            tvForkNum.setText(String.valueOf(repository.getForksCount()));
            tvStarNum.setText(String.valueOf(repository.getWatcher()));
            tvOwnerName.setText(repository.getOwner().getLogin());
            if (StringUtils.isEmpty(repository.getLanguage())) {
                tvLanguage.setText("");
            } else {
                tvLanguage.setText(repository.getLanguage());
            }
            forkMark.setVisibility(repository.isFork() ? View.VISIBLE : View.INVISIBLE);
            Glide.with(ivUserAvatar)
                    .load(repository.getOwner().getAvatarUrl()).circleCrop().into(ivUserAvatar);

        }

        @Override
        public void onClick(View v) {

        }
    }
}