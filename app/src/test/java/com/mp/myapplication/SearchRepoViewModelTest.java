package com.mp.myapplication;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.mp.myapplication.base.Resource;
import com.mp.myapplication.base.Status;
import com.mp.myapplication.di.component.DaggerTestComponent;
import com.mp.myapplication.di.component.TestComponent;
import com.mp.myapplication.models.Repository;
import com.mp.myapplication.searchrepo.GitHubSearchRepository;
import com.mp.myapplication.searchrepo.SearchRepoViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchRepoViewModelTest extends BaseTest {


    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private TestComponent testComponent;

    @Inject
    SearchRepoViewModel mainViewModel;

    @Mock
    GitHubSearchRepository gitHubSearchRepository;

    @Mock
    Observer<Resource<ArrayList<Repository>>> liveDataObserver;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        testComponent = DaggerTestComponent.builder().build();
        testComponent.inject(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void assertHasObserver() {
        Resource<ArrayList<Repository>> listResource = new Resource<>(Status.SUCCESS, new ArrayList<>(), "Sucess");
        when(gitHubSearchRepository.fetchRepoFromGitHub("")).thenReturn(Observable.just(listResource));
        assertTrue(mainViewModel.getMutableLiveData().hasObservers());
    }

    @Test
    public void testgetRepository() {
        mainViewModel.getMutableLiveData().observeForever(liveDataObserver);
        mainViewModel.getRepositoryofUser("vipinhelloindia");
        verify(liveDataObserver).onChanged(any());
    }

}
