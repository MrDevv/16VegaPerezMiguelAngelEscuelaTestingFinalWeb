#language: es
@regression @shopping
Característica: Gestionar compras

  Antecedentes:
    * que el usuario abre la página de SouceDemo

  @happyPath
  Escenario: Agregar un producto al carrito
    Dado que el usuario inicia sesión correctamente
    Cuando agregue un producto al carrito de compras
    Entonces el carrito debe mostrar "1" producto

  @happyPath
  Escenario: Agregar 3 productos al carrito
    Dado que el usuario inicia sesión correctamente
    Cuando agregue 3 productos al carrito de compras
    Entonces el carrito debe mostrar "3" producto

  @happyPath
  Escenario: Eliminar un producto del carrito
    Dado que el usuario inicia sesión correctamente
    * agregue un producto al carrito de compras
    Cuando luego le de clic en eliminar producto
    Entonces el carrito no debe mostrar ningún producto



