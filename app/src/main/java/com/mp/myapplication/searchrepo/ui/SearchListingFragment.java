package com.mp.myapplication.searchrepo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mp.myapplication.R;
import com.mp.myapplication.app.LauncherActivity;
import com.mp.myapplication.base.BaseAppCompactFragment;
import com.mp.myapplication.base.Resource;
import com.mp.myapplication.base.Status;
import com.mp.myapplication.searchrepo.SearchRepoViewModel;

import javax.inject.Inject;

public class SearchListingFragment extends BaseAppCompactFragment {

    @Inject
    SearchRepoViewModel searchRepoViewModel;

    private RecyclerView recyclerView;
    SearchRepositoryAdapter searchRepositoryAdapter;

    public static SearchListingFragment newInstance(String username) {
        Bundle bundle = new Bundle();
        bundle.putString(LauncherActivity.KEY_USERNAME, username);
        SearchListingFragment searchListingFragment = new SearchListingFragment();
        searchListingFragment.setArguments(bundle);
        return searchListingFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_searchListing);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchRepoViewModel.getMutableLiveData().observe(getActivity(), arrayListResource -> {
            if (isSuccess(arrayListResource)) {
                searchRepositoryAdapter = new SearchRepositoryAdapter(arrayListResource.getData());
                recyclerView.setAdapter(searchRepositoryAdapter);
            }
        });

        searchRepoViewModel.getRepositoryofUser(getArguments().getString(LauncherActivity.KEY_USERNAME));
    }

    private boolean isSuccess(Resource resource) {

        return resource.getStatus() == Status.SUCCESS;
    }


}
