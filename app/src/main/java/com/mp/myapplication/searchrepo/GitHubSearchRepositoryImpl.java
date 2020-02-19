package com.mp.myapplication.searchrepo;

import com.mp.myapplication.base.Resource;
import com.mp.myapplication.base.Status;
import com.mp.myapplication.di.module.GitHubApiInterface;
import com.mp.myapplication.di.network.NetworkManager;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

import static com.mp.myapplication.di.module.RxJavaModule.OBSERVER_ON;
import static com.mp.myapplication.di.module.RxJavaModule.SUBSCRIBER_ON;
import static io.reactivex.Observable.just;

public class GitHubSearchRepositoryImpl implements GitHubSearchRepository {

    private NetworkManager networkManager;
    private GitHubApiInterface gitHubApiInterface;
    private Scheduler subscriberOn;
    private Scheduler observerOn;

    @Inject
    public GitHubSearchRepositoryImpl(GitHubApiInterface gitHubApiInterface,
                                      NetworkManager appNetworkManager,
                                      @Named(SUBSCRIBER_ON) Scheduler subscriberOn,
                                      @Named(OBSERVER_ON) Scheduler observerOn) {
        this.gitHubApiInterface = gitHubApiInterface;
        this.subscriberOn = subscriberOn;
        this.observerOn = observerOn;
        this.networkManager = appNetworkManager;
    }

    @Override
    public boolean shouldFetch() {
        return networkManager.isOnline();
    }

    private Observable<Resource> getError(String errorMessage) {
        return just(new Resource<>(Status.ERROR, null, errorMessage));
    }


    private Observable<Resource> getSuccess(Object data) {
        return just(new Resource<>(Status.SUCCESS, data, null));
    }

    @Override
    public Observable<Resource> fetchRepoFromGitHub(String userName) {
        if (shouldFetch())
            return gitHubApiInterface.listRepositories(userName)
                    .subscribeOn(subscriberOn)
                    .observeOn(observerOn)
                    .flatMap(responseBody -> {
                        if (responseBody != null) {
                            return getSuccess(responseBody);
                        }
                        return getError("");
                    });
        return getError("");
    }
}
