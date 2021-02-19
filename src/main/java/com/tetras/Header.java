package com.tetras;

import java.util.HashMap;

public class Header implements IAffiche{

    HashMap<String, String> myheader = new HashMap<String, String>();

    @Override
    public String afficher() {
        
        return myheader.toString();

    }
    
}
