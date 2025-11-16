@echo off
@REM REM Compile et package le projet
@REM mvn clean package

REM Vérifie si le build a réussi
IF EXIST target\testapp-1.0.0.war (
    echo Copie du WAR vers Tomcat...
    copy /Y target\testapp-1.0.0.war D:\PERS\MIOTY\s5\apache-tomcat-10.1.39\apache-tomcat-10.1.39\webapps\
    echo Deploiement terminé.
) ELSE (
    echo Le fichier WAR n'a pas été généré. Vérifiez les erreurs Maven.
)
pause
