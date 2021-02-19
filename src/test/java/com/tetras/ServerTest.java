package com.tetras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/*
    Pour ce DM j'ai utilisé un singleton pour le Serveur Web ainsi qu'un pattern composite pour la requête HTTP.
*/

public class ServerTest {
    
    ServerWeb serv = ServerWeb.getInstance();   // Serveur utilisé pour les tests
    
    @Test
    public void testEvilURL() {
        

        URL evilURL = new URL();
        Body body = new Body();
        Header header = new Header();

        evilURL.path = "/evilurl";


        //Création d'un URL evil puis assertequals avec le code 403 et la fonction réponse du serveur
        RequetteHttp maRequete= new RequetteHttp();

        maRequete.ajouter(evilURL);
        maRequete.ajouter(body);
        maRequete.ajouter(header);

        maRequete.afficher();

        assertEquals(403, serv.reponse(maRequete));
    }


    
    @Test
    public void testNullURL() {

        //Création d'un URL evil vide
        

        URL nullURL = new URL();
        Body body = new Body();
        Header header = new Header();

        nullURL.path = "";


        //Création d'un URL vide puis assertequals avec le code 500 et la fonction réponse du serveur
        RequetteHttp maRequete= new RequetteHttp();

        maRequete.ajouter(nullURL);
        maRequete.ajouter(body);
        maRequete.ajouter(header);

        maRequete.afficher();

        assertEquals(500, serv.reponse(maRequete));

    }

    
    @Test
    public void testGoodURL() {

        //Création d'un URL correct puis assertequals avec le code 200 et la fonction réponse du serveur

        

        URL unURL = new URL();
        Body body = new Body();
        Header header = new Header();

        unURL.path = "/monTestUrl";

        RequetteHttp maRequete= new RequetteHttp();

        maRequete.ajouter(unURL);
        maRequete.ajouter(body);
        maRequete.ajouter(header);

        maRequete.afficher();

        assertEquals(200, serv.reponse(maRequete));

    }

    
    @Test
    public void testAfficheRequete() {
        
        URL url = new URL();
        Body body = new Body();
        Header unHeader = new Header();

        RequetteHttp RequeteTest = new RequetteHttp();

        // Création d'une requête avec un URL correct, un body et un header intitialisé aux valeurs ci-dessous
        url.path = "/testFonctionAffiche";
        body.content = "LeBody";
        unHeader.myheader.put("TestKEY", "TestVALUE");

        RequeteTest.ajouter(url);
        RequeteTest.ajouter(body);
        RequeteTest.ajouter(unHeader);

        System.out.println(RequeteTest.afficher());
        // Test de la fonction Afficher de l'objet RequeteTest de classe RequetteHttp, qui doit renvoyer la concaténation des attributs des classes URL, Body et Header. 
        assertEquals("/testFonctionAfficheLeBody{TestKEY=TestVALUE}",RequeteTest.afficher());

    }

}
