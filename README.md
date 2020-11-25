[![Build Status](https://travis-ci.com/lucas-gio/design-patterns.svg?branch=main)](https://travis-ci.com/lucas-gio/design-patterns)
[![codecov](https://codecov.io/gh/lucas-gio/design-patterns/branch/main/graph/badge.svg?token=UMXLTH54H4)](https://codecov.io/gh/lucas-gio/design-patterns)
[![CodeFactor](https://www.codefactor.io/repository/github/lucas-gio/design-patterns/badge)](https://www.codefactor.io/repository/github/lucas-gio/design-patterns)

<p align="left">
  <a href="#">Español</a> |
  <a href="https://github.com/lucas-gio/design-patterns/blob/main/lang/pt/README.md">Português</a> |
  <a href="https://github.com/lucas-gio/design-patterns/blob/main/lang/en/README.md">English</a> 
</p>

# Patrones de diseño 
Prácticas relacionadas de cada patrón de diseño.
Cada patrón se encuentra en un package diferente, todos ellos dentro de com.application.

# Temas
## Singleton 
Diferentes implementaciones, seguras e inseguras, del patrón singleton.

### Inseguro en concurrencia
* [SingletonClassic](../main/main/java/com/application/singleton/SingletonClassic.java) es el clásico, que puede fallar en un acceso concurrente.

### Seguros en concurrencia
* [SingletonEagerInstance](../main/main/java/com/application/singleton/SingletonEagerInstance.java), una implementación con la instancia inicializada. Es seguro ya que al ser static la jvm asegura que se ejecute una única vez al cargar la clase.
* [SingletonInnerClass](../main/main/java/com/application/singleton/SingletonInnerClass.java), una implementación con clase interna.
* [SingletonSynchronized](../main/main/java/com/application/singleton/SingletonSynchronized.java), otra implementación basada en un bloque sincronizado.
* [SingletonDoubleCheckedLocking](../main/main/java/com/application/singleton/SingletonDoubleCheckedLocking.java), una variante del sincronizado, pero realizando la sincronización luego de verificar que la instancia es null. Se evita que ante cada get instance se realize el bloqueo, mejorando el rendimiento.
* [SingletonEnum](../main/main/java/com/application/singleton/SingletonEnum.java), una implementación con Enum. La mejor implementación ya que evita problemas de concurrencia, de serialización (ya que al deserializar se obtiene el mismo objeto), y de reflexión (porque en los demás es posible hacer el constructor público y crear nuevas instancias).

### Test
La clase [SingletonTest](../main/test/groovy/com/application/singleton/SingletonTest.groovy) contiene las pruebas unitarias de cada implementación. Se obtiene una primer instancia, luego 1.000.000 de instancias más, y se verifica que todas tengan el mismo valor.


