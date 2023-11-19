<template>
    <div>
      <h1>Buscar Emergencias por Región</h1>
      <input v-model="region" placeholder="Ingresa la región">
      <button @click="buscarEmergencias">Buscar</button>
  
      <ul v-if="emergencias.length">
        <li v-for="emergencia in emergencias" :key="emergencia.id">
          {{ emergencia.nombre }} - {{ emergencia.estado }}
        </li>
      </ul>
      <p v-else>No hay emergencias para esta región.</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        region: '',
        emergencias: []
      };
    },
    methods: {
      async buscarEmergencias() {
        try {
          const response = await fetch(`/api/emergencias/region/${this.region}`);
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
  