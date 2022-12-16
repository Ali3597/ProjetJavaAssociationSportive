# ProjetJavaAssociationSportive

Ce projet simule une communauté sportive avec les classes suivantes :

- Organisation
- Sportif
- Tournoi
- Club

Et un enum :

- Sport

IL va permettre aux organisation de créer des tournois de différents sports , permettre au club de participer  à ces tournois, de recruter des sportifs 

IL va permettre aussi de gérer un aspect de budget pour les organisations et pour les clubs ainsi qu'un système de prestige qui permettra de classer les sportifs .

### Avant de commencer à coder

Ce projet contient deux githooks :

- Un de près commit qui va s'assurer que tous les tests fonctionnent avant le commit
- Un de près push qui va s'assure qu'aucune personne ne push directement sur la branche develop , prod ou stage 



Pour s'assurer que git connaisse le fichier de hooks assurer vous exécuter la commande suivante sur le dossier root du projet la première fois que vous le récupérer.

```
git config core.hooksPath .githooks
```





