package com.tetras;

public class URL implements IAffiche{

    String path = "";

    @Override
    public String afficher() {
        //
        return path;
    }
    
}