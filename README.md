travis banner
codecov banner
codefactor banner

<p align="left">
  <a href="#">Español</a> |
  <a href="">Português</a> |
  <a href="">English</a> 
</p>

# Patrones de diseño 
Prácticas relacionadas de cada patrón de diseño.
Cada patrón se encuentra en un package diferente, todos ellos dentro de com.application.

# Temas
## Singleton 
Diferentes implementaciones, seguras e inseguras, del patrón singleton.

### Inseguro en concurrencia
* [SingletonClassic](../src/main/java/com/application/) es el clásico, que puede fallar en un acceso concurrente.

### Seguros en concurrencia
* [SingletonEagerInstance](), una implementación con la instancia inicializada. Es seguro ya que al ser static la jvm asegura que se ejecute una única vez al cargar la clase.
* [SingletonInnerClass](), una implementación con clase interna.
* [SingletonSynchronized](), otra implementación basada en un bloque sincronizado.
* [SingletonDoubleCheckedLocking](), una variante del sincronizado, pero realizando la sincronización luego de verificar que la instancia es null. Se evita que ante cada get instance se realize el bloqueo, mejorando el rendimiento.
* [SingletonEnum](), una implementación con Enum. La mejor implementación ya que evita problemas de concurrencia, de serialización (ya que al deserializar se obtiene el mismo objeto), y de reflexión (porque en los demás es posible hacer el constructor público y crear nuevas instancias).

### Test
La clase [SingletonTest]() contiene las pruebas unitarias de cada implementación. Se obtiene una primer instancia, luego 1.000.000 de instancias más, y se verifica que todas tengan el mismo valor.


