package com.nacoda.moviesmvvm.util;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/**
 * Created by Mayburger on 1/9/18.
 */

public class MoviesExt {
    public static final void replaceFragmentInActivity(@NotNull AppCompatActivity $receiver, @NotNull Fragment fragment, int frameId) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        FragmentManager var10000 = $receiver.getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(var10000, "supportFragmentManager");
        FragmentManager $receiver$iv = var10000;
        FragmentTransaction var4 = $receiver$iv.beginTransaction();
        var4.replace(frameId, fragment);
        var4.commit();
    }

    private static final void transact(@NotNull FragmentManager $receiver, Function1 action) {
        FragmentTransaction var3 = $receiver.beginTransaction();
        action.invoke(var3);
        var3.commit();
    }

    @NotNull
    public static final ViewModel obtainViewModel(@NotNull AppCompatActivity $receiver, @NotNull Class viewModelClass) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(viewModelClass, "viewModelClass");
        return ViewModelProviders.of((FragmentActivity)$receiver, (ViewModelProvider.Factory)(new ViewModelFactory.Companion()).getInstance($receiver.getApplication())).get(viewModelClass);
    }

    @NotNull
    public static final ViewModel obtainViewModel(@NotNull Fragment $receiver, @NotNull Class viewModelClass) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(viewModelClass, "viewModelClass");
        ViewModelFactory.Companion var10001 = new ViewModelFactory.Companion();
        FragmentActivity var10002 = $receiver.getActivity();
        if(var10002 == null) {
            Intrinsics.throwNpe();
        }

        return ViewModelProviders.of($receiver, (ViewModelProvider.Factory)var10001.getInstance(var10002.getApplication())).get(viewModelClass);
    }

    public static final void showSnackbar(@NotNull View $receiver, @NotNull String snackbarText, int timeLength) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(snackbarText, "snackbarText");
        Snackbar.make($receiver, (CharSequence)snackbarText, timeLength).show();
    }
}
