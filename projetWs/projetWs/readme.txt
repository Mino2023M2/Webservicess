Partie-1:

1)SOA: est une architecture utiliser dans le web pour faire la comunication dans 
le monde du web  Architecture orientée services les caractersistique su soa
Flexibilité ,Réutilisation ,Interopérabilité 

Les services web sont un type de service qui utilise Internet pour communiquer entre applications.
Ils sont basés sur SOAP, WSDL et XML.
2)architecture SOAP: consomateur - fournisseur - annieur UUID wsdl
3)les etapes pour appler une service soap 
a-le fournisseur push son service sur l'annieur 
b-le consommateur cherche dans l'annieur le meilleur fonction pour son traveille 
c-le consomateur invoce le methode pour le consommater
                                                  

Partie-2:
1)les aventage du service SOAP par raport a dautre methode c'est la rapidite car 
l'utilisation du xml faire la comunication rapid car toute les navigateur web comprendre xml
comme une langage native 
-Indépendance des plateformes et des langages 
-Sécurite
-Extensibilite

2)

class Personne{
    private int age;
    private String nom,prenome;
    getters()...;
    setters()...;
}
@WebService
class SevicePersone{
@WebMethod()
void addPersone(@WebParm Personne personne){
    PersonneDoa perDoa=new PersonneDoa();
    perDoa.save(personne);
}
@WebMethod
void deletePersonne(@WebParm int id){
    PersonneDoa perDoa=new PersonneDoa();
perDoa.delete(id);

}
void updatePersonne(@WebParm Personne personne,@WebParm int id){
    PersonneDoa perDoa=new PersonneDoa();
perDoa.update(personne,id);
}

}


class AppService{
 public static void main(String args[]){
    String url = "http://localhost:8080/personService";
        Endpoint.publish(url, new PersoneServiceImp());

 }  
}
