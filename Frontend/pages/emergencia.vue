<template>
  <div class='emergency-page'>
      <NavBar />
      <br>
      <h1 style="text-align: center">Emergencias</h1>
      <div class="row">
        <div class="col">
          <div class="row">
            <div class="col-md-5">
              <section>
                <h2 class="text-center">Crear una emergencia</h2>
                <div class="table-responsive">
                  <table class="table">
                    <!-- Nombre de la emergencia -->
                    <tr>
                      <td><label for="nombre">Nombre:</label></td>
                      <td>
                        <input
                          v-model="nombre"
                          type="text"
                          id="nombre"
                          class="form-control"
                          value="test"
                        />
                      </td>
                    </tr>
                    <!-- Fecha -->
                    <tr>
                      <td><label for="fecha">Fecha:</label></td>
                      <td>
                        <input
                          v-model="fecha"
                          type="date"
                          id="fecha"
                          class="form-control"
                          value="2023-04-16"
                        />
                      </td>
                    </tr>
                    <!-- Institucion -->
                    <tr>
                      <td>Institución:</td>
                      <td>
                        <select
                          v-model="institucion"
                          class="form-select custom-select"
                          id="institucion"
                        >
                          <option value="" disabled selected hidden>
                            Selecciona una opción
                          </option>
                          <option
                            v-for="(objeto, indice) in instituciones"
                            :key="indice"
                          >
                            {{ objeto.nombre }}
                          </option>
                        </select>
                      </td>
                    </tr>
                    <!-- Region -->
                    <tr>
                      <td>Región:</td>
                      <td>
                        <select
                          v-model="id_region"
                          class="form-select custom-select"
                          id="id_region"
                        >
                          <option disabled selected hidden>
                            Selecciona una opción
                          </option>
                          <option
                            v-for="regionObj in regionesChile" :value="regionObj.valor">
                            {{ regionObj.nombre }}
                          </option>
                        </select>
                      </td>
                    </tr>
                  </table>
                </div>
                <h2 class="text-center">Gravedad</h2>
                <div class="table-responsive mb-3">
                  <table class="table">
                    <tr v-for="(objeto, indice) in gravedades" :key="indice">
                      <td>
                        <label>{{ objeto }}</label>
                      </td>
                      <td>
                        <input type="radio" :value="objeto" v-model="gravedad" />
                      </td>
                    </tr>
                  </table>
                </div>
                <!-- Seleccionar habilidades -->
                <h2 class="text-center">Habilidades asociadas</h2>
                <table class="habilidades">
                  <tr v-for="(objeto, indice) in habilidades" :key="indice">
                    <td>{{ objeto.nombre }}</td>
                    <td>
                      <input
                        type="checkbox"
                        :value="objeto.nombre"
                        v-model="habilidadesSeleccionadas"
                      />
                    </td>
                  </tr>
                </table>
              </section>
            </div>
            <div class="col-md-5 mb-3" id="mapa">
              <MapaRegistro
              @coordinatesSelected="handleCoordinatesSelected"
              ></MapaRegistro>
            </div>
          </div>

        </div>
      </div>
      <div class="row mt-4">
        <div class="col text-center">
          <button class="btn btn-success" @click="enviar">Completar</button>
        </div>
      </div>
    </div>
  </template>
  <script>
  import MapaRegistro from '../components/MapaRegistro.vue'
  import NavBar from '../components/NavBar.vue'
  import axios from 'axios'

  export default {
    name: 'EmergenciasView',
    components: { NavBar },
    data() {
      return {
        // Form crear una emergencia
        nombre: '',
        fecha: '',
        institucion: '',
        gravedad: '',
        habilidadesSeleccionadas: [],
        selectedCoordinates: null,
        id_region: '',
        regionesChile: [
          {nombre: 'Arica y Parinacota', valor: 1},
          {nombre: 'Tarapaca', valor: 2},
          {nombre: 'Antofagasta', valor: 3},
          {nombre: 'Atacama', valor: 4},
          {nombre: 'Coquimbo', valor: 5},
          {nombre: 'Valparaiso', valor: 6},
          {nombre: 'Metropolitana', valor: 7},
          {nombre: 'Ohiggins', valor: 8},
          {nombre: 'Maule', valor: 9},
          {nombre: 'Ñuble', valor: 10},
          {nombre: 'Biobio', valor: 11},
          {nombre: 'La Araucania', valor: 12},
          {nombre: 'Los Rios', valor: 13},
          {nombre: 'Los Lagos', valor: 14},
          {nombre: 'Aysen', valor: 15},
          {nombre: 'Magallanes', valor: 16},
        ],

        // Datos traidos desde el backend
        habilidades: [],
        instituciones: [], // Lista de instituciones
        gravedades: ['Muy grave', 'Grave', 'Media'],
      }
    },
    methods: {
     // Cargar las instituciones desde la API mediante Try-Catch para manejar posibles errores
      async cargarInstituciones() {
        try {
          const respuesta = await axios.get(
            'http://localhost:8080/api/instituciones'
          )
          this.instituciones = respuesta.data
        } catch (error) {
          console.log(error)
        }
      },
      handleCoordinatesSelected(coordinates) {
        this.selectedCoordinates = coordinates;
        console.log('Coordenadas seleccionadas:', this.selectedCoordinates);
      },
      // Cargar las habilidades desde la API mediante Try-Catch para manejar posibles errores
      async cargarHabilidades() {
        try {
          const respuesta = await axios.get(
            'http://localhost:8080/api/habilidades'
          )
          this.habilidades = respuesta.data
        } catch (error) {
          console.log(error)
        }
      },

      async enviar() {
        // Verificar que todos los campos estén completos
        if (
          this.nombre == '' ||
          this.fecha == '' ||
          this.institucion == '' ||
          this.gravedad == '' ||
          this.habilidadesSeleccionadas.length == 0 ||
          this.selectedCoordinates == null ||
          this.id_region == ''
        ) {
          alert('Por favor, complete todos los campos')
          return
        }

        // Crear objeto emergencia
        const emergencia = {
          nombre: this.nombre,
          gravedad: this.gravedad,
          fecha: this.fecha,
          institucion: this.institucion,
          habilidades: this.habilidadesSeleccionadas,
          estado: 'Activa',
          latitud: this.selectedCoordinates.lat,
          longitud: this.selectedCoordinates.lng,
          id_region: this.id_region
        }
        // Enviar emergencia
        try {
          const response = await axios.post(
            'http://localhost:8080/api/emergencias',
            emergencia
          )
          console.log(response)
          var idEmergencia = response.data.id
        } catch (error) {
          console.log(error)
        }

        // Enviar habilidades
        for (let i = 0; i < this.habilidadesSeleccionadas.length; i++) {
          // Buscar el id de la habilidad seleccionada
          const idHabilidad = this.habilidades.find(
            (e) => e.nombre == this.habilidadesSeleccionadas[i]
          ).idHabilidad
          console.log('idHabilidad: ', idHabilidad)

          // Hacer petición a backend
          const responseHabilidad = await axios.post(
            'http://localhost:8080/api/emergencia-habilidades',
            {
              idHabilidad: idHabilidad,
              idEmergencia: idEmergencia,
            }
          )
          console.log(responseHabilidad)
          alert('Emergencia creada con éxito')
          window.location.reload()
        }
      },
    },
    created() {
      this.cargarInstituciones()
      this.cargarHabilidades()
    },
  }
  </script>
  <style>

  /* Secciones general */
  .contenido section {
    width: 50%;
    /* border-style: solid; */
    padding: 30px;
    /* background-color: black; */
  }

  .contenido section h2 {
    text-align: center;
  }

  .table {
    margin: auto;
    border-collapse: collapse;
    width: 75%;
    border-radius: 10px;
    overflow: hidden;
  }

  .table + h2 {
    margin-top: 15px;
  }

  .h2 + table {
    margin-top: 5px;
  }
  
  .habilidades{
    margin-left: 70px;
  
  }

  .table th,
  .table td {
    padding: 5px;
    background-color: rgb(37, 174, 192);
    text-align: center;
  }
  .emergency-page {
    background-image: url('/fondo.jpg');
    background-size: cover; /* Ajusta el tamaño de la imagen para cubrir el contenedor */
    background-repeat: no-repeat; /* Evita que la imagen se repita */
    background-position: center; /* Centra la imagen en el contenedor */
    min-height: 100vh;
  }
  .emergency-page h1{
    background-color: white;
  }

  .col-md-5 {
  margin-right: 90px; /* Ajusta el margen derecho según sea necesario */
}

#mapa {
  margin-top: 30px; /* Ajusta el margen superior del mapa según sea necesario */
}
  </style>
