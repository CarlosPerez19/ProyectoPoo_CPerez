Escuela Politecnica Nacional
Proyecto Programacion Orientada a Objetos.

Estudiante: Carlos Perez

Fecha: 08/08/2024

Video: https://www.youtube.com/watch?v=mCWslH_x93k

Gestión de Aulas y laboratorios de la ESFOT.

Objetivo General: Agilizar la reserva de aulas y laboratorios de la ESFOT.


Objetivos especificos: 

-Crear un CRUD para el administrador permitiendo la gestion de aulas, usuarios y laboratorios.

-Permitir la reserva de laboratorios y aulas por parte del usuario.

-Integrar una conexion con la base de MongoDB en la nube.

- ## Encriptacion:

![image](https://github.com/user-attachments/assets/7a4c6681-6e92-4e4b-8392-54180781a72b)

Este metodo permitira encriptar las respectivas contraseñas que posteriormente seran enviadas a la base de datos.


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

  - ## Usuarios:

  ![image](https://github.com/user-attachments/assets/aca75497-c7d1-483f-a77a-5012489a318a)

  El administrador podra registrar, buscar, actualizar y elimiminar usuarios.

  ## Registro Usuarios:
  
  ![image](https://github.com/user-attachments/assets/cb5ab5a9-b445-4ea7-9a58-a0c62b280dd3)

  Cuenta con los mismos campos que el registro de usuarios normal, sin embargo es importante recalcar que el administrador si podra hacer el registro de nuevos administradores en caso de ser necesario, ademas el boton volver le permitira al CRUD de usuarios..

  ![image](https://github.com/user-attachments/assets/bec5e7ca-8de4-4c6e-9f20-b5ae510e7f92)

  Internamente el codigo sigue el mismo proceso que el registro de usuarios normal, ingresando a las colecciones dependiendo de la seleccion del usuario creando un objeto y seteando los respectivos atributos en el mismo     para posteriormente registrarlo dentro de la base de datos.

  ## Eliminar Usuarios:

  ![image](https://github.com/user-attachments/assets/8dde15d8-2c9a-4715-be94-19c6668b3b42)

  El administrador podra eliminar un usuario por medio de su cedula ademas del rol del usuario a eliminar, ademas el boton volver le permitira al CRUD de usuarios.

  ![image](https://github.com/user-attachments/assets/9745aad6-58bd-4643-ad4e-a27f1a9287aa)

  El codigo inicialmente hara el control de los campos obligando al usuario llenar los campos para poder eliminar un usuario, ademas de controlar que la cedula ingresada sea valida por medio del control de los digitos de la misma.

  En caso de encontrar el usuario lo eliminara de la base de datos caso contrario se mostrara que hubo un error al momento de eliminar al usuario.

  

## Actualizar Usuarios:

![image](https://github.com/user-attachments/assets/b21835e2-1947-41b5-9c80-23ae23dd84a0)

El administrador podra actualizar los usuarios ya registrados, debera ingresar la cedula del usuario ademas de elegir el elemento que quiere actualizar ya sea el nombre, edad, etc. Posteriormente debera seleccionar el rol del usuario a actualizar.

![image](https://github.com/user-attachments/assets/9fdc7785-04b9-4f7f-9b69-e48ae8174fc7)

Se realiza el respectivo control para que los campos esten llenos y una vez se valida la cedula por medio de los digitos.

![image](https://github.com/user-attachments/assets/1cb8b2b0-1769-48bd-b591-a9c7a4dfb41f)

De acuerdo a la seleccion del rol se ingresara a la coleccion dentro de la base de datos, ademas para actualizar se usara el elemento ingresado por el usuario ademas del campo a actualizar para posteriormente ser reemplazado.



## Buscar Usuarios:

![image](https://github.com/user-attachments/assets/2e99c593-8293-4b69-ba27-b8555a8e4ddc)

El administrador podra buscar los usuarios registrados por medio de su cedula y el rol del usuario a buscar, presentandose los respectivos datos del usuario buscado.

![image](https://github.com/user-attachments/assets/0db5137c-6db0-48ab-a6d0-37d7f32de970)

El programa ingresara a la coleccion seleccionada por el rol del usuario, buscando la cedula dentro de la misma en caso de encontrarlo presentara los datos registrados del usuario en recuardo. En caso de no encontrar la cedula se mostrara que la cedula no esta registrada.

- ## Laboratorios:

![image](https://github.com/user-attachments/assets/f3f9a857-b818-4c16-a3cf-2c0d93a0f987)

 El administrador podra registrar, buscar, actualizar y elimiminar laboratorios.
 

 ## Registrar Laboratorios:

 ![image](https://github.com/user-attachments/assets/6a191c2a-dc9a-459c-acaa-2a2690aea288)

 El administrador debera llenar los respectivos campos para poder registrar un nuevo laboratorio.

 ![image](https://github.com/user-attachments/assets/c8271337-4b30-4433-a346-3f45f9f34782)

 El programa se encargara de controlar que los respectivos campos esten llenos para poder realizar el registro.

 ![image](https://github.com/user-attachments/assets/0f1a7c9f-4bde-4892-bfab-974a770d4ae6)

 Al conectarse con la base de datos se ingresara a la respectiva coleccion para esta vez poder registrar el laboratorio dentro de la base de datos.

 - Clase laboratorios:

![image](https://github.com/user-attachments/assets/54a7ee71-c940-4d66-85f2-b76b6c140fb7)

Se asignan los respectivos atributos para la creacion del objeto y se crean los constructores para poder señar a los respectivos atribus

![image](https://github.com/user-attachments/assets/3d5c99c1-c455-46f6-bc4f-e6f9f4080f27)

Se crean los getters y settear para poder obtener y almacenar los respectivos atributos en el objeto.

 ## Eliminar Laboratorios:

 ![image](https://github.com/user-attachments/assets/42f92dac-c9a4-4189-b62c-08ce4434bd91)

 El administrador podra eliminar laboratorios por medio del codigo del laboratorio.

 ![image](https://github.com/user-attachments/assets/c877e02a-2e48-4b8a-96b8-7d35a15d1eb3)

 En primer lugar se realiza el control respectivo para asegurarse que el campo esta lleno, posteriormente se ingresa en la base de datos en la coleccion de laboratorios en caso de encontrar el codigo del laboratorio se eliminara el laboratorio resgitrado, caso contrario aprecera una ventana que mostrara un error al eliminar el laboratorio.

 ## Actualizar Laboratorios:
 
![image](https://github.com/user-attachments/assets/b4de1f77-f360-4014-8c48-12c6b6a4f622)

Al igual que al momento de eliminar un laboratorio el administrador debera ingresar el codigo del laboratorio a actualizar ademas de seleccionar el campo que quiere actualizar.

![image](https://github.com/user-attachments/assets/32e04136-34ed-4256-a37f-e350028605ce)

En primer se realiza el respectivo control para que los campos esten llenos, posteriormente se ingresa a la base de datos a la coleccion respectiva y por medio de la seleccion del campo a actualizar y el nuevo dato se actualizara dentro de la base de datos.

## Buscar Laboratorios:

![image](https://github.com/user-attachments/assets/3b1b6cb1-a6a9-4413-9617-eff5905318a7)

El administador debera ingresar el codigo del laboratorio a buscar y posteriormente se presentara un recuadro con los respectivos datos almacenados.

![image](https://github.com/user-attachments/assets/cfb77ec2-3dbc-41e9-abb4-84980c43adaf)

En primer lugar se realiza el respectivo control con respecto a los campos vacios.

El programa ingresara a la coleccion en la base de datos en caso de encotrar el codigo del laboratorio mostrara una ventan con los respectivos datos del laboratorio, en caso de no encontrar el laboratorio se presentara un mensaje mencionando que el laboratorio no ha sido registrado.

- ## Aulas:

![image](https://github.com/user-attachments/assets/8ca2e525-06ca-4d03-a89e-10ca575cc8a9)

El administrador contara una vez mas con un CRUD para poder realizar la respectiva gestion de aulas.

## Registrar Aulas:

![image](https://github.com/user-attachments/assets/48c38ad2-c565-4138-a534-859aceb475b6)

El administrador podra registrar una nueva aula llenando los respectivos campos para el registro.

![image](https://github.com/user-attachments/assets/677bff0a-78b5-4bf8-a464-9d65624d0a65)

Se realiza el respectivo control de los campos vacios y crea un objeto en el que se setearan los respectivos atributos. Se realiza la conexion con la base de datos e ingreso con la respectiva coleccion para finalmente poder registrar el aula en la base de datos.

- Clase Aulas:

![image](https://github.com/user-attachments/assets/67226119-a9b9-4d9e-b452-6845f1474e61)

Se asignan los respectivos atributos a la clase para que posteriormente puedan ser seteados, ademas de generar los respectivos contructores.

![image](https://github.com/user-attachments/assets/a4774bbd-f030-4f3a-b661-97ddd4ff615a)

Se generan los getters y setters para poder obtener y setear los respectivos atributos del objeto.



## Eliminar Aulas:

![image](https://github.com/user-attachments/assets/c69dca4b-5889-4cd1-a889-07ce17673824)

El adiministrador podra eliminar un aula por medio de su respectivo codigo.

![image](https://github.com/user-attachments/assets/3aa89684-a578-4fc1-b5ae-bb17249f5c95)

Se realiza el respectivo control de los campos vacios, se realiza la conexion con la base de datos y la respectiva coleccion en caso de que el codigo del aula se encontrado se eliminara de la base de datos en caso contrario se presentara un error.


## Actualizar Aulas:

![image](https://github.com/user-attachments/assets/f728a1cc-dbfd-4e92-bf15-beb5dc5565db)

El administrador podra actualizar un aula por medio de su codigo, ademas debera seleccionar el campo que quiere actualizar e ingresar un nuevo valor.

![image](https://github.com/user-attachments/assets/6cb421f0-aaab-46fb-bf55-72c582178ffd)

Al conectarse con la base de datos y su respectiva coleccion se buscara el codigo del aula y por medio de la seleccion del usuario se actualizara el campo respectivo.

## Buscar Aulas:

![image](https://github.com/user-attachments/assets/b7bda8a9-ee62-4864-888d-0fae00859402)

El administrador podra buscar un aula por medio del respectivo codigo del aula.

![image](https://github.com/user-attachments/assets/294e5fdf-68f0-42e2-ae6a-b1634f5e9732)

Se realiza el control de los campos vacios, y en caso de encontrar el aula se mostrara en cuadro los respectivos datos del aula en caso de no encontrar el codigo aparecera un mensaje indicando que el aula no esta registrada.

- ## Profesor:

![image](https://github.com/user-attachments/assets/2a17e5f5-bf7f-420a-979f-1d49c48cd4d1)

El profesor podra realizar la reserva de aulas y laboratorios.

![image](https://github.com/user-attachments/assets/7319afc6-62b2-4d82-8324-de35283beaf0)

El profesor debera llenar los respectivos campos de reserva para poder realizarla.

![image](https://github.com/user-attachments/assets/329a8459-d994-41cc-a508-315497b85cf9)

Se realiza el respectivo control de variables para que estas no esten vacias.

![image](https://github.com/user-attachments/assets/f5d38330-710e-49db-8cba-f34f3756f826)

![image](https://github.com/user-attachments/assets/d624d34a-1b4f-48ff-b6e6-99198a73036c)

A continuacion se crerara un objeto con los atributos de la reserva, y posteriormente se hara la conexion con la base de datos y la respectiva coleccion de reservas. En caso de que existe una reserva en el mismo horario se mostrara un mensaje indicando que el laboratorio o aula ya esta reservado en ese horario

- ## Estudiante:

![image](https://github.com/user-attachments/assets/3b053dec-7cff-4e99-823a-9247fdf47bff)

Los estudiantes unicamente podran realizar la reserva de aulas, deberan los respectivos campos para la reserva

![image](https://github.com/user-attachments/assets/60bb1c38-c72a-4db0-a835-f5ce4b352eef)

Se realiza el control de los campos vacios, ademas de crear un objeto seteando los respectivos atributos.

![image](https://github.com/user-attachments/assets/bef62078-0602-4258-bb78-494c588ad6ed)

Se realiza la conexion con la base de datos y su respectiva coleccion, ademas de registrar la reserva.

![image](https://github.com/user-attachments/assets/d64e44dd-676e-4fd4-87e9-9c3fd240d142)

En caso ya existir un reserva en el horario se mostrara un mensaje indicando que el aula ya esta reservada en ese horario.

- # Clase Reserva:

![image](https://github.com/user-attachments/assets/ac99ca01-c720-4f69-9b41-39bfd4b7a4e6)

Se asgina los respectivos atributos para la creacion del objeto para las reservas.

![image](https://github.com/user-attachments/assets/c7d3fb54-a8b7-4925-a1b5-4bd0d15018e5)

Se generan los respectivos getters y setters para poder obtener o setear los atributos del objeto.


























 


 


 













  

  




