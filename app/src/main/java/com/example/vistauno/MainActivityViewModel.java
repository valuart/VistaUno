package com.example.vistauno;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Integer> color;
    private MutableLiveData<String> mayuscula;
    private MutableLiveData<String> minuscula;

    public LiveData<Integer> getColor() {
        if(color==null){
            color = new MutableLiveData<>();
        }
        return color;
    }

    public LiveData<String> getMayuscula() {
        if(mayuscula==null) {
            mayuscula = new MutableLiveData<>();
        }
        return mayuscula;
    }

    public LiveData<String> getMinuscula() {
        if(minuscula==null) {
           minuscula = new MutableLiveData<>();
        }
        return minuscula;
    }
    public void cambiarColor(){
        color.setValue(Color.GREEN);
    }

    public void cambiarMayuscula(String texto){
        mayuscula.setValue(texto.toUpperCase());
    }

    public void cambiarMinuscula(String texto){
        minuscula.setValue(texto.toLowerCase());
    }
}
