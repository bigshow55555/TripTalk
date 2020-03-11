package com.example.doggame_siwan;

public class Dog
{
    protected String a ="멍멍";
    private DogListener dogListener = null;

    public Dog()
    {

    }

    public void bark()
        {

            dogListener.onBark(a);
        }

    public void onDogListener(DogListener listener){
        this.dogListener =listener;

    }
}
