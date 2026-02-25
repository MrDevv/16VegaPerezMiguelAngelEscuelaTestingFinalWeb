#language: es
  @regression @login
  Característica: Iniciar sesión en SouceDemo

    Como usuario de SouceDemo
    quiero iniciar sesión
    para ingresar a la web

  Antecedentes:
    Dado que el usuario abre la página de SouceDemo

  @happyPath
  Escenario: Iniciar sesión con credenciales válidas
    Cuando ingresa el usuario válido
    * la contraseña válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra la página de inventario

  @unhappyPath
  Escenario: Iniciar sesión con credenciales no válidas
    Cuando ingresa el usuario no válido
    * la contraseña no válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de credenciales incorrectas

  @unhappyPath
  Escenario: Iniciar sesión con un usuario bloqueado
    Cuando ingresa el usuario bloqueado
    * la contraseña válida
    * hace clic en el botón iniciar sesión
    Entonces se muestra un mensaje de error con un texto de usuario bloqueado

