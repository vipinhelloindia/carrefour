package com.mp.myapplication.di.module;

import com.mp.myapplication.models.Repository;
import com.mp.myapplication.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApiInterface {

    @GET("users/{user}/repos")
    Observable<List<Repository>> listRepositories(@Path("user") String user);

    @GET("repos/{user}/{repo}/contributors")
    Observable<List<User>> listContributors(@Path("user") String user, @Path("repo") String repo, @Query("page") int page);
}
