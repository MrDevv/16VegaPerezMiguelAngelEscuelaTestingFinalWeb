#language: es
  @regression @authentication
  Característica: Iniciar sesión en SouceDemo

    Como usuario de SouceDemo
    quiero iniciar sesión
    para ingresar a la web

  Antecedentes:
    Dado que el usuario abre la página de SouceDemo

  @happyPath @login
  Escenario: Iniciar sesión con credenciales válidas
    Cuando ingresa el usuario válido
    * ingresa la contraseña válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra la página de inventario

  @unhappyPath @login
  Escenario: Iniciar sesión con credenciales no válidas
    Cuando ingresa el usuario no válido
    * la contraseña no válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de credenciales incorrectas

  @unhappyPath @login
  Escenario: Iniciar sesión con un usuario bloqueado
    Cuando ingresa el usuario bloqueado
    * ingresa la contraseña válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de usuario bloqueado

  @unhappyPath @login
  Escenario: Iniciar sesión con usuario vacío
    Cuando no ingresa el usuario
    * ingresa la contraseña válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de username requerido

  @unhappyPath @login
  Escenario: Iniciar sesión con contraseña vacía
    Cuando ingresa el usuario válido
    * no ingresa la contraseña
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de password requerida


