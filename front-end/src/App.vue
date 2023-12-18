<script>
import axios from 'axios';
import AppHeader from './components/AppHeader.vue';
import PhotoIndex from './components/PhotoIndex.vue';

const endpoint = "http://localhost:8080/api/photos";

export default {
  components: { AppHeader, PhotoIndex },

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

  <!-- main -->
  <div class="container">

    <!-- index page -->
    <photoIndex :photos="photos" />

  </div>
</template>