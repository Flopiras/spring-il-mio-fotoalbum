<script>
import AppHeader from './components/AppHeader.vue';
import axios from 'axios';

const endpoint = "http://localhost:8080/api/photos";

export default {
  components: { AppHeader },

  data() {
    return {
      photos: [],
    }
  },

  methods: {
    async getPhotos(endpoint) {

      await axios.get(endpoint)
        .then(res => {
          this.photos = res.data;
        })

    },
  },

  created() {
    this.getPhotos(endpoint);
  }
};
</script>

<template>
  <!-- header -->
  <appHeader />
</template>