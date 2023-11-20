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
                          v-model="region"
                          class="form-select custom-select"
                          id="region"
                        >
                          <option value="" disabled selected hidden>
                            Selecciona una opción
                          </option>
                          <option
                            v-for="(objeto, indice) in regionesChile"
                            :key="indice"
                          >
                            {{ objeto }}
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
        region: '',
        regionesChile: [
          'Arica y Parinacota',
          'Tarapacá',
          'Antofagasta',
          'Atacama',
          'Coquimbo',
          'Valparaíso',
          'Metropolitana',
          'O\'Higgins',
          'Maule',
          'Ñuble',
          'Biobío',
          'La Araucanía',
          'Los Ríos',
          'Los Lagos',
          'Aysén',
          'Magallanes'
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
          this.region == ''
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
          region: this.region
        }
        if (this.region === 'Metropolitana') {
          emergencia.region = 'POLYGON((-70.896607 -32.933391,-71.709595 -33.969179,-70.720825 -33.919051,-69.808960 -34.242080,-69.781494 -33.338177,-70.896607 -32.933391))';
        }else if(this.region === 'Arica y Parinacota'){
          emergencia.region = 'POLYGON((-69.472047 -17.504372,-69.142457 -18.152809,-69.307252 -19.131327,-70.290528 -19.224717,-70.367432 -18.351047,-69.472047 -17.504372))';
        }else if(this.region === 'Tarapaca'){
          emergencia.region = 'POLYGON((-70.285035 -19.231632,-70.010377 -21.410455,-69.644166 -21.514830,-68.479616 -20.941345,-68.957521 -18.948286,-70.285035 -19.231632))';
        }else if(this.region === 'Antofagasta'){
          emergencia.region = 'POLYGON((-70.061647 -21.439006,-70.534059 -25.825850,-67.315065 -24.012596,-67.194215 -22.802767,-68.490602 -20.947330,-70.061647 -21.439006))';
        }else if(this.region === 'Atacama'){
          emergencia.region = 'POLYGON((-70.629274 -26.043209,-71.497194 -29.186934,-69.970094 -29.483837,-68.322145 -27.026099,-68.563844 -25.290644,-70.629274 -26.043209))';
        }else if(this.region === 'Coquimbo'){
          emergencia.region = 'POLYGON((-71.500856 -29.190131,-71.533815 -32.193819,-70.325319 -32.277456,-69.830934 -30.144729,-69.973757 -29.496587,-71.500856 -29.190131))';
        }else if(this.region === 'Valparaiso'){
          emergencia.region = 'POLYGON((-71.835937 -33.894357,-70.847168 -32.922249,-70.094604 -33.055867,-70.737304 -32,023213,-71.533813 -32.190722,-71.835937 -33.894357))';
        }else if(this.region === 'Ohiggins'){
          emergencia.region = 'POLYGON((-71.832275 -33.915633,-70.931396 -34.156894,-70.426025 -33.870035,-70.371093 -35.002628,-72.062988 -34.691568,-71.832275 -33.915633))';
        }else if(this.region === 'Maule'){
          emergencia.region = 'POLYGON((-72.107010 -34.841066,-70.423355 -35.039199,-70.448074 -35.887030,-70.957178 -36.377171,-72.694778 -35.953758,-72.107010 -34.841066))';
        }else if(this.region === 'Ñuble'){
          emergencia.region = 'POLYGON((-72.764470 -36.030953,-71.105968 -36.460293,-71.174220 -37.088978,-72.334488 -36.958200,-72.863151 -36.448587,-72.764470 -36.030953))';
        }else if(this.region === 'Biobio'){
          emergencia.region = 'POLYGON((-73.522058 -38.405718,-72.552892 -37.631458,-71.065018 -38.084104,-71.208345 -37.132521,-72.921448 -36.569999,-73.522058 -38.405718))';
        }else if(this.region === 'La Araucania'){
          emergencia.region = 'POLYGON((-73.201278 -39.367274,-71.508650 -39.583274,-73.501582 -38.491242,-72.552892 -37.658479,-71.071843 -38.110960,-73.201278 -39.367274))';
        }else if(this.region === 'Los Rios'){
          emergencia.region = 'POLYGON((-73.699511 -40.216820,-71.897681 -40.565104,-73.208103 -39.425291,-71.727054 -39.562230,-71.706578 -40.341786,-73.699511 -40.216820))';
        }else if(this.region === 'Los Lagos'){
          emergencia.region = 'POLYGON((-73.031082 -43.727752,-71.788912 -44.067097,-74.764228 -40.279332,-71.877206 -40.596206,-71.754354 -42.046701,-73.031082 -43.727752))';
        }else if(this.region === 'Aysen'){
          emergencia.region = 'POLYGON((-73.060564 -43.723173,-71.77181 -44.05938,-73.12523 -49.15964,-75.603293 -48.511322,-75.639227 -46.719030,-73.060564 -43.723173))';
        }else if(this.region === 'Magallanes'){
          emergencia.region = 'POLYGON((-73.184613 -49.173491,-66.442327 -55.136311,-67.208925 -55.882397,-73.465429 -54.081906,-75.616093 -48.861903,-73.184613 -49.173491))';
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
