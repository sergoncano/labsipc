# Labsipc
Para cada práctica, crea un nuevo paquete dentro de `src/main/java` y otro dentro de `src/main/resources`. Guarda en el primero el código y en el segundo los fxml, imágenes, etc...  
Para ejecutarlo, cambia `<mainClass>` en `pom.xml` al nombre de la clase que ejecute la escena inicial de la práctica (`pract1.App`, en la primera), y luego ejecuta:  
```
$ mvn javafx:run
```
La UPV no quiere actualizarse y aprender sobre las tecnologías que se usan en entornos de trabajo reales, así que los alumnos tenemos que hacerlo por nuestra cuenta :/  
Si no te gusta utilizar NetBeans puedes usar la versión comunitaria de [IntelliJ](https://www.jetbrains.com/idea/), o realmente cualquier otro editor.  
Como yo uso vim, que no tiene scenebuilder, lo he tenido que instalar por separado.  
En Arch Linux el paquete se llama "javafx-scenebuilder", solo está en el [AUR](https://aur.archlinux.org/).  
Si usas otra distro, busca "scenebuilder" o "gluon" en tu repositorio de paquetes.
