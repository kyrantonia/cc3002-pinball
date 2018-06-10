# cc3002-pinball
## Descripción del programa

Este programa simula la mecánica del los elementos que componen el juego Pinball.

Pinball es un juego consistente en una mesa que posee elementos que se pueden golpear con una pelota.
Al momento de golpear los elemntos del juego se puede ganar puntos ya sea por el sólo hecho de golpearlos o porque se activó un Bonus.

El objetivo del juego es conseguir el mayor puntaje posible golpeando con la pelota los elementos del juego. 

## Cómo se hizo

Tomando como base las interfaces entregadas en la tarea, se implementaron clases abstractas que implementan gran parte
de los métodos que estas poseían

## Patrones de diseño utilizados

### Singleton
Se utilizó en el jugo con la finalidad de que este pudiera ser instanciado sólo una vez, además, dentro de sus parametros se incluyeron los Bonus para que al llamarlos desde Game estos correspondieran siempre a la misma instancia.
### Abstract Factory
Se utilizó para poder crear los arreglos de targets y bumpers.
### Null Pattern
Se utilizó para crear una NullTable que es la mesa con la que se inicia el juego.
### Observer
El juego observa a la mesa, la cual le manda notificaciones cuando debe actualizar su puntaje.
### Visitor+Observer
La mesa observa a los Hittable, los cuales envian un hittable o un bonus como notificación. 

Dado que dependiendo de lo que reciba la mesa como notificación debe hacer cosas diferentes,
se implementó un visitor. Para ello, se creó una interfaz visitor que es implementada por AbstractTable y una interfaz
Notification que es implementada por AbstractHittable y AbstractBonus.

Si a la mesa se le manda un hittable es para que se aumente el puntaje de Game, 
con lo que se manda en una notificación a Game con en cuanto debe aumentar su puntaje. 

Si a la mesa se le mandan un ExtraBallBonus o un JackPotBonus, esta  se encarga de llamar al método trigger de estos. 

Si a la mesa se le manda un DropTargetBonus, se aumenta la cantidad de droptTargets que se han botado, se revisa si se cumple la condición para hacer trigger a este Bonus, y en caso de que se cumpla llama al método trigger de este.

## Cómo correr el programa

Descomprimir el proyecto.

Abrir Intellij IDEA, si se tiene un proyecto abierto cerrarlo. 

Presionar Import Project, seleccionar el proyecto.

Seleccionar "Import project from external model" y Maven. 

Presionar next, hasta llegar a finish, ahí apretar finish y esperar a que se cargue el proyecto.

Para correr los test hacer click derecho en la carpeta java que está dentro de test. Seleccionar "Run All Tests"

## Otros

Para aprender los patrones singleton y Abstract Factory, se vieron los videos de Design Patterns in Object Oriented Programming
https://www.youtube.com/playlist?list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc
