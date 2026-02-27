#language: es
@regression @shopping
Característica: Gestionar compras

  Antecedentes:
    * que el usuario abre la página de SouceDemo
    * que el usuario inicia sesión correctamente

  @happyPath
  Escenario: Agregar un producto al carrito
    Cuando ha agregado un producto al carrito de compras
    Entonces el carrito debe mostrar "1" producto

  @happyPath
  Escenario: Agregar 3 productos al carrito
    Cuando agrega 3 productos al carrito de compras
    Entonces el carrito debe mostrar "3" producto

  @happyPath
  Escenario: Eliminar un producto del carrito
    Dado ha agregado un producto al carrito de compras
    Cuando luego le de clic en eliminar producto
    Entonces el carrito no debe mostrar ningún producto

  @happyPath
  Escenario: Realizar una compra exitosamente
    Dado ha agregado un producto al carrito de compras
    Cuando completa el proceso de compra con datos válidos
    Entonces debería ver el mensaje de confirmación de compra exitosa

  @unhappyPath
  Escenario: Realizar una compra sin completar el nombre del cliente
    Dado ha agregado un producto al carrito de compras
    Cuando completa el proceso de compra con datos válidos sin el nombre
    Entonces debería ver el mensaje de error el nombre es requerido

  @unhappyPath
  Escenario: Realizar una compra sin completar el apellido del cliente
    Dado ha agregado un producto al carrito de compras
    Cuando completa el proceso de compra con datos válidos sin el apellido
    Entonces debería ver el mensaje de error el apellido es requerido

  @unhappyPath
  Escenario: Realizar una compra sin completar el código postal del cliente
    Dado ha agregado un producto al carrito de compras
    Cuando completa el proceso de compra con datos válidos sin el código postal
    Entonces debería ver el mensaje de error el código postal es requerido

  @happyPath
  Escenario: Cancelar una compra
    Dado ha agregado un producto al carrito de compras
    Y complete sus datos
    Cuando le de clic en cancelar
    Entonces debería volver a la página de inventario

  @happyPath
  Esquema del escenario: Ordenar productos correctamente
    Cuando seleccione la opción de ordernar por "<opcion>" de manera "<orden>"
    Entonces debería ver los productos ordenados por "<opcion>" de manera "<orden>"

  Ejemplos:
    | opcion | orden       |
    | nombre | ascendente  |
    | nombre | descendente |
    | precio | ascendente  |
    | precio | descendente |

  @happyPath
  Escenario: Verificar precio total de los productos
    Dado agrega 3 productos al carrito de compras
    Cuando revisa los detalles de la compra
    Entonces el precio total de los productos debería ser el correcto

  @happyPath
  Escenario: Verificar precio total de la compra
    Dado agrega 3 productos al carrito de compras
    Cuando revisa los detalles de la compra
    Entonces el precio total de la compra debería ser el correcto

  @happyPath
  Escenario: Ver detalles de un producto
    Cuando da clic al título de un producto
    Entonces debería ver el detalle del producto

