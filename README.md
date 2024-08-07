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

- LOGIN:
  
  ![image](https://github.com/user-attachments/assets/9449eb67-f203-4631-a4c1-d65eeac934d1)

  En primer lugar al momento de ejecutar el programa, si existe un usuario registrado debera ingresar con sus respectivas credenciales ademas del seleccionar el rol con el cual va a ingresar.

    -CODIGO:
  
  ![image](https://github.com/user-attachments/assets/5545b56d-c3c9-46d7-9da9-e862f8384f74)
  
  Internamente se realiza un control de los campos ingresados por el usuario, en caso de que los campos esten vacios o que no seleccione ningun rol aparecera un mensaje el cual indicara al usuario que debe llenar los respectivos campos.
  Dependiendo del rol seleccionado internamente el programa se conectara con la base de datos de MongoDB, ademas de ingresar a la respectiva coleccion que es respectivo al rol seleccionado por el usuario y posteriormente el programa buscara dentro de la base de datos si   los datos estan registrados se permitira al usuario acceder, caso contrario no permitira ingresar indicando que el usuario o contraseña estan incorrectos.


- REGISTRO:

![image](https://github.com/user-attachments/assets/43934787-bd00-4ed8-b742-54c10b20736b)

En caso de que el usuario no este registrado podra acceder al registro de nuevos usuarios, sin embargo, unicamente se pueden registrar profesores y alumnos. Al llenar una serie de campos y seleccionar el rol se podra registrar un nuevo usuario.

    -CODIGO:

    ![image](https://github.com/user-attachments/assets/49df9d31-c1e2-4033-b094-e0a572984769)

    ![image](https://github.com/user-attachments/assets/4a938328-a637-4c5b-8e74-cddccc139c7d)



  




