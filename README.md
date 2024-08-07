Escuela Politecnica Nacional
Proyecto Programacion Orientada a Objetos.

Estudiante: Carlos Perez

Fecha: 08/08/2024

Gestión de Aulas y laboratorios de la ESFOT.

Objetivo General: Agilizar la reserva de aulas y laboratorios de la ESFOT.


Objetivos especificos: 

-Crear un CRUD para el administrador permitiendo la gestion de aulas, usuarios y laboratorios.

-Permitir la reserva de laboratorios y aulas por parte del usuario.

-Integrar una conexion con la base de MongoDB en la nube.

- ## LOGIN:
  
  ![image](https://github.com/user-attachments/assets/9449eb67-f203-4631-a4c1-d65eeac934d1)

  En primer lugar al momento de ejecutar el programa, si existe un usuario registrado debera ingresar con sus respectivas credenciales ademas del seleccionar el rol con el cual va a ingresar.

  -CODIGO:
  
  ![image](https://github.com/user-attachments/assets/5545b56d-c3c9-46d7-9da9-e862f8384f74)
  
  Internamente se realiza un control de los campos ingresados por el usuario, en caso de que los campos esten vacios o que no seleccione ningun rol aparecera un mensaje el cual indicara al usuario que debe llenar los respectivos campos.
  Dependiendo del rol seleccionado internamente el programa se conectara con la base de datos de MongoDB, ademas de ingresar a la respectiva coleccion que es respectivo al rol seleccionado por el usuario y posteriormente el programa buscara dentro de la base de datos si   los datos estan registrados se permitira al usuario acceder, caso contrario no permitira ingresar indicando que el usuario o contraseña estan incorrectos.


- ## REGISTRO:

![image](https://github.com/user-attachments/assets/43934787-bd00-4ed8-b742-54c10b20736b)

En caso de que el usuario no este registrado podra acceder al registro de nuevos usuarios, sin embargo, unicamente se pueden registrar profesores y alumnos. Al llenar una serie de campos y seleccionar el rol se podra registrar un nuevo usuario.

  -CODIGO:

![image](https://github.com/user-attachments/assets/49df9d31-c1e2-4033-b094-e0a572984769)

El codigo se encargara de controlar que los respectivos datos para el registro de un usuario esten llenos, ademas de que se encargara de controlar que la cedula ingresada se valida verificando la cantidad de digitos.

![image](https://github.com/user-attachments/assets/4a938328-a637-4c5b-8e74-cddccc139c7d)

A continuacion se creara un objeto para el registro, y los respectivos datos seran seteados en dicho objeto. Posteriormente el programa se encargara de ingresar a la basa de datos en la coleccion exacta para realizar la escritura o 'registro' del nuevo usuario.

Finalemente con el boton de volver se permitira al usuario volver a la pantalla de login.

  -CLASE PARA EL REGISTRO:

  ![image](https://github.com/user-attachments/assets/ae770d60-39c9-4522-99f4-6ddcfaf8bb1e)

  La clase en primer lugara contara con una serie de atributos que podran ser seteados en el registro de un nuevo usuario, y a continuacion por medio de los constructores se podran señalar a dichos atributos.

  ![image](https://github.com/user-attachments/assets/d1aeb09d-fd2b-427d-92c0-10f3766f1261)

  A continuacion, se generan los getters y setter para obtener ademas de settear los atributos obtenidos al crear el objeto.

  - ## Administrador:

  ![image](https://github.com/user-attachments/assets/f328baf9-5d4d-4c80-acd7-172b7280630c)

  El administrador contara con un crud para cada elemento en este caso: Usuarios, aulas y laboratorios. Ademas, de un boton para cerrar sesion que permitira al usuario volver a la pantalla de login.

  - Usuarios:

  ![image](https://github.com/user-attachments/assets/aca75497-c7d1-483f-a77a-5012489a318a)

  El administrador podra registrar, buscar, actualizar y elimiminar usuarios.

  ## Registro Usuarios:
  
  ![image](https://github.com/user-attachments/assets/cb5ab5a9-b445-4ea7-9a58-a0c62b280dd3)

  Cuenta con los mismos campos que el registro de usuarios normal, sin embargo es importante recalcar que el administrador si podra hacer el registro de nuevos administradores en caso de ser necesario.

  ![image](https://github.com/user-attachments/assets/bec5e7ca-8de4-4c6e-9f20-b5ae510e7f92)

  Internamente el codigo sigue el mismo proceso que el registro de usuarios normal, ingresando a las colecciones dependiendo de la seleccion del usuario creando un objeto y seteando los respectivos atributos en el mismo     para posteriormente registrarlo dentro de la base de datos.

  ## Eliminar Usuarios:

  ![image](https://github.com/user-attachments/assets/8dde15d8-2c9a-4715-be94-19c6668b3b42)

  El administrador podra eliminar un usuario por medio de su cedula ademas del rol del usuario a eliminar.

  ![image](https://github.com/user-attachments/assets/9745aad6-58bd-4643-ad4e-a27f1a9287aa)

  El codigo inicialmente hara el control de los campos obligando al usuario llenar los campos para poder eliminar un usuario, ademas de controlar que la cedula ingresada sea valida por medio del control de los digitos de la misma.

  En caso de encontrar el usuario lo eliminara de la base de datos caso contrario se mostrara que hubo un error al momento de eliminar al usuario.




  

  




