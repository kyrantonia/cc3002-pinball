# cc3002-pinball
## Descripción del programa

Este programa simula la mecánica del los elementos que componen el juego Pinball.

Pinball es un juego consistente en una mesa que posee elementos que se pueden golpear con una pelota.
Al momento de golpear los elemntos del juego se puede ganar puntos ya sea por el sólo hecho de bolpearlos o porque se activó un Bonus.

El objetivo del juego es conseguir el mayor puntaje posible golpeando con la pelota los elementos del juego. 

## Cómo se hizo

Tomando como base las interfaces entregadas en la tarea, se implementaron clases abstractas que implemntaran gran parte
de los métodos que estas poseían

## Patrones de diseño utilizados

### Singleton
Se utilizó para hacer que el juego y sus elementos fueran globales (puntaje actual, bonus, número de bolas, gameOver y random).
### Abstract Factory
Se utilizó para poder crear los arreglos de targets y bumpers.
### Null Pattern
Se utilizó para crear una NullTable que es la mesa con la que se inicia el juego.
### Observer
El juego observa a la mesa, la cual le manda notificaciones cuando debe actualizar su puntaje.
### Visitor+Observer
La mesa observa a los Hittable, los cuales envian un hittable o un bonus como notificación. 

Dado que dependiendo de lo que reciba la mesa como notificación de su observers debe hacer cosas diferentes,
se implementó un visitor. Para ello, se creó una interfaz viitor que es implementada por AbstractTable y una inetrfaz
notification es implementada por AbstractHittable y AbstractBonus.

Si los observer de la mesa le mandan un hittable es para que se aumente el puntaje de Game, 
con lo que se manda una notificación a Game con la cantidad con la que debe aumentar su puntaje. 

Si los observer le mandan un ExtraBallBonus o un JackPotBonus la mesa  se encarga de llamar al método trigger de estos. 

Si los observer mandan un DropTargetBonus,se aumenta la cantidad de droptTargets que se han botado, se revisa si se cumple la condición para 
hacer trigger a este Bonus, y en caso de que se cumpla llama al método trigger de este.

## Cómo correr el programa

Abrir el proyecto en Intellij IDEA, presionar Build Project y finalmente presionar Run.

## Otros

Para aprender los patrones singleton y Abstract Factory, se vieron los videos de Design Patterns in Object Oriented Programming
https://www.youtube.com/playlist?list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc
