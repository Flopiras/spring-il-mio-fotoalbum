<script>
import axios from 'axios';
import AppHeader from './components/AppHeader.vue';
import PhotoIndex from './components/PhotoIndex.vue';
import photoShow from './components/PhotoShow.vue';
import MessageForm from './components/MessageForm.vue';

const endpoint = "http://localhost:8080/api/photos";

export default {
  components: { AppHeader, PhotoIndex, photoShow, MessageForm },

  data() {
    return {
      photos: null,
      selectedPhoto: null,
    }
  },

  methods: {
    async getPhotos(endpoint) {

      await axios.get(endpoint)
        .then(res => {
          this.photos = res.data;
        })

    },

    getFilteredPhotos() {

      return this.filteredPhotos = this.photos.filter(photo => photo.visible);
    },

    openShow(id) {

      this.photos.forEach((photo) => {

        if (photo.id === id) {
          this.selectedPhoto = photo;
        }
      });
    },

    closeShow() {
      this.selectedPhoto = null;
    }
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
    <photoIndex :photos="photos" @open-show="openShow" v-if="selectedPhoto == null" />

    <!--show page  -->
    <photoShow v-else :photo="selectedPhoto" @close-show="closeShow" />

    <!-- message form -->
    <MessageForm v-if="selectedPhoto == null" />

  </div>
</template>