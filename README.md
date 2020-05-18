# PianoRMI
It's a java application which emulates a piano keyboard. Additionally, it provides six "mini-tutorial" songs to learn. RMI is used to connect both java classes the only-keyboard class, and the songs-to-learn class (this one contains the notes and silence parts for each song).

In order to locally run the app, you have to do the following steps:

1. Compile the class Canciones.java.
2. Run 'rmic' command on your OS shell followed by 'Canciones.class' obtained previously. You will get the corresponding stub class needed to set the connection between classes.
3. Compile the class Piano.java. Make sure that both 'IconosAplicacion' and 'wav' folders are within the Piano.class directory, otherwise, the piano app won't work.
4. Move both stub and CancionesInterface classes to the directory where Piano class is located.
5. Run 'start rmiregistry' command on a shell window.
6. Execute Canciones.class on other shell window. This is actually the server class.
7. Finally, execute Piano.class on another shell window (client class).

// Espanol

Es una aplicacion java que emula un teclado de piano. Adicionalmente, provee seis canciones "minitutoriales" para aprender. RMI se usa para conectar a las dos clases: la clase de solo el teclado y la clases con las canciones para aprender (esta contiene las notas y silencios para cada cancion).

Para correr localmente la app, tienes que hacer los siguientes pasos:

1. Compila la clase Canciones.java.
2. Corre el comando 'rmic' en la consola de tu SO seguido de 'Canciones.class' obtenida previamente. Obtendras la clase stub correspondiente para crear la conexion entre clases.
3. Compila la clase Piano.java. Asegurate de que ambas carpetas: 'IconosAplicacion' y 'wav' estan dentro del directorio de Piano.class, si no la aplicacion de piano no funcionara. 
4. Mueve ambas clases: stub y CancionesInterface, al directorio donde está la clase Piano.
5. Corre el comando 'start rmiregistry' en una ventana de consola.
6. Ejecuta Canciones.class en otra ventana de consola. Esta es la clase servidor.
7. Finalmente, ejecuta Piano.class en otra ventana de consola (clase cliente).

