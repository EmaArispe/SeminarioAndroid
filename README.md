# Proyecto de Aplicación de Películas - Seminario Unicen

Este es un proyecto de una aplicación para gestionar una lista de películas. La aplicación permite cargar, visualizar y gestionar películas usando una API externa.
Se utiliza el patrón de arquitectura MVVM para separar la lógica de la interfaz de usuario, las fuentes de datos y el modelo de la aplicación.

## Estructura del Proyecto

El proyecto está organizado en paquetes de acuerdo a las responsabilidades de cada clase. A continuación se describe brevemente la estructura:

### 1. **activities**
   - **`MainActivity`**: Es la actividad principal que inicia la aplicación.
   - **`MovieActivity`**: Actividad encargada de mostrar los detalles de las películas.

### 2. **dataSource**
   - **`ActivityMoviesDataSource`**: Clase que maneja la obtención de datos de las películas desde una API o fuente de datos externa.

### 3. **dto**
   - **`ActivityListMoviesDto`**: Objeto de transferencia de datos (DTO) que representa una lista de películas.
   - **`ActivityMoviesDto`**: DTO que representa una película en particular.
   - **`GenreDto`**: DTO para representar un género.
   - **`GenreListDto`**: DTO que representa una lista de géneros.

### 4. **model**
   - **`MoviesViewModel`**: ViewModel que contiene la lógica de presentación y el estado para la vista de la lista de películas. Se comunica con la capa de datos para obtener la información.

### 5. **movies**
   - **`Movie`**: Modelo que representa una película.
   - **`MovieAdapter`**: Adaptador utilizado para mostrar la lista de películas en un RecyclerView.
   - **`MovieModule`**: Clase encargada de manejar la configuración de dependencias del módulo de películas.
   - **`MoviesApi`**: Clase encargada de las llamadas a la API para obtener los datos de las películas.

### 6. **repository**
   - **`ActivityMoviesRepository`**: Repositorio que maneja las operaciones de obtención de datos. Actúa como una capa intermedia entre el DataSource y el ViewModel.

### 7. **SeminarioApp**
   - Clase principal de la aplicación que inicializa las configuraciones necesarias para el funcionamiento de la misma.

## Funcionalidades

La aplicación cuenta con las siguientes características:

- **Cargar películas**: Un botón en la pantalla principal permite obtener la lista de películas desde una API externa.
- **Mostrar lista de películas**: La lista de películas es mostrada en un RecyclerView.
- **Detalles de la película**: Al seleccionar una película de la lista, se abre una nueva actividad con información detallada de la película.
- **Manejo de géneros**: Los géneros de las películas se manejan a través de objetos DTO.
- **Manejo de errores**: Si ocurre algún error en la carga de películas, se muestra un mensaje en pantalla.

## Pantallas

1. **Pantalla Principal**:
   - Muestra un título, un botón para cargar las películas y una lista con las películas obtenidas de la API.
   - En caso de error al cargar las películas, se muestra un mensaje en la parte inferior de la pantalla.

2. **Pantalla de Detalles de Película**:
   - Muestra la información detallada de la película seleccionada, como su título, género y descripción.

## Tecnologías Utilizadas

- **Lenguaje**: Kotlin y Java
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **API Externa**: Para la obtención de películas y géneros.
- **Dependencias**: El proyecto utiliza un sistema modularizado con `MovieModule` para la inyección de dependencias.

