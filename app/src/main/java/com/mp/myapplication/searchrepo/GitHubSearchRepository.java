package com.mp.myapplication.searchrepo;

import com.mp.myapplication.base.Resource;

import io.reactivex.Observable;

public interface GitHubSearchRepository extends NetworkAwareRepo{
    Observable<Resource> fetchRepoFromGitHub(String userName);
}
