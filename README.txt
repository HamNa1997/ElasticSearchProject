Projet de développement d'une application d'indexation de CV dans ElasticSearch, dans le cadre des cours de l'UE DAAR dispensée à la Sorbonne université (M2 RES/INSTA).
Travail réalisé en binôme :
-Nazih Mohamed HAMLIL.
-Nassim ZERKA.

Caractéristiques de l'application :

-Deux endpoints :
"/api/upload"  (POST) -> Pour l'upload des fichiers (CVs) à indexer (Format Word ou PDF).
"/api/search?keyword=" (GET) -> Pour la recherche de CVs à partir d'un mot clé.

-Utilisation du framework Spring Data Elasticsearch pour l'indexation et la recherche.

-Utilisation des librairies "PDFbox" et "POI" pour le parsing des documents.

-Utilisation des "Encoders" et "Appenders" de "Logback" pour logger via "Logstash" (Fichier logback.xml dans ressources), Le fichier de configuration Logstash est fourni dans le dépôt pour consultation.

-Enfin, utilisation de Kibana pour la visualisation des logs.

Démo :

Lien vidéo : https://youtu.be/mWKRInOUDU0