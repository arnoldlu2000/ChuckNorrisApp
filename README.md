Rapport projet Chuck Norris App / Kotlin:

Membre du groupe : Lu Arnold

NB : Version qui marche sur la branche "version1" du git
	La branche main contient la version avec des améliorations mais qui ne marche pas

Le but de ce projet est de réaliser une application "ChuckNorrisApp" qui a pour but d'afficher des blagues de Chuck Norris sur l'écran de notre téléphone.

Pour cela, nous avons dû utiliser les technologies suivantes :
- Utilisation de liste pour stocker nos données
- RecyclerView pour l'affichage de nos données sur l'écran (+ Adapter)
- Création d'un custom layout pour un affichage personnalisé
- Kotlinx-Serialization pour pouvoir convertir nos données Json et pouvoir les manipuler
- Retrofit, ReactiveX pour envoyer des requêtes vers l'API Chuck Norris

1 - Interface utilisateur simple (1er commit)

Dans notre première version, nous avons commencé par implémenter le "RecyclerView". Puisqu'au final nous aurons une liste de beaucoup de blagues, elles ne pourront pas tous figurer sur l'écran. Cette technologie nous permet donc d'optimiser notre vue pour afficher un certain nombre d'éléments issus d'un grand ensemble de données sur une fenêtre limitée.

Le RecyclerView est implémenté en 3 parties :
- Un adapter qui gère la vue de la fenêtre limitée et un ensemble de données, donc l'insertion de données dans le RecyclerView
- Un layoutManager qui va s'occuper de placer correctement dans l'espace un ensemble de données
- Un ViewHolder qui va permettre l'affichage visuel d'un élement dans le RecyclerView

Après avoir importer tous nos modules, nous avons créé une classe JokeAdapter et une classe interne JokeViewHolder afin de conserver deux variables, titleImage qui va contenir une valeur de type ImageView et JokeHeading qui va contenir une valeur de type TextView. ImageView et TextView seront définis dans notre custom layout plus tard pour permettre l'affichage visuel des blagues + images sur la fenêtre.
Notons que dans un premier temps, nous manipulerons des objects de la data classe Items (une structure de données avec comme attribut un int pour l'image et une string pour la chaine de caractères contenant la blague.

Nous allons ensuite implémenter notre adapter qui va faire le lien entre la vue du RecyclerView et notre contrôleur. Elle va être construire avec une liste d'objets en paramètre depuis le controleur. Cela passe par 3 méthodes primordiales :
- onCreateViewHolder() qui va créer un ViewHolder à partir du layout et qui va représenter chaque ligne du RecyclerView
- onBindViewHolder() qui va être appelée pour toutes les lignes visibles sur notre écran et leur associer leur valeur.
- getItemCount() qui va retourner la taille de notre liste, donc donner l'info sur le nombre de lignes max d'affichage simultané.

On décide ensuite de personnaliser notre vue des items avec joke_layout.xml. Dedans, nous allons redéfinir l'espace entre le texte, l'image, la couleur et l'espace entre chaque ligne.

Finalement, dans le main_activity, nous allons coder en brut nos blagues et nos images que l'on stockera dans une ArrayList, on créera notre adapter, layoutmanager et on appellera la méthode fillingJokes afin de compléter nos listes.

Nous avons ici une première version qui marche avec les blagues codées en brut dans le main_activity.

2 - Récupération des blagues depuis l'API

Au lieu d'écrire nous même les blagues, nous cherchons à les récupérer depuis l'API Chuck Norris qui permet de générer aléatoirement des blagues. Ces blagues nous sont données sous le format JSON. Il faut donc créer un modèle de données capable de traiter les informations reçues de l'API.
C'est pourquoi nous nous tournons vers la sérialisation. Elle permet la conversion du fichier JSON en classe Kotlin. On remplace donc l'ancienne data class Items par une nouvelle data classe Joke qui prend cette fois en compte la date de création, une url, ...
Maintenant, nous cherchons à effectuer des requêtes vers l'API afin qu'il nous renvoie des fichiers JSON. Pour cela, nous utilsons Retrofit (un client HTTP sécurisé pour Android et Java permettant l'authentification, l'interaction et l'envoi de requêtes avec des API) et ReactionX qui amène les notions de Observeur, Iterateur et programmation fonctionnelle.

Cependant, je n'ai pas réussi à implémenter cette partie, m'arrêtant à l'usage de Retrofit. La deuxième version soumise ne marche donc pas.

Conclusion :

Malheuresement, je n'ai pas pu aller au bout de ce projet, travaillant seul et rencontrant des difficultés lors de la compréhension du sujet, ce qui m'a demandé pas mal de temps et de refléxion.




