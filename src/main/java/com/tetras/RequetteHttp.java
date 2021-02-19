package com.tetras;

import java.util.ArrayList;
import java.util.List;

public class RequetteHttp implements IAffiche {
    
    public List<IAffiche> requeteParts = new ArrayList<>();
    String fullrequete = "";

    public void ajouter(IAffiche obj){
        requeteParts.add(obj);
    }

    @Override
    public String afficher() {
        
        fullrequete = "";
        requeteParts.stream().forEach(t -> fullrequete = fullrequete + t.afficher());

        return fullrequete;

    }
}
