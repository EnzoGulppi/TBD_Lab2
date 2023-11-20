<template>
    <div class="detalles-page">
      <h1>Buscar Emergencias por Región</h1>
      <div class="search-container">
        <input v-model="region" placeholder="Ingresa la región" class="region-input">
        <button @click="buscarEmergencias" class="search-button">Buscar</button>
      </div>
  
      <ul v-if="emergencias.length" class="emergencias-list">
        <li v-for="emergencia in emergencias" :key="emergencia.id" class="emergencia-item">
          {{ emergencia.nombre }} - {{ emergencia.estado }}
        </li>
      </ul>
      <p v-else class="no-emergencias">No hay emergencias para esta región.</p>
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
  
  <style scoped>
  /* Estilos para emular la apariencia anterior */
  .detalles-page {
    text-align: center;
    padding: 20px;
  }
  
  .search-container {
    margin-bottom: 20px;
  }
  
  .region-input {
    padding: 8px;
    margin-right: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .search-button {
    padding: 8px 15px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  
  .emergencias-list {
    list-style: none;
    padding: 0;
  }
  
  .emergencia-item {
    margin-bottom: 5px;
  }
  
  .no-emergencias {
    font-style: italic;
  }
  </style>
  