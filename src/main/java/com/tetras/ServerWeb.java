package com.tetras;

public class ServerWeb {

    private static ServerWeb monServeur = new ServerWeb();

    private ServerWeb(){

    }
    
    public static ServerWeb getInstance(){

        return monServeur;
    }

    public int reponse(RequetteHttp uneRequete){

        URL nullURL = new URL();
        URL checkURL = (URL)uneRequete.requeteParts.stream().filter(t -> t instanceof URL).findFirst().orElse(nullURL); // On récupérère l'URL depuis les différentes parties de la requête
        int querryResult = 500;

        try{

            if(checkURL.path.isEmpty()){   // path vide ou null
                querryResult = 500;
            }
            else if(checkURL.path.contains("/evilurl")){    
                querryResult = 403;
            }
            else querryResult = 200;

        }catch(Exception e){
            e.printStackTrace();
        }

        return querryResult;
    }

}
 