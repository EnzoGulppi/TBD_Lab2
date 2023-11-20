<template>
  <div class='emergencia-page'>
    <NavBar />
    <div id="emergenciaContent">
      <div>
        <br>
        <h1 class="text-left">Filtrar</h1>
        <section>
          <br>
          <div class="d-flex justify-content-between align-items-center mb-3">
            <h2 class="text-left">Filtrar emergencias por región</h2>
            <div>
              <select class="form-select" v-model="regionFiltrar">
                <option disabled selected hidden>Seleccione una región</option>
                <option v-for="objeto in regionesChile" :key="objeto">
                  {{ objeto }}
                </option>
              </select>
              <button class="btn btn-primary ml-3" @click="cargarEmergenciasFiltradas">
                Filtrar
              </button>
            </div>
          </div>
          <MapaHome :puntos="puntos" />
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
import NavBar from '../components/NavBar.vue'
import MapaHome from '~/components/MapaHome.vue'
export default {
  components: { NavBar, MapaHome },
  data() {
    return {
      // Filtrar tareas por region
      regionFiltrar: '',

      emergenciasFiltradas: null,
      puntos: [],

      // Select de regiones
      regionesChile: [
        'Arica y Parinacota',
        'Tarapacá',
        'Antofagasta',
        'Atacama',
        'Coquimbo',
        'Valparaíso',
        'Metropolitana',
        "O'Higgins",
        'Maule',
        'Ñuble',
        'Biobío',
        'La Araucanía',
        'Los Ríos',
        'Los Lagos',
        'Aysén',
        'Magallanes',
      ],
    }
  },
  methods: {
    async cargarEmergenciasFiltradas() {
      if (this.regionFiltrar == undefined) {
        alert('Debe escoger una región')
      }
      try {
        const response = await axios.get(
          `http://localhost:8080/api/emergencias/region/${this.regionFiltrar}`,
        )
        if (response.ok) {
            const data = await response.json();
            this.emergencias = data;
          } else {
            console.error('No se pudo obtener la lista de emergencias.');
          }
        } catch (error) {
          console.error('Error al buscar emergencias:', error);
        }
      }
    }
  };
  
</script>
<style>
#emergenciaContent {
  display: flex;
  align-items: flex-start;
  justify-content: center;
}

.emergencia-page {
  background-image: url('/fondo.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  min-height: 100vh;
}

/* Estilos personalizados para los títulos */
h1.text-left {
  text-align: left;

}

h2.text-left {
  margin-right: 20px;

}
</style>
