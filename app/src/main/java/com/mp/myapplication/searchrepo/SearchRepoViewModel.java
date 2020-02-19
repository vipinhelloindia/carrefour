package com.mp.myapplication.searchrepo;

import androidx.lifecycle.MutableLiveData;

import com.mp.myapplication.base.BaseViewModel;
import com.mp.myapplication.base.Resource;
import com.mp.myapplication.base.Status;
import com.mp.myapplication.models.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SearchRepoViewModel extends BaseViewModel {
    private GitHubSearchRepository gitHubSearchRepository;
    protected MutableLiveData<Resource<ArrayList<Repository>>> mutableLiveData = new MutableLiveData<>();


    @Inject
    public SearchRepoViewModel(GitHubSearchRepository gitHubSearchRepository) {
        this.gitHubSearchRepository = gitHubSearchRepository;
    }

    public void getRepositoryofUser(String userName) {
        gitHubSearchRepository.fetchRepoFromGitHub(userName)
                .doOnSubscribe(this::addToDisposable)
                .subscribe(new Observer<Resource>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Resource resource) {
                        mutableLiveData.postValue(resource);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mutableLiveData.postValue(new Resource<>(Status.ERROR, new ArrayList<>(), "Error message"));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MutableLiveData<Resource<ArrayList<Repository>>> getMutableLiveData() {
        return mutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onStop();
        super.onCleared();
    }
}
